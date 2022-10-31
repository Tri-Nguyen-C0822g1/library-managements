package Borrowing;

import Book.BookManagement;
import Student.StudentManagement;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class BorrowingManagementMenu {
    BorrowingManagement borrowingManagement = new BorrowingManagement();
    BookManagement bookManagement = BookManagement.getBookManagement();
    StudentManagement studentManagement = new StudentManagement();

    public void displayMenu() {
        System.out.println("=======Menu=====");
        System.out.println("1. Add borrowing");
        System.out.println("2. Return book");
        System.out.println("3. Search by borrowing id");
        System.out.println("4. Get on borrowings");
        System.out.println("5. Remove borrowing");
//        System.out.println("6. Save to file");
//        System.out.println("7. Read from file");
        System.out.println("8. Display all");
        System.out.println("9. ");
        System.out.println("0. Done ");
    }

    public void handleMenu() {
        Scanner scanner = new Scanner(System.in);
        int choose = -1;
        while (choose != 0) {
            displayMenu();
            System.out.println("Enter number");
            choose = scanner.nextInt();
            scanner.nextLine();
            switch (choose) {
                case 1:
                    add();
                    break;
                case 2:
                    returnBook();
                    break;
                case 3:
                    searchByBorrowID();
                    break;
                case 4:
                    getOnBorrowing();
                    break;
                case 5:
                    remove();
                    break;
//                case 6:
//                    saveToFile();
//                    break;
//                case 7:
//                    readFromFile();
//                    break;
                case 8:
                    displayAll();
                    break;
                case 9:
                    add();
                    break;
                case 0:
                    add();
                    break;
                default:
                    break;

            }
        }
    }

    private void add() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student id");
        int studentId = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter book id");
        String bookId = scanner.nextLine();
        System.out.println("Enter date borrow");
        String dateBorrow = scanner.nextLine();


        if(bookManagement.searchByID(bookId) == null){
            System.out.println(" Book's ID not found!!");
            add();
            return;
        }

        if(studentManagement.searchByID(studentId) == null){
            System.out.println("Student's ID not found!!");
            add();
            return;
        }

            Borrowing br = new Borrowing(studentId, bookId, dateBorrow);
        borrowingManagement.add(br);
    }
    public void returnBook(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter borrowing ID");
        int borrowingID = scanner.nextInt();scanner.nextLine();
        borrowingManagement.returnBook(borrowingID);
    }
    public void searchByBorrowID(){
        Scanner scanner =new Scanner(System.in);
        System.out.println("Enter borrowing ID");
        int borrowingID = scanner.nextInt();
        System.out.println(borrowingManagement.searchByBorrowID(borrowingID));

    }
    public void remove(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter borrowing ID");
        int borrowingID = scanner.nextInt(); scanner.nextLine();
        borrowingManagement.remove(borrowingID);
    }
    public void getOnBorrowing(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(borrowingManagement.getOnBorrowings());
    }
    public void saveToFile(){
        try{
            borrowingManagement.saveToFile();
        }catch (IOException e){
            System.out.println("Error");
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        try{
            borrowingManagement.readFromFile();
        }catch (IOException e){
            System.out.println("Error!!!");
            e.printStackTrace();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public void displayAll (){
        System.out.println(borrowingManagement.displayAll());
    }
    

}