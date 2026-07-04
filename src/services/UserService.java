
package services;

// Functions: addUser(), deleteUser(), modifyUser()

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Admin;
import model.Counselor;
import model.Receptionist;
import model.Student;
import model.User;

public class UserService {
    
    private static final String fileUser = System.getProperty("user.dir") + "/src/data/users.txt";
    
    private static final String fileAdmin = System.getProperty("user.dir") + "/src/data/admin.txt";
    private static final String fileCounselor = System.getProperty("user.dir") + "/src/data/counselor.txt";
    private static final String fileReceptionist = System.getProperty("user.dir") + "/src/data/receptionist.txt";
    private static final String fileStudent = System.getProperty("user.dir") + "/src/data/student.txt";
        
    public static void deleteUser(String userID){
        ArrayList<String> oriUserData = new ArrayList<>(); // declare locally as it will duplicate data
        ArrayList<String> oriRoleData = new ArrayList<>(); // for role file
        
        try (BufferedReader dltDataRead = new BufferedReader(new FileReader(fileUser))){
            String dltLine;
            while ((dltLine = dltDataRead.readLine()) != null){
                String[] dltData = dltLine.split("\\|");
                for (int i = 0; i < dltData.length; i++){
                    dltData[i]=dltData[i].trim();
                }
                
                if (dltData[0].equals(userID)){
                    continue;
                    
                } else {
                    oriUserData.add(dltLine);
                }
                
                // delete rep file in rep.txt
                if (userID.equals("REP")){
                    try (BufferedReader dltrepData = new BufferedReader(new FileReader(fileReceptionist))){
                        
                        String repLine;
                        while ((repLine = dltrepData.readLine()) != null){
                            String[] repData = repLine.split("\\|");
                            for (int i = 0; i < repData.length; i++){
                                repData[i] = repData[i].trim();
                            }
                            
                            if (repData[0].equals(userID)){
                                continue;
                            } else {
                                oriRoleData.add(repLine);
                            }
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("File not found");
                    } catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
                
                if (userID.equals("CSL")){
                    try (BufferedReader dltcslData = new BufferedReader(new FileReader(fileCounselor))){
                        String cslLine;
                        while ((cslLine = dltcslData.readLine()) != null){
                            String[] cslData = cslLine.split("\\|");
                            for (int i = 0; i < cslData.length; i++){
                                cslData[i] = cslData[i].trim();
                            }
                            
                            if (cslData[0].equals(userID)){
                                continue;
                            } else {
                                oriRoleData.add(cslLine);
                            }
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("File not found");
                    } catch (IOException e){
                        System.out.println("Error: " + e);
                    }
                }
                
                if (userID.equals("STU")){
                    try (BufferedReader dltStuData = new BufferedReader(new FileReader(fileStudent))){
                        String stuLine;
                        while ((stuLine = dltStuData.readLine()) != null){
                            String[] stuData = stuLine.split("\\|");
                            for (int i = 0; i < stuData.length; i++){
                                stuData[i] = stuData[i].trim();
                            }
                            if (stuData[0].equals(userID)){
                                continue;
                            } else {
                                oriRoleData.add(stuLine);
                            }
                        }
                    } catch (FileNotFoundException e){
                        System.out.println("File not found");
                    } catch (IOException e){
                        System.out.println("Error" + e);
                    }
                }
            }
            
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (FileWriter writer = new FileWriter(fileUser)){
            for (String d : oriUserData){
                writer.write(d + "\n");
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void updateUser(User user){
        ArrayList<String> oriUserData = new ArrayList<>(); // declare locally as it will duplicate data
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileUser))){
            String oriLine;
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] oriData = oriLine.split("\\|");
                for (int i = 0; i < oriData.length; i++){
                    oriData[i]=oriData[i].trim();
                }
                
                if (oriData[0].equals(user.getUserID())){
                    
                    String updateLine = 
                            user.getUserID() + " | " +
                            user.getFirstname() + " | " +
                            user.getLastname() + " | " +
                            user.getUsername() + " | " +
                            user.getPassword() + " | " +
                            user.getEmail() + " | " +
                            user.getStatus();
                    
                    oriUserData.add(updateLine);
                    
                } else {
                    oriUserData.add(oriLine);
                }
            }
            
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUser))){
                    
            for (String d : oriUserData){
                writer.write(d);
                writer.newLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void updateAdmin(Admin admin){
        ArrayList<Admin> oriAdminList = new ArrayList<>();
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileAdmin))){
            String oriLine;
            
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] adminData = oriLine.split("\\|");
                for (int i = 0; i < adminData.length; i++){
                    adminData[i] = adminData[i].trim();
                }
                    Admin a = new Admin(
                            adminData[0],
                            adminData[1],
                            adminData[2],
                            adminData[3],
                            adminData[4],
                            adminData[5],
                            adminData[6],
                            adminData[7],
                            adminData[8]
                    );
                if(a.getUserID().equals(admin.getUserID())){
                    oriAdminList.add(admin);
                } else {
                    oriAdminList.add(a);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileAdmin))){
            
            for (Admin a: oriAdminList){
                writer.write(
                        a.getUserID() + " | " +
                        a.getFirstname() + " | " +
                        a.getLastname() + " | " +
                        a.getUsername() + " | " +
                        a.getPassword() + " | " +
                        a.getEmail() + " | " +
                        a.getStatus() + " | " +
                        a.getOffice() + " | " +
                        a.getContactNumber()       
                );
                writer.newLine();
            }
            
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void updateReceptionist(Receptionist receptionist) {
        ArrayList<Receptionist> oriRepList = new ArrayList<>();
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileReceptionist))){
            String oriLine;
            
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] repData = oriLine.split("\\|");
                for (int i = 0; i < repData.length; i++){
                    repData[i] = repData[i].trim();
                }   
                    Receptionist r = new Receptionist(
                            repData[0],
                            repData[1],
                            repData[2],
                            repData[3],
                            repData[4],
                            repData[5],
                            repData[6],
                            repData[7],
                            repData[8]
                    );
                if(r.getUserID().equals(receptionist.getUserID())){
                    oriRepList.add(receptionist);
                } else {
                    oriRepList.add(r);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReceptionist))){
            for (Receptionist r: oriRepList){
                writer.write(
                        r.getUserID() + " | " +
                        r.getFirstname() + " | " +
                        r.getLastname() + " | " +
                        r.getUsername() + " | " +
                        r.getPassword() + " | " +
                        r.getEmail() + " | " +
                        r.getStatus() + " | " +
                        r.getCounter() + " | " +
                        r.getContactNumber()
                );
                writer.newLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void updateCounselor(Counselor counselor){
        ArrayList<Counselor> oriCslList = new ArrayList<>();
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileCounselor))){
            String oriLine;
            
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] cslData = oriLine.split("\\|");
                for (int i = 0; i < cslData.length; i++){
                    cslData[i] = cslData[i].trim();
                }
                    Counselor c = new Counselor(
                            cslData[0],
                            cslData[1],
                            cslData[2],
                            cslData[3],
                            cslData[4],
                            cslData[5],
                            cslData[6],
                            cslData[7],
                            cslData[8]
                    );
                if(c.getUserID().equals(counselor.getUserID())){
                    oriCslList.add(counselor);
                } else {
                    oriCslList.add(c);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileCounselor))){
            
            for (Counselor c: oriCslList) {
                writer.write(
                        c.getUserID() + " | " +
                        c.getFirstname() + " | " +
                        c.getLastname() + " | " +
                        c.getUsername() + " | " +
                        c.getPassword() + " | " +
                        c.getEmail() + " | " +
                        c.getStatus() + " | " +
                        c.getSpecialist() + " | " +
                        c.getContactNumber()
                );
            }
                    
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
    }
    
    public static void updateStudent(Student student){
        ArrayList<Student> oriStdList = new ArrayList<>();
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileStudent))){
            String oriLine;
            
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] stdData = oriLine.split("\\|");
                for (int i = 0; i < stdData.length; i++){
                    stdData[i] = stdData[i].trim();
                }
                    Student s = new Student(
                            stdData[0],
                            stdData[1],
                            stdData[2],
                            stdData[3],
                            stdData[4],
                            stdData[5],
                            stdData[6],
                            stdData[7],
                            stdData[8]
                    );
                if(s.getUserID().equals(student.getUserID())){
                    oriStdList.add(student);
                } else {
                    oriStdList.add(s);
                }
            }
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileStudent))){
            
            for (Student s: oriStdList){
                writer.write(
                        s.getUserID() + " | " +
                        s.getFirstname() + " | " +
                        s.getLastname() + " | " +
                        s.getUsername() + " | " +
                        s.getPassword() + " | " +
                        s.getEmail() + " | " +
                        s.getStatus() + " | " +
                        s.getCourse() + " | " +
                        s.getContactNumber() 
                );
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static User createUser(User user){
        
        try (BufferedReader userLine = new BufferedReader(new FileReader(fileUser))){
            
            String dataLine;
            while ((dataLine = userLine.readLine()) != null){
                String[] data = dataLine.split("\\|");
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(user.getUserID())){
                    return null;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileUser, true))){
            writer.write(
                    user.getUserID() + " | " +
                    user.getFirstname() + " | " +
                    user.getLastname() + " | " +
                    user.getUsername() + " | " +
                    user.getPassword() + " | " +
                    user.getEmail() + " | " +
                    user.getStatus()
            );
            writer.newLine();
            return user;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public static Receptionist createReceptionist(Receptionist receptionist){
        try (BufferedReader userLine = new BufferedReader(new FileReader(fileReceptionist))){
            
            String dataLine;
            while ((dataLine = userLine.readLine()) != null){
                String[] data = dataLine.split("\\|");
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(receptionist.getUserID())){
                    return null;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileReceptionist, true))){
            writer.write(
                    receptionist.getUserID() + " | " +
                    receptionist.getFirstname() + " | " +
                    receptionist.getLastname() + " | " +
                    receptionist.getUsername() + " | " +
                    receptionist.getPassword() + " | " +
                    receptionist.getEmail() + " | " +
                    receptionist.getStatus() + " | " +
                    receptionist.getCounter() + " | " +
                    receptionist.getContactNumber()
            );
            writer.newLine();
            return receptionist;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
        public static Counselor createCounselor(Counselor counselor){
        try (BufferedReader userLine = new BufferedReader(new FileReader(fileCounselor))){
            
            String dataLine;
            while ((dataLine = userLine.readLine()) != null){
                String[] data = dataLine.split("\\|");
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(counselor.getUserID())){
                    return null;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileCounselor, true))){
            writer.write(
                    counselor.getUserID() + " | " +
                    counselor.getFirstname() + " | " +
                    counselor.getLastname() + " | " +
                    counselor.getUsername() + " | " +
                    counselor.getPassword() + " | " +
                    counselor.getEmail() + " | " +
                    counselor.getStatus() + " | " +
                    counselor.getSpecialist()+ " | " +
                    counselor.getContactNumber()
            );
            writer.newLine();
            return counselor;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
            public static Student createStudent(Student student){
        try (BufferedReader userLine = new BufferedReader(new FileReader(fileStudent))){
            
            String dataLine;
            while ((dataLine = userLine.readLine()) != null){
                String[] data = dataLine.split("\\|");
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(student.getUserID())){
                    return null;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileStudent, true))){
            writer.write(
                    student.getUserID() + " | " +
                    student.getFirstname() + " | " +
                    student.getLastname() + " | " +
                    student.getUsername() + " | " +
                    student.getPassword() + " | " +
                    student.getEmail() + " | " +
                    student.getStatus() + " | " +
                    student.getCourse()+ " | " +
                    student.getContactNumber()
            );
            writer.newLine();
            return student;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
            
    public static String generateUserID(String role){
        String prefix = "";
        
        if (role.equals("Receptionist")){
            prefix = "REP";
        } else if (role.equals("Counselor")){
            prefix = "CSL";
        } else if (role.equals("Student")){
            prefix = "STU";
        }
        
        int randomNum = 1000 + (int)(Math.random()*9000);
        
        return prefix + randomNum;
    }
}
