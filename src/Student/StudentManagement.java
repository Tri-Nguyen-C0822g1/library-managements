package Student;

import Student.Student;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManagement {
    private List<Student> students;
    private  final String filePath = "student.csv";

    public StudentManagement() {
        students = new ArrayList<>();
        readFromFile();
//        Student s1 = new Student(1,"Mai Chubby");
//        Student s2 = new Student(2,"Phu Re");
//        Student s3 = new Student(3,"Tung Heo");
//
//        students.add(s1);
//        students.add(s2);
//        students.add(s3);
    }
    public void add(Student s){
        students.add(s);
    }
    public boolean remove(int id){
        Student searchStudent = searchByID(id);
        if(searchStudent != null){
            students.remove(searchStudent);
            return true;
        }
    return false;
    }

    public Student searchByID(int id){
        for (Student s : students){
            if(s.getId()==(id)){

                return s;
            }
        }
        return null;
    }
    public List<Student> searchByName(String name){
        List<Student> studentList = new ArrayList<>();
        for(Student s: students){
            if(s.getName().contains(name)){
                studentList.add(s);
            }
        }
        return studentList;
    }
    public void saveToFile() {
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }
            fw.close();
            bw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void readFromFile(){
        students.clear();
        try{
        FileReader fr = new FileReader(filePath);
        BufferedReader br = new BufferedReader(fr);
        String line = "";
        Student s;
        while((line = br.readLine()) != null){
            s = handleLine(line);
            students.add(s);
        }
    } catch (IOException e){
            e.printStackTrace();
        }
    }
    public Student handleLine(String line){
        String[] str = line.split(",");
        Student newStudent = new Student(Integer.parseInt(str[0]),str[1]);
        return newStudent;
    }
    public String displayAll(){
            String listStudent = "";
            for (Student s:students){
                listStudent += s.toString() + "\n";
            }
            return listStudent;
    }
    public void update(int id, Student newStudent){
        Student studentUpdate = searchByID(id);
        if(studentUpdate != null){
            studentUpdate.setName(newStudent.getName());
            saveToFile();
        }
    }
}
