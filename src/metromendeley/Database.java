/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
        String line;
        String reading="title";
        String title="";
        String body="";
        List<String> authors= new List();
        String[] arrayAuthors;
        String[] arrayKey=null;
        try(BufferedReader reader=new BufferedReader(summaryReader)){
            while((line=reader.readLine())!=null){
                
                if("autores".equalsIgnoreCase(line)){
                    reading="autores";
                }
                else if("resumen".equalsIgnoreCase(line)){
                    reading="resumen";
                }
                else if((line.toLowerCase()).contains("palabras claves")){
                    String[] split = line.split(":");
                    String[] split1 = split[1].split(",");
                    arrayKey=split1;
                }
                if(reading.equalsIgnoreCase("title")){
                    title=title+line+" ";
                }
                else if(reading.equalsIgnoreCase("autores")){
                    authors.append(line);
                }
                else if(reading.equalsIgnoreCase("resumen")){
                    body=body+line+" ";
                }
            }
            arrayAuthors=arrayAuthors(authors);
            
        }
        return new Summary(title, body, arrayAuthors, arrayKey);
    }
    
    public static String[] arrayAuthors(List authorList){
        String[] arrayAuthor= new String[authorList.getSize()];
        ListNode newAuthor= authorList.getFirst();
        for (int i = 0; i < arrayAuthor.length; i++) {
            arrayAuthor[i]=newAuthor.getValue().toString().strip();
            newAuthor=newAuthor.getNext();
        }
        return arrayAuthor;
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
