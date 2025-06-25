package com.app;

import java.util.ArrayList;
import java.util.Scanner;


public class StudentCRUD {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     ArrayList<Student> studentList = new ArrayList<>();
     boolean running = true;

     while (running) {
         System.out.println("\n===== Student Management System =====");
         System.out.println("1. Add Student");
         System.out.println("2. View Students");
         System.out.println("3. Update Student");
         System.out.println("4. Delete Student");
         System.out.println("5. Exit");
         System.out.print("Choose an option (1-5): ");
         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 
                 System.out.print("Enter ID: ");
                 int id = scanner.nextInt();
                 scanner.nextLine(); // consume newline
                 System.out.print("Enter Name: ");
                 String name = scanner.nextLine();
                 System.out.print("Enter Marks: ");
                 double marks = scanner.nextDouble();
                 studentList.add(new Student(id, name, marks));
                 System.out.println("Student added successfully.");
                 break;

             case 2:
             
                 System.out.println("\n--- Student List ---");
                 for (Student s : studentList) {
                     System.out.println(s);
                 }
                 break;

             case 3:
               
                 System.out.print("Enter ID to update: ");
                 int updateId = scanner.nextInt();
                 boolean foundUpdate = false;
                 for (Student s : studentList) {
                     if (s.id == updateId) {
                         scanner.nextLine(); // consume newline
                         System.out.print("Enter new name: ");
                         s.name = scanner.nextLine();
                         System.out.print("Enter new marks: ");
                         s.marks = scanner.nextDouble();
                         System.out.println("Student updated.");
                         foundUpdate = true;
                         break;
                     }
                 }
                 if (!foundUpdate) {
                     System.out.println("Student with ID " + updateId + " not found.");
                 }
                 break;

             case 4:
                
                 System.out.print("Enter ID to delete: ");
                 int deleteId = scanner.nextInt();
                 boolean foundDelete = false;
                 for (int i = 0; i < studentList.size(); i++) {
                     if (studentList.get(i).id == deleteId) {
                         studentList.remove(i);
                         System.out.println("Student deleted.");
                         foundDelete = true;
                         break;
                     }
                 }
                 if (!foundDelete) {
                     System.out.println("Student with ID " + deleteId + " not found.");
                 }
                 break;

             case 5:
                 
                 running = false;
                 System.out.println("Exiting program. Goodbye!");
                 break;

             default:
                 System.out.println("Invalid choice. Please enter 1-5.");
         }
     }

     scanner.close();
 }
}

