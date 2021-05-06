package com.studentmanage.service;

import com.studentmanage.dal.StudentDB;
import com.studentmanage.model.Student;

import java.io.IOException;
import java.util.Scanner;

import static com.studentmanage.dal.StudentDB.studentList;

public class StudentService {
    private static StudentDB studentDB = new StudentDB();

    public void loadFileStudent() throws IOException {
        studentDB.loadFileStudent();
    }

    public void readFileStudent() throws IOException {
        studentDB.readFileStudent();
    }

    public static void showMenu() {
        System.out.println("1.Add student.");
        System.out.println("2.Edit student.");
        System.out.println("3.Delete student.");
        System.out.println("4.Show student List.");
        System.out.println("5.Sort by Avenger Point.");
        System.out.println("6.Exit.");
        System.out.println(" Your choose:");
    }

    public void addStudent() throws IOException {
        Student student = new Student();
        student.inputStudent();
        int count = studentList.size();
        student.setId(++count);
        studentList.add(student);
        System.out.println("Add complete!");
        System.out.println("------------");
        studentDB.saveFileStudent();
    }

    public void deleteStudent() throws IOException {
        System.out.println("Input ID of student to delete:");
        int id = new Scanner(System.in).nextInt();
        boolean check = true;
        for (Student student : studentList) {
            if (student.getId() == id) {
                studentList.remove(student);
                System.out.println("Is't deleted!");
                System.out.println("------------");
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Can't not delete!");
            System.out.println("------------");
        }
        studentDB.saveFileStudent();
    }

    public void editStudent() throws IOException {
        System.out.println("Input ID of student to edit:");
        int id = new Scanner(System.in).nextInt();
        boolean check = true;
        for (Student student : studentList) {
            if (student.getId() == id) {
                student.inputStudent();
                student.setId(id);
                check = false;
                break;
            }
        }
        if (check) {
            System.out.println("Can't not find ID!");
        }
        System.out.println("------------");
        studentDB.saveFileStudent();
    }

    public void sortStudentByAvengerPoint() throws IOException {
        studentList.sort((o2, o1) -> {
            if (o1.getAveragePoint() < o2.getAveragePoint()) {
                return -1;
            }
            return 1;
        });
        System.out.println("Is Sorted!");
        System.out.println("------------");
        studentDB.saveFileStudent();
    }
}
