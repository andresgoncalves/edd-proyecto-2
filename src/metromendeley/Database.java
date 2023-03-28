package metromendeley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author USUARIO
 */
public class Database {
    
    public static Summary loadSummary(File file) throws IOException {
        String title = null;
        String body = null;
        String[] authors;
        String[] keywords = {};
        List<String> authorList = new List<>();
        
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line;
            String reading = "title";
            while((line = reader.readLine()) != null){
                line = line.strip();
                if(line.isBlank()) {
                    
                }
                else if("autores".equalsIgnoreCase(line)){
                    reading = "autores";
                }
                else if("resumen".equalsIgnoreCase(line)){
                    reading = "resumen";
                }
                else if(line.toLowerCase().startsWith("palabras claves")){
                    keywords = line.split(":")[1].replace(".", "").split(",");
                    for(int i = 0; i < keywords.length; i++) {
                        keywords[i] = keywords[i].strip();
                    }
                    break;
                }
                else if(reading.equals("title")){
                    if(title == null) {
                        title = line;
                    }
                    else {
                        title += " " + line;
                    }
                }
                else if(reading.equals("autores")){
                    authorList.append(line);
                }
                else if(reading.equals("resumen")){
                    if(body == null) {
                        body = line;
                    }
                    else {
                        body += "\n" + line;
                    }
                }
            }            
        }
        
        authors = new String[authorList.getSize()];
        int i = 0;
        for(ListNode<String> node = authorList.getFirst(); node != null; node = node.getNext()) {
            authors[i++] = node.getValue();
        }
        
        if(title == null || body == null) {
            throw new RuntimeException("Error de formato");
        }
        
        return new Summary(title, body, authors, keywords);
    }
    
    public static List<Summary> loadState(File file) throws IOException{
        List<Summary> summaryList = new List<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String title = null;
            String body = null;
            List<String> authorList = new List<>();
            List<String> keywordList = new List<>();     
            String line;
            while((line = reader.readLine()) != null){
                line = line.strip();
                if(line.startsWith("SUMMARY_TITLE ")) {
                    title = line.replaceFirst("SUMMARY_TITLE\\s+", "");
                }
                else if(line.startsWith("SUMMARY_AUTHOR ")) {
                    authorList.append(line.replaceFirst("SUMMARY_AUTHOR\\s+", ""));
                }
                else if(line.startsWith("SUMMARY_KEYWORD ")) {
                    keywordList.append(line.replaceFirst("SUMMARY_KEYWORD\\s+", ""));
                }
                else if(line.startsWith("SUMMARY_LINE ")) {
                    line = line.replaceFirst("SUMMARY_LINE\\s+", "");
                    if(body == null) {
                        body = line;
                    }
                    else {
                        body += "\n" + line;
                    }
                }
                else if(line.startsWith("SUMMARY_END")) {
                    int i;
                    /* Crear arreglo de autores */
                    i = 0;
                    String[] authors = new String[authorList.getSize()];
                    for(ListNode<String> node = authorList.getFirst(); node != null; node = node.getNext()) {
                        authors[i++] = node.getValue();
                    }
                    /* Crear arreglo de palabras clave */
                    i = 0;
                    String[] keywords = new String[keywordList.getSize()];
                    for(ListNode<String> node = keywordList.getFirst(); node != null; node = node.getNext()) {
                        keywords[i++] = node.getValue();
                    }
                    /* Agregar objeto de resumen */
                    summaryList.append(new Summary(title, body, authors, keywords));
                    /* Resetear variables */
                    title = null;
                    body = null;
                    authorList = new List<>();
                    keywordList = new List<>();  
                }
                else {
                    throw new RuntimeException("Error de formato");
                }
            }
        }
        return summaryList;
    }
        
    public static void saveState(List<Summary> summaries, File file) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            for(ListNode<Summary> node = summaries.getFirst(); node != null; node = node.getNext()) {
                Summary summary = node.getValue();
                writer.write(String.format("SUMMARY_TITLE %s\n", summary.getTitle()));
                for(String author : summary.getAuthors()) {
                    writer.write(String.format("SUMMARY_AUTHOR %s\n", author));
                }
                for(String keyword : summary.getKeywords()) {
                    writer.write(String.format("SUMMARY_KEYWORD %s\n", keyword));
                }
                for(String line : summary.getBody().split("\n")) {
                    writer.write(String.format("SUMMARY_LINE %s\n", line));
                }
                writer.write("SUMMARY_END\n");
            }
        }
    }   
}
