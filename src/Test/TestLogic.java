
package Test;


import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class TestLogic {

    private static final String  fileAdmin = "src/data/admin.txt";
    private static final String  fileCounselor = "src/data/counselor.txt";
    private static final String  fileReceptionist = "src/data/receptionist.txt";
    private static final String  fileStudent = "src/data/student.txt";
    
    public static void main(String args[]) {
        
        // change one line only method
        // if match to the id featch the line that match to the array
        // also fetch the whole line to array
        // if change append the new line to the ori line
        // else not macth remain the ori line that in array
        // by using read and write and update
        
        
        // writer
//        try (FileWriter writer = new FileWriter(fileAdmin)){
//            writer.write("I like pizza\n");
//            System.out.println("File has been writen ");
//            
//        } 
//        catch (FileNotFoundException e){
//            System.out.println("File not found");
//        }
//        
//        catch (IOException e){
//            System.out.println("File could not write");
//        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(fileAdmin))){
            String line;
            while((line = reader.readLine()) != null){
                String[] data = line.trim().split(",");
                
                if (data[0].startsWith("I")){
                    System.out.println(data[0]);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
        }
        
        catch (IOException e){
            System.out.println("File could not read");
        }
    }
}
