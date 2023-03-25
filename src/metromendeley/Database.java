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
        String title="";
        String body="";
        List authors= new List();
        List keyWords= new List();
        String[] arrayAuthors;
        String[] arrayKey;
        try(BufferedReader reader=new BufferedReader(summaryReader)){
            while((line=reader.readLine())!=null){
                if(!"autores".equalsIgnoreCase(line)){
                    if(!" ".equals(line)){
                    title=title+line+" ";
                    }
                }
                if(!"resumen".equalsIgnoreCase(line)){
                    if(!" ".equals(line)){
                    authors.append(line);
                    }
                }
                if("resumen".equalsIgnoreCase(line)){
                    if(!" ".equals(line)){
                    body=body+line+" ";
                    }
                }
                if("palabras claves".equalsIgnoreCase(line)){
                    line.split(":");
                    keyWords.append(line.split(","));
                }
            }
            arrayAuthors=arrayAuthors(authors);
            arrayKey=keyArray(keyWords);
        }
        return new Summary(title, body, arrayAuthors, arrayKey);
    }
    public static String[] arrayAuthors(List authorList){
        String[] arrayAuthor= new String[authorList.getSize()];
        ListNode newAuthor= authorList.getFirst();
        for (int i = 0; i < arrayAuthor.length; i++) {
            arrayAuthor[i]=newAuthor.getValue().toString();
            newAuthor=newAuthor.getNext();
        }
        return arrayAuthor;
    }
    public static String[] keyArray(List keyList){
        String[] arrayKey=new String[keyList.getSize()];
        ListNode newArray=keyList.getFirst();
        for (int i = 0; i < arrayKey.length; i++) {
            arrayKey[i]=newArray.getValue().toString();
            newArray=newArray.getNext();
        }
        return arrayKey;
    }
//    public static Summary readHashTxt(File fileHash) throws IOException{
//        return readHash(new FileReader(fileHash));
//    }
//    private static HashTable readHash(Reader hashReader) throws IOException{
//        String line;
//        String title="";
//        HashTable newHash= new HashTable(0);
//        try(BufferedReader reader= new BufferedReader(hashReader)){
//           while((line =reader.readLine())!=null){ 
//               if(!"autores".equals(line.toLowerCase())){
//                   title=title+line+" ";
//               }
//               if("autores".equalsIgnoreCase(line)){
//                   line=reader.readLine();
//                   List newList=new List();
//                   newList.append(line);
//               }
//              
//           } 
//        }    
//        return newHash;
//    }
}
