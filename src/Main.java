import Book.BookManagementMenu;
import Borrowing.BorrowingManagementMenu;
import Student.StudentManagementMenu;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Library Menu:");
        System.out.println("1. Book Menu.");
        System.out.println("2. Student Menu.");
        System.out.println("3. Borrowing Menu.");

        System.out.println("Enter your choice:");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        switch (choice){
            case 1:
                BookManagementMenu bookManagementMenu = new BookManagementMenu();
                bookManagementMenu.handleMenu();
            case 2:
                StudentManagementMenu studentManagementMenu = new StudentManagementMenu();
                studentManagementMenu.handleMenu();
            case 3:
                BorrowingManagementMenu borrowingManagementMenu = new BorrowingManagementMenu();
                borrowingManagementMenu.handleMenu();

        }
    }
}