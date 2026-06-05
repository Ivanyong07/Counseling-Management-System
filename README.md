src/
 │
 ├─ Main.java                       <-- Single entry point (launches LoginFrame)
 │
 ├─ model/                          <-- PURE DATA (No file logic, no UI)
 │    ├─ User.java                  <-- abstract Parent Class (id, username, password, fullName)
 │    ├─ Admin.java                 <-- Child Class (extends User)
 │    ├─ Receptionist.java          <-- Child Class (extends User)
 │    ├─ Counselor.java             <-- Child Class (extends User + specialization)
 │    ├─ Student.java               <-- Child Class (extends User + course)
 │    ├─ Appointment.java           <-- Data blueprint for a consultation
 │    └─ Status.java                <-- Enum (PENDING, APPROVED, COMPLETED)
 │
 ├─ repository/                     <-- FILE I/O (Reads/writes text files into OOP Objects)
 │    ├─ UserRepository.java        <-- Handles loading/saving student.txt, admin.txt, etc.
 │    └─ AppointmentRepository.java <-- Handles loading/saving appointments.txt
 │
 ├─ service/                        <-- ACTIONS & FUNCTIONS (The engine room)
 │    ├─ AuthService.java           <-- Functions: login(), logout()
 │    ├─ UserService.java           <-- Functions: addUser(), deleteUser(), modifyUser()
 │    └─ ReportService.java         <-- Functions: generateReport(), calculateMonthlyCharts()
 │
 └─ view/                           <-- SWING UI (Windows, Panels, Elements)
      ├─ LoginFrame.java            <-- The initial login window
      ├─ DashboardFrame.java        <-- Main shell window after logging in
      │
      ├─ admin/                     <-- Sub-package for Admin GUI components
      │    ├─ AdminDashboard.java   
      │    ├─ AccountPanel.java     
      │    ├─ BarChart.java         
      │    └─ GraphChart.java       
      │
      ├─ receptionist/              <-- Sub-package for Receptionist GUI components
      │    └─ BookAppointmentPanel.java
      │
      └─ counselor/                 <-- Sub-package for Counselor GUI components
           └─ ViewRosterPanel.java
│
│
│
data/
  ├─ user.txt         
  ├─ admin.txt
