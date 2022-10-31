package Book;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BookManagement {
     private List<Book> books;
     private final String filePath = "books.csv";
     private static BookManagement bookManagement = new BookManagement();

    public static BookManagement getBookManagement() {
       return bookManagement;
    }

    private BookManagement(){
         books = new ArrayList<>();
         readFromFile();
//         Book b1 = new Book("1","Cha giau cha ngheo","Robert Kyoshaki",2015);
//         Book b2 = new Book("2","Dac nhan tam","Phu re",2013);
//         Book b3 = new Book("3","36 Ke kinh doanh ","Thai Nguyen",2020);
//
//         books.add(b1);
//         books.add(b2);
//         books.add(b3);

    }
    public void add(Book b){
        books.add(b);
        saveToFile();
    }
    public boolean remove(String isbn){
        Book bookSearch = searchByID(isbn);
        if(bookSearch != null){
            books.remove(bookSearch);
            saveToFile();
            return true;
        }
        return false;
    }

    public Book searchByID(String isbn){
        for(Book b:books){
            if(b.getISBN().equals(isbn)){
                return b;
            }
        }
        return null;
    }
    public List<Book> searchByTitle(String title){
        List<Book> bookList = new ArrayList<>();
        for(Book b: books){
            if(b.getTitle().contains(title)){
                bookList.add(b);
            }
        }
        return bookList;
    }
     public void saveToFile(){
         try {
             FileWriter fw = new FileWriter(filePath);
             BufferedWriter bw = new BufferedWriter(fw);
             for (Book b : books) {
                 bw.write(b.toString());
                 bw.newLine();
             }
             bw.close();
             fw.close();
         }catch (IOException e){
             e.printStackTrace();
         }
     }
    public void readFromFile() {
        books.clear();
        try{
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Book b;

        while ((line = br.readLine()) != null) {
            b = handleLine(line);
            books.add(b);
        }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Book handleLine(String line){
        String[] str = line.split(",");
        Book newBook = new Book(str[0],str[1],str[2], Integer.parseInt(str[3]));
        return newBook;
    }
    public String displayAll(){
        String listBook = "";
        for (Book b : books){
            listBook += b.toString() + "\n";
        }
        return listBook;
    }
    public void update(String ISBN, Book newBook){
        Book bookUpdate = searchByID(ISBN);
        if(bookUpdate != null) {
            bookUpdate.setTitle(newBook.getTitle());
            bookUpdate.setAuthor(newBook.getAuthor());
            bookUpdate.setYear(newBook.getYear());
            saveToFile();
        }
    }
}
