
package Test;


import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.ArrayList;
import model.Admin;
import model.User;

public class TestLogic {

    private static final String  fileUser = "src/data/users.txt";
    private static final String  fileAdmin = "src/data/admin.txt";
    private static final String  fileCounselor = "src/data/counselor.txt";
    private static final String  fileReceptionist = "src/data/receptionist.txt";
    private static final String  fileStudent = "src/data/student.txt";
    
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Admin> adminList = new ArrayList<>();
    
    public static void LoadInformation(String userID){
        try (BufferedReader readerUser = new BufferedReader(new FileReader(fileUser))){
            String userLine;
            // add condition for searching the correct file based on the userID
            while ((userLine = readerUser.readLine()) != null){
                String[] userData = userLine.split("\\|"); // first split having space
                // trim() only working on string
                for (int i = 0; i < userData.length; i++){
                    userData[i] = userData[i].trim(); 
                } // use for loop for trim()
                
                if (userData[0].equals(userID)){
                    System.out.println("Current Role account found...");
                    try (BufferedReader readerAdm = new BufferedReader(new FileReader(fileAdmin));){
                        String admLine;
                        while ((admLine = readerAdm.readLine()) != null){
                            String[] admData = admLine.trim().split("\\|");
                            
                            for (int i = 0; i < admData.length; i++){
                                admData[i] = admData[i].trim();
                            }
                            
                            if (userData[0].equals(admData[0])){
                                System.out.println("User ID match Role ID: " + userData[0]);
                                System.out.println("ID Matching...");
                                Admin admin = new Admin(userData[0], userData[1], userData[2], userData[3], 
                                        userData[4], userData[5], userData[6], admData[7], admData[8]);
                                adminList.add(admin);
                                
                                for (Admin m: adminList){
                                    System.out.println("Gather information successfull...");
                                    System.out.println(m);
                                }
                                
                            } else {
                                System.out.println("ID Not Found...Please register new account for the role...");
                            }
                        }
                    } 
                    catch (FileNotFoundException e){
                        System.out.println("File Not Found");
                    }
                    
                    catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("File could not read");
        }
    }
    
    public static void main(String args[]) {
        LoadInformation("ADM001"); // testing 1 (done)
        System.out.println("");
        LoadInformation("REP001"); // testing 2 (not done)
        
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

    }
}
