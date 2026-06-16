
package services;

// Functions: login(), logout()
//Login Button
//      ↓
//AuthService
//      ↓
//Loop through 4 files in login frame
//      ↓
//Find matching account with array data[2] and data[3]
//      ↓
//Create correct role object 
//      ↓
//Return User
//      ↓
//LoginFrame checks type
//      ↓
//Open corresponding dashboard
//      ↓
//dispose LoginFrame

import java.io.IOException;
import model.User;

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
                    String[] data = line.split(",");
                    
                    if (data.length >= 6){
                        String fileUsername = data[3].trim();
                        String filePassword = data[4].trim();
                        
                        
                        if (fileUsername.equals(username) && filePassword.equals(password)){
                            System.out.println("Login Successfull");
                            Boolean login = true;
                            return new User(data[0], data[1], data[2], data[3], data[4], data[5]);
                        }
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
