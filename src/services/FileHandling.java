
package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import model.Admin;
import model.Counselor;
import model.Receptionist;
import model.Student;
import model.User;


public class FileHandling {
        
    private static final String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";
    
    private static final String fileAdmin = System.getProperty("user.dir") + "/src/data/admin.txt";
    private static final String fileCounselor = "/src/data/admin.txt";
    private static final String fileReceptionist = "/src/data/admin.txt";
    private static final String fileStudent = "/src/data/admin.txt";
    
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Admin> adminList = new ArrayList<>();
    public static ArrayList<Receptionist> receptionistList = new ArrayList<>();
    public static ArrayList<Counselor> counselorList = new ArrayList<>();
    public static ArrayList<Student> studentList = new ArrayList<>();
    
    public static User LoadInformation(String userID){
        boolean found = false;
        try (BufferedReader readerUser = new BufferedReader(new FileReader(fileUser))){
            String userLine;
            
            
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
}
