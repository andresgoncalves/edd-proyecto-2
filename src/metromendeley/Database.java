package metromendeley;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

/**
 *
 * @author USUARIO
 */
public class Database {
    
    public static Summary readSummaryTxt(File fileSummary) throws IOException{
        return readSummaryTxt(new FileReader(fileSummary));
    }
    
    public static Summary readSummaryTxt(Reader summaryReader) throws IOException{
        String title = null;
        String body = null;
        String[] authors;
        String[] keywords = {};
        List<String> authorList = new List<>();
        
        try(BufferedReader reader=new BufferedReader(summaryReader)){
            String line;
            String reading = "title";
            while((line = reader.readLine()) != null){
                line = line.strip();
                if("autores".equalsIgnoreCase(line)){
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
                }
                else if(reading.equalsIgnoreCase("title")){
                    if(title == null) {
                        title = line;
                    }
                    else {
                        title += " " + line;
                    }
                }
                else if(reading.equalsIgnoreCase("autores")){
                    authorList.append(line);
                }
                else if(reading.equalsIgnoreCase("resumen")){
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
        
        return new Summary(title, body, authors, keywords);
    }
    
    public static void saveSummaries(Summary summary, File fileSave) throws IOException{
        saveSummary(summary, new FileWriter(fileSave));
    }
    
    public static void saveSummary(Summary summary, Writer baseWriter) throws IOException{
        try(BufferedWriter writeSum= new BufferedWriter(baseWriter)){
            writeSum.write("title:"+summary.getTitle());
            writeSum.write("autores");
            for (int i = 0; i < summary.getAuthors().length; i++) {
                writeSum.write(summary.getAuthors()[i]+"\n");
            }
            writeSum.write("resumen:");
            writeSum.write(summary.getBody());
            writeSum.write("palabras clave");
            for (int i = 0; i < summary.getKeywords().length; i++) {
                writeSum.write(summary.getKeywords()[i]+"\n");
            }
            
        }
    }
    

}
