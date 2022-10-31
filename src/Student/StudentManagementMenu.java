package Student;

import Student.Student;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentManagementMenu {
    StudentManagement studentManagement = new StudentManagement();

    public void displayMenu(){
        System.out.println("Student Management:");
        System.out.println("1. Add student");
        System.out.println("2. Remove student");
        System.out.println("3. Search student by ID");
        System.out.println("4. Search student by name");
        System.out.println("5. Read form file");
        System.out.println("6. Save to file");
        System.out.println("7. Display All");
        System.out.println("8. Update student");
    }

    public void handleMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        while (choice != 0){
            displayMenu();
            System.out.println("Enter your choice:");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    remove();
                    break;
                case 3:
                    searchByID();
                    break;
                case 4:
                    searchByName();
                    break;
                case 5:
                    readFromFile();
                    break;
                case 6:
                    saveToFile();
                    break;
                case 7:
                    displayAll();
                    break;
                case 8:
                    update();
                    break;
                case 0:
                    break;
                default:
                    break;
        }
    }
    }
    public void add(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id:");
        int id = scanner.nextInt();scanner.nextLine();
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        scanner.nextLine();

        Student newStudent = new Student(id, name);
        studentManagement.add(newStudent);
    }
    public void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id to remove:");
        int id = scanner.nextInt();
        if(studentManagement.remove(id)){
            System.out.println("Remove student's successful!");
        } else {
            System.out.println("Remove student's fail!! Please recheck the ID");
        }
    }
    public void searchByID(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = scanner.nextInt();
        String searchByID = String.valueOf(studentManagement.searchByID(id));
        System.out.println(searchByID);
        if(searchByID!= null){
            System.out.println(searchByID);
        } else {
            System.out.println("Not found!!! Please recheck ID");
        }
    }

    public void searchByName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        List<Student> studentList = studentManagement.searchByName(name);
        for (Student s: studentList){
            System.out.println(s);
        }
    }

    public void readFromFile(){
            studentManagement.readFromFile();
    }

    public void saveToFile(){
            studentManagement.saveToFile();
    }
    public void displayAll(){
        System.out.println(studentManagement.displayAll());
    }
    public void update(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter id to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new name:");
        String newName = scanner.nextLine();
        scanner.nextLine();

        Student newStudent = new Student(id, newName);
        studentManagement.update(newStudent.getId(), newStudent);

    }
}
