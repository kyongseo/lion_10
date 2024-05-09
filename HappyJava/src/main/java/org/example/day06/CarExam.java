package org.example.day06;

public class CarExam {
    String brand;
    String model;
    int year;

    public void displayInfo(){
        System.out.println(" 브랜드명 : " + brand + " 모델명 : " + model + " 연식 : " + year);
    }

    public CarExam(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }
}
