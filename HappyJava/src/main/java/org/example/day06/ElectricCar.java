package org.example.day06;

public class ElectricCar extends CarExam{
    int betteryCapacity;

    public ElectricCar(String brand, String model, int year, int betteryCapacity) {
        super(brand, model, year);
    }

    @Override
    public void displayInfo(){
        System.out.println("브랜드명 : " + brand + " 모델명 : " + model + " 연식 : " + year + " 배터리 용량 : " + betteryCapacity);
    }
}
