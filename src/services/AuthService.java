
package services;

// Functions: login(), logout()
public class AuthService {
    
    public static void login(String username, String password){
        if (username == username && password == password){
            System.out.println("Login Successfull");
        } else {
            System.out.println("Login Failed");
        }
    }
    
    public static void logout(String username, String password){
        if (username == username && password == password){
            System.out.println("Login Successfull");
        } else {
            System.out.println("Login Failed");
        }
    }
}
