package Borrowing;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class BorrowingManagement {
    List<Borrowing> borrowings;
    private final String filePath = "borrowing.csv";
    private int borrowID;

    public BorrowingManagement() {
        borrowings = new ArrayList<>();
    }

    public int add(Borrowing br) {
        borrowings.add(br);
        return br.getBorrowID();
    }
    public void returnBook(int borrowingID){
        Borrowing br = searchByBorrowID(borrowingID);
        if(br != null){
            br.setReturnDate(new Date());
            br.setStatus(true);
        }
    }

    public List<Borrowing> getOnBorrowings() {
        Scanner scanner = new Scanner(System.in);
        List<Borrowing> onBorrowings = new ArrayList<>();
        for (Borrowing b : borrowings) {
            if (!b.isStatus()) {
                onBorrowings.add(b);
                scanner.nextLine();
            }
        }
        return onBorrowings;
    }



    public Borrowing searchByBorrowID(int borrowID) {
        for (Borrowing br : borrowings) {
            if (br.getBorrowID() == borrowID) {
                return br;
            }
        }
        return null;
    }

    public boolean remove(int borrowIO) {
        Borrowing searchBorrowing = searchByBorrowID(borrowIO);
        if (searchBorrowing != null) {
            borrowings.remove(searchBorrowing);
            return true;
        }
        return false;
    }
    public void saveToFile() throws IOException{
        FileWriter fw = new FileWriter(filePath);
        BufferedWriter bw = new BufferedWriter(fw);
        for (Borrowing br: borrowings){
            bw.write(br.toString());
            bw.newLine();
        }
        bw.close();
        fw.close();

    }
    public void readFromFile() throws IOException, ParseException {
        borrowings.clear();
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Borrowing borrowing;
        while ((line = br.readLine()) != null){
            borrowing = handleLine(line);
            borrowings.add(borrowing);
            System.out.println(borrowings);
        }
        fr.close();
        br.close();

    }
    public Borrowing handleLine(String line) throws ParseException {
        String[] str = line.split(",");

        Borrowing newBorrowing = new Borrowing(Integer.parseInt(str[0]),Integer.parseInt(str[1]),
                str[2],str[3],str[4] == ""? null : str[4],Boolean.parseBoolean(str[5]));
        return newBorrowing;
    }
    public String displayAll(){
        String listBorrowings = "";
        for(Borrowing br : borrowings){
            listBorrowings += br.toString() + "\n";
        }
        return listBorrowings;
    }


}

