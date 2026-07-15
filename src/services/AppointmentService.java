package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Appointment;

public class AppointmentService {
    
    private static final String fileAppointment = System.getProperty("user.dir") + "/src/data/appointments.txt";
    
    public static String generateAppointmentID(){
        String prefix = "APM";

        int randomNum = 1000 + (int)(Math.random()*9000);

        return prefix + randomNum;
    }
    
    public static String generateReceiptID(){
        String prefix = "RCP";

        int randomNum = 1000 + (int)(Math.random()*9000);

        return prefix + randomNum;
    }
    
    public static Appointment createAppointment(Appointment appointment){
        try (BufferedReader userLine = new BufferedReader(new FileReader(fileAppointment))){           
            String dataLine;
            while ((dataLine = userLine.readLine()) != null){
                String[] data = dataLine.split("\\|");
                for (int i =0; i < data.length; i++){
                    data[i] = data[i].trim();
                }
                if (data[0].equals(appointment.getAppointmentID())){
                    return null;
                }
                }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }            
    
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileAppointment, true))){
            writer.write(
                    appointment.getAppointmentID() + " | " +
                    appointment.getCounselorID() + " | " +
                    appointment.getStudentID() + " | " +
                    appointment.getStartTime() + " | " +
                    appointment.getEndTime() + " | " +
                    appointment.getDate() + " | " +
                    appointment.getStatus() + " | " +
                    appointment.getConsultationsNote()+ " | " +
                    appointment.getBookMethod()
            ); 
            writer.newLine();
            return appointment;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public static Appointment updateAppointment(Appointment appointment){
        ArrayList<String> oriUserData = new ArrayList<>(); // declare locally as it will duplicate data
        
        try (BufferedReader uptDataRead = new BufferedReader(new FileReader(fileAppointment))){
            String oriLine;
            while ((oriLine = uptDataRead.readLine()) != null){
                String[] oriData = oriLine.split("\\|");
                for (int i = 0; i < oriData.length; i++){
                    oriData[i]=oriData[i].trim();
                }
                
                if (oriData[0].equals(appointment.getAppointmentID())){
                    
                    String updateLine = 
                    appointment.getAppointmentID() + " | " +
                    appointment.getCounselorID() + " | " +
                    appointment.getStudentID() + " | " +
                    appointment.getStartTime() + " | " +
                    appointment.getEndTime() + " | " +
                    appointment.getDate() + " | " +
                    appointment.getStatus() + " | " +
                    appointment.getConsultationsNote()+ " | " +
                    appointment.getBookMethod();        
                    
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
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileAppointment))){
                    
            for (String d : oriUserData){
                writer.write(d);
                writer.newLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public static void deleteAppointment(String appointmentID){
        ArrayList<String> oriUserData = new ArrayList<>(); 

        try (BufferedReader dltDataRead = new BufferedReader(new FileReader(fileAppointment))){
            String dltLine;
            while ((dltLine = dltDataRead.readLine()) != null){
                String[] dltData = dltLine.split("\\|");
                if (dltData.length > 0 && dltData[0].trim().equals(appointmentID.trim())) {
                    continue; // Skip the matching ID to delete it
                } else {
                    oriUserData.add(dltLine);
                }
            } 
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }

        try (FileWriter writer = new FileWriter(fileAppointment)){
            for (String d : oriUserData){
                writer.write(d + System.lineSeparator());
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
}
