package com.studentmanage.model;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    static int count = 0;
    private String name;
    private int id, point1_1, point1_2, point2, point3;
    private double averagePoint;
    Scanner scanner1 = new Scanner(System.in);
    Scanner scanner2 = new Scanner(System.in);
    Scanner scanner3 = new Scanner(System.in);

    public Student() {

    }

    public Student(int id, String name, int point1_1, int point1_2, int point2, int point3) {
        this.id = id;
        this.name = name;
        this.point1_1 = point1_1;
        this.point1_2 = point1_2;
        this.point2 = point2;
        this.point3 = point3;
        this.averagePoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }

    public void setAveragePoint() {
        this.averagePoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }

    public double getAveragePoint() {
        return averagePoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoint1_1() {
        return point1_1;
    }

    public void setPoint1_1(int point1_1) {
        this.point1_1 = point1_1;
    }

    public int getPoint1_2() {
        return point1_2;
    }

    public void setPoint1_2(int point1_2) {
        this.point1_2 = point1_2;
    }

    public int getPoint2() {
        return point2;
    }

    public void setPoint2(int point2) {
        this.point2 = point2;
    }

    public int getPoint3() {
        return point3;
    }

    public void setPoint3(int point3) {
        this.point3 = point3;
    }

    @Override
    public String toString() {
        return "StudentObject{" +
                "id= " + id +
                " , name= " + name +
                " , point1_1= " + point1_1 +
                " , point1_2= " + point1_2 +
                " , point2= " + point2 +
                " , point3= " + point3 +
                " , avengerPoint= " + averagePoint +
                '}';
    }

    public void printTableTemplate(){
        System.out.format("|%-3s |", id);
        System.out.format("%-15s |", name);
        System.out.format("%-10s |", point1_1);
        System.out.format("%-10s |", point1_2);
        System.out.format("%-10s |", point2);
        System.out.format("%-10s |", point3);
        System.out.format("%-10s\n", averagePoint);
    }

    public String toStringCSV() {
        return id + ", " + name + ", " + point1_1 + ", "
                + point1_2 + ", " + point2 + ", " + point3 + ", "
                + averagePoint+"\n";
    }

    public void inputStudent() {
        this.id = ++count;
        System.out.println("Input name: ");
        name = scanner1.nextLine();
        String regex = "^[a-zA-Z]*+\\s+[a-zA-Z]*$|^[a-zA-Z]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(name);
        while(!matcher.find()) {
            System.out.println("Please input right format for Name !");
            name= scanner2.nextLine();
            matcher = pattern.matcher(name);
        }
        do {
            System.out.println("Input Point1-1: ");
            while (!scanner2.hasNextInt()) {
                System.out.println("Please input Point again: ");
                scanner2.next();
            }
            point1_1 = scanner2.nextInt();
        } while (point1_1 <= 0 || point1_1 >= 10);
        do {
            System.out.println("Input Point1-2: ");
            while (!scanner3.hasNextInt()) {
                System.out.println("Please input Point again: ");
                scanner3.next();
            }
            point1_2 = scanner3.nextInt();
        } while (point1_2 <= 0 || point1_2 >= 10);
        do {
            System.out.println("Input Point2: ");
            while (!scanner1.hasNextInt()) {
                System.out.println("Please input Point again: ");
                scanner1.next();
            }
            point2 = scanner1.nextInt();
        } while (point2 <= 0 || point2 >= 10);
        do {
            System.out.println("Input Point3: ");
            while (!scanner2.hasNextInt()) {
                System.out.println("Please input Point again: ");
                scanner2.next();
            }
            point3 = scanner2.nextInt();
        } while (point3 <= 0 || point3 >= 10);
        this.averagePoint = (point1_1 + point1_2 + 2 * point2 + 3 * point3) / 7;
    }
}
