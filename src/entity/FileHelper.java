package entity;




import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHelper {

    //read file 
    public static List<String> readLines(String fileName){
        List<String> lines = new ArrayList<>();
        File file = new File(fileName);
        if(!file.exists()) return lines;

        try ( BufferedReader br = new BufferedReader (new FileReader (file))){
            String line;
            while((line = br.readLine()) != null){
                if(!line.trim().isEmpty()){
                    lines.add(line);
                }
            }
        }catch  (IOException e){
            System.out.println("Error reading file: "+fileName +e.getMessage());;
        }
        return lines;
    }

    //wirte file
    public static void writeLines(String fileName, List<String> lines ){
        try (BufferedWriter bw =  new BufferedWriter(new FileWriter(fileName))){
            for (String line : lines) {
                bw.write(line);
                bw.newLine();
            }
        } catch(IOException e){
            System.out.println("Error write file: "+fileName);
        }
    }
}
