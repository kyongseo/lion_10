package org.example.day06;

public class CarExamMain {
    public static void main(String[] args) {
        CarExam car = new CarExam("Hyundai","Sonata",2020);
        car.displayInfo();

        // ElectricCar 클래스의 인스턴스 생성
        ElectricCar electricCar = new ElectricCar("Tesla", "Model_S", 2021, 75);
        electricCar.displayInfo();
    }
}
