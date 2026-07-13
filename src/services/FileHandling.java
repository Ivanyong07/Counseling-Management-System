package services;

// ListCellRenderer  = one renderer for whole LIST row
// TableCellRenderer = one renderer for each TABLE cell
// DefaultTableModel = whole table header
// DefaultListTableModel = 1 column only

// this week finish all the function in asm
//Finish User CRUD cleanly
//Create Appointment model
//Create Appointment FileHandling
//Build Receptionist appointment page first
//Student booking page
//Counselor notes
//Reports/statistics last

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

import model.Admin;
import model.Counselor;
import model.Receptionist;
import model.Student;
import model.User;
import components.TablePanelAction;
import java.io.FileWriter;


public class FileHandling {
        
    private static final String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";
    
    private static final String fileAdmin = System.getProperty("user.dir") + "/src/data/admin.txt";
    private static final String fileCounselor = System.getProperty("user.dir") + "/src/data/counselor.txt";
    private static final String fileReceptionist = System.getProperty("user.dir") + "/src/data/receptionist.txt";
    private static final String fileStudent = System.getProperty("user.dir") + "/src/data/student.txt";
    
    // ArrayList can add, array cannot 
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Admin> adminList = new ArrayList<>();
    public static ArrayList<Receptionist> receptionistList = new ArrayList<>();
    public static ArrayList<Counselor> counselorList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();

    
    private static DefaultTableModel model;
    private static final String[] columns = {"ID", "Email", "Status", "Action"};
    
    public static User LoadInformation(String userID){
        
        boolean found = false;
        try (BufferedReader readerUser = new BufferedReader(new FileReader(fileUser))){
            String userLine;

            System.out.println("Input ID: [" + userID + "]");
            
            
            // add condition for searching the correct file based on the userID
            while ((userLine = readerUser.readLine()) != null){
                String[] userData = userLine.split("\\|"); // first split having space
                // trim() only working on string
                for (int i = 0; i < userData.length; i++){
                    userData[i] = userData[i].trim();
                } // use for loop for trim()

                // Admin Load Information
                if (userID.startsWith("ADM") && userData[0].equals(userID)){
                    try (BufferedReader readerAdm = new BufferedReader(new FileReader(fileAdmin));){
                        String admLine;
                        while ((admLine = readerAdm.readLine()) != null){
                            String[] admData = admLine.split("\\|");
                            for (int i = 0; i < admData.length; i++){
                                admData[i] = admData[i].trim();
                            }
                            if (userData[0].equals(admData[0])){
                                
                                found = true;
                                System.out.println("User ID match Role ID: " + userData[0]);
                                System.out.println("ID Matching...");
                                
                                Admin admin = new Admin(userData[0], userData[1], userData[2], userData[3], 
                                        userData[4], userData[5], userData[6], admData[7], admData[8]);
                                adminList.add(admin);
                                System.out.println("Done");
                                return admin;
                                
                                // check value
//                                for (Admin m: adminList){
//                                    System.out.println("Gather information successfull...");
//                                    System.out.println(m);
//                              }
                            } 
                        }
                    }
                    catch (FileNotFoundException e){
                        System.out.println("Admin.txt not Found");
                    } catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
                
                
                // Reptionist Load Information 
                if (userID.startsWith("REP") && userData[0].equals(userID)){
                    

                    try(BufferedReader repReader = new BufferedReader(new FileReader(fileReceptionist))){
                        String repLine;
                        
                        while ((repLine = repReader.readLine()) != null){
                            String[] repData = repLine.split("\\|");
                            
                            for (int i = 0; i < repData.length; i++){
                                repData[i] = repData[i].trim();
                            }
                            if (userData[0].equals(repData[0])){
                                found = true;
                                System.out.println("User ID match Receptionist ID: " + userData[0]);
                                System.out.println("ID Matching");
                                Receptionist receptionist = new Receptionist(userData[0], userData[1], userData[2], userData[3], 
                                        userData[4], userData[5], userData[6], repData[7], repData[8]); 
                                receptionistList.add(receptionist);
                                System.out.println("Done");
                                return receptionist;
                                
                                // check value
//                                for (Receptionist r : receptionistList){
//                                    System.out.println("Gathering information...");
//                                    System.out.println("Reptionist: " + r);
//                                }
                            }
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("Receptionist.txt not found");
                    } catch (IOException e){
                        System.out.println("Error" + e);
                    }
                }
                
                
                // Counselor Load Information
                if (userID.startsWith("CSL") && userData[0].equals(userID)){
                    try (BufferedReader rslReader = new BufferedReader(new FileReader(fileCounselor))){
                        String rslLine;
                    while ((rslLine = rslReader.readLine()) !=null){
                        String[] cslData = rslLine.split("\\|");
                        
                        // debug
//                        System.out.println("cslData[0] = '" + cslData[0].trim() + "'");
//                        System.out.println("userData[0] = '" + userData[0] + "'");
                            for (int i = 0; i < cslData.length; i++){
                                cslData[i] = cslData[i].trim();
                            }
                            if(userData[0].equals(cslData[0])) {
                                found = true;
                                System.out.println("User ID match Counselor ID: " + userData[0]);
                                System.out.println("ID Matching...");
                                Counselor counselor = new Counselor(userData[0], userData[1], userData[2], userData[3], userData[4], 
                                        userData[5], userData[6], cslData[7], cslData[8]);
                                counselorList.add(counselor);
                                System.out.println("Done");
                                return counselor;
                                //check value
    //                            for (Counselor c: counselorList){
    //                                System.out.println("Counselor: " + c);
    //                          }
                            }
                        } 
                    } catch (FileNotFoundException e){
                        System.out.println("counselor.txt not found");
                    } catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
                
                // Student Load Information
                if(userID.startsWith("STU") && userData[0].equals(userID)){
                    try (BufferedReader stuReader = new BufferedReader(new FileReader(fileStudent))){
                        String stuLine;
                        
                        while ((stuLine = stuReader.readLine()) != null){
                            String[] stuData = stuLine.split("\\|");
                            
                            for (int i = 0; i < stuData.length; i++){
                                stuData[i] = stuData[i].trim();
                            }
                            
                            System.out.println("Checking ID: [" + stuData[0] + "]");
                            System.out.println("Input ID: [" + userID + "]");
                            
                            if (userData[0].equals(stuData[0])){
                                found = true;

                                System.out.println("User ID match Student ID: " + userData[0]);
                                System.out.println("ID Matching...");
                                
                                Student student = new Student(userData[0], userData[1], userData[2], userData[3], userData[4], 
                                        userData[5], userData[6], stuData[7], stuData[8]);
                                studentList.add(student);
                                System.out.println("Done");
                                return student;
                            }
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("student.txt not found");
                    } catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found and cannot read: " + e);
        } catch (IOException e){
            System.out.println("File could not read");
        }
        System.out.println("ID Not Found");
        return null;
    }
    
    public static DefaultTableModel loadTableInformation(Runnable onRun, String[] columns, int[] indexes, String filePath, String skipPrefix, boolean showInactive, boolean roleFile){
        model = new DefaultTableModel(columns, 0);

        try (BufferedReader tblDataRead = new BufferedReader(new FileReader(filePath))){

            String tblLine;

            while ((tblLine = tblDataRead.readLine()) != null){
                String[] tblData = tblLine.split("\\|");
                for (int i = 0; i < tblData.length; i++){
                    tblData[i] = tblData[i].trim();
                }
                
                if (tblData.length == 0 || tblLine.isBlank()){
                    continue;
                }
                
                if (roleFile){
                    if (skipPrefix != null && tblData[0].startsWith(skipPrefix)){
                        continue; // skip
                    }
                
                    if (!showInactive && tblData[6].equals("INACTIVE")){
                        continue;
                    }
                }
                Object[] row = new Object[indexes.length + 1];
                for (int i = 0; i < indexes.length; i++){
                    row[i] = tblData[indexes[i]];
                }
                row[indexes.length] = new TablePanelAction(tblData[0], onRun);
                model.addRow(row);
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return model;
    }
}
