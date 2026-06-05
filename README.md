src/
 │
 ├─ Main.java                
 │
 ├─ model/                        <-- Core Data Domain (Heavily OOP)
 │    ├─ User.java                <-- abstract Base Parent Class
 │    ├─ Admin.java               <-- Subclass (Inheritance)
 │    ├─ Receptionist.java        <-- Subclass (Inheritance)
 │    ├─ Counselor.java           <-- Subclass (Inheritance)
 │    ├─ Student.java             <-- Subclass (Inheritance)
 │    ├─ Appointment.java         
 │    └─ Status.java              <-- Enum (PENDING, APPROVED, etc.)
 │
 ├─ repository/                   <-- NEW: Handles your TXT files OOP-style
 │    ├─ UserRepository.java      
 │    └─ AppointmentRepository.java
 │
 ├─ service/                      <-- Business Logic Engines
 │    ├─ AuthService.java         
 │    └─ AppointmentService.java  
 │
 └─ view/                         <-- Swing UI Layouts (GUI Objects)
      ├─ LoginFrame.java          
      ├─ DashboardFrame.java      
      ├─ admin/                   
      │    ├─ AdminDashboard.java 
      │    └─ AccountPanel.java   
      ├─ receptionist/            
      └─ counselor/
