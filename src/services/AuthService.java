package services;

import java.io.IOException;

import services.FileHandling;

import model.Admin;
import model.User;
import view.admin.AdminDashboardFrame;

public class AuthService {
    
    
    private static int loginAttempt = 3;
    public static User login(String username, String password) throws IOException{
        
        String fullPath = System.getProperty("user.dir");
        String[] files = {fullPath + "/src/data/users.txt"};
        
        if (loginAttempt == 0){
            System.out.println("System Locked Please try again later");
            return null;
        }
        
        for( String file: files){
            
           try (java.io.BufferedReader br = new java.io.BufferedReader(
                new java.io.FileReader(file))) {
                
                String line;
                while ((line = br.readLine())!=null){
                    String[] data = line.split("\\|");
                    
                    
                        for (int i = 0; i < data.length; i++){
                            data[i] = data[i].trim();
                        }
                        String fileUsername = data[3];
                        String filePassword = data[4];

                      
                        
                        if (username.equals(fileUsername) && password.equals(filePassword)){
                            String userID = data[0];
                            System.out.println("'" + userID + "'" ); // debug
                            
                            System.out.println("Login Successfull");
                            
                            return FileHandling.LoadInformation(userID);
//                            System.out.println("Run Load Information done"); /// debug
                        }
                }  
            }catch (java.io.FileNotFoundException e){
                System.out.println("File not found: " + file);
            } catch (java.io.IOException e){
                System.out.println("Error reading" + file);
            }
        } 
        System.out.println("Login Failed");
        System.out.println("Login Attempt: " + loginAttempt);
        loginAttempt--;
        return null;
    }
}
