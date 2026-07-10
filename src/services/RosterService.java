package services;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList; 
import model.Roster;

public class RosterService {
    
    private static final String fileRosters = System.getProperty("user.dir") + "/src/data/rosters.txt";

    public static String generateRosterID(Roster roster){
        String prefix = "ROS";
        
        int random = 1000 + (int)(Math.random() * 9000);
        
        return prefix + random;
    }
    
    public static Roster createRoster(Roster roster){
        try (BufferedReader rosterReader = new BufferedReader(new FileReader(fileRosters))){
            String rosterLine;

            while ((rosterLine = rosterReader.readLine()) != null){
                String[] rosterData = rosterLine.split("\\|");
                
                for (int i = 0 ;i < rosterData.length; i++){
                    rosterData[i] = rosterData[i].trim();
                }
                
                if (rosterData[0].equals(roster.getRosterID())){
                    return null;
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRosters, true))){
            writer.write(
                    roster.getRosterID() + " | " +
                    roster.getUserID() + " | " +
                    roster.getDate() + " | " +
                    roster.getEndTime() + " | " +
                    roster.getStartTime() + " | " +
                    roster.getShiftTime()
            );
            writer.newLine();
            return roster;
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        return null;
    }
    
    public static void deleteRoster(String rosterID){
        ArrayList<String> rosterList = new ArrayList<>();
        
        try (BufferedReader rosterReader = new BufferedReader(new FileReader(fileRosters))){
            String rosterLine;

            while ((rosterLine = rosterReader.readLine()) != null){
                String[] rosterData = rosterLine.split("\\|");
                
                for (int i = 0 ;i < rosterData.length; i++){
                    rosterData[i] = rosterData[i].trim();
                }
                
                if (rosterData[0].equals(rosterID)){
                    continue;
                } else {
                    rosterList.add(rosterLine);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        try (FileWriter writer = new FileWriter(fileRosters)){
            for (String d : rosterList){
                writer.write(d + "\n");
            }
        } catch (FileNotFoundException e){
            System.out.println("File not found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static void updateRoster(Roster roster){
        ArrayList<Roster> rosterList = new ArrayList<>();
        
        try (BufferedReader rosterReader = new BufferedReader(new FileReader(fileRosters))){
            String rosterLine;

            while ((rosterLine = rosterReader.readLine()) != null){
                String[] rosterData = rosterLine.split("\\|");
                
                for (int i = 0 ;i < rosterData.length; i++){
                    rosterData[i] = rosterData[i].trim();
                }
                
                Roster r = new Roster(
                        rosterData[0],
                        rosterData[1],
                        LocalDate.parse(rosterData[2]),
                        LocalTime.parse(rosterData[3]),
                        LocalTime.parse(rosterData[4]),
                        rosterData[5]
                );
                
                if (r.getRosterID().equals(roster.getRosterID())){
                    rosterList.add(roster);
                } else {
                    rosterList.add(r);
                }
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileRosters))){
            
            for (Roster r: rosterList){
                writer.write(
                        r.getRosterID()+ " | " +
                        r.getUserID()+ " | " +
                        r.getDate()+ " | " +
                        r.getStartTime()+ " | " +
                        r.getEndTime()+ " | " +
                        r.getShiftTime()    
                );
                writer.newLine();
            }
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        } catch (IOException e){
            System.out.println("Error: " + e);
        }
    }
    
    public static Roster readRoster(Roster roster){
        return null;
    }
    
}
