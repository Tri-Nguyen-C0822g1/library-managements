package Borrowing;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Borrowing {
    private int borrowID;

    private int studentID;

    private String bookID;
    private String bookName;
    private Date borrowDate;
    private Date returnDate ;
    private boolean status;
    private static int count = 0;

    public Borrowing(int studentID, String bookID, String borrowDate){
        this.studentID = studentID;
        this.bookID = bookID;

        this.borrowDate = new Date(borrowDate);
        this.returnDate = null;
        this.status = false;
        count++;
        this.borrowID = count;
    }

    public Borrowing(int borrowID, int studentID, String bookID
          , String borrowDate, String returnDate, boolean status) {
        this.borrowID = borrowID;
        this.studentID = studentID;
        this.bookID = bookID;
        this.borrowDate = new Date(borrowDate);
        this.returnDate = new Date(returnDate);
        this.status = status;

    }

    public int getBorrowID() {
        return borrowID;
    }

    public void setBorrowID(int borrowID) {
        this.borrowID = borrowID;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String borrowDateFormat = simpleDateFormat.format(this.borrowDate);
        String returnDateFormat;
        if(this.returnDate != null) {
             returnDateFormat = simpleDateFormat.format(this.returnDate);
        } else {
            returnDateFormat = "";
        }

        return borrowID +"," + studentID + "," + bookID + "," + borrowDateFormat + "," + returnDateFormat + "," + status;
    }
}
