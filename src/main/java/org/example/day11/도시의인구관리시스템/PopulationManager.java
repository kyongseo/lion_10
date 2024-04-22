package org.example.day11.도시의인구관리시스템;

import java.util.HashMap;
import java.util.Scanner;

public class PopulationManager {
    HashMap<String, Integer> cityPopulation = new HashMap<>();

    public void addOrUpdateCity(String city, int population){

        if (cityPopulation.containsKey(city)){
            System.out.println(city + "의 인구수는 " + population + "명입니다.");
        } else {
            System.out.println("새로운 도시 " + city + "를 추가합니다.");
        }
        cityPopulation.put(city,population);
    }

    public void removeCity(String city){
        if (cityPopulation.containsKey(city)) {
            cityPopulation.remove(city);

            System.out.println(city + "를 삭제합니다.");
        } else {
            System.out.println("도시가 존재하지 않습니다.");
        }
    }

    public void displayPopulation(String city){
        if (cityPopulation.containsKey(city)) {
            System.out.println(city + "의 인구수는 " + cityPopulation.get(city) + "명입니다.");
        }else {
            System.out.println("도시가 존재하지 않습니다.");
        }
    }

    public void displayAll(){
        for (String city : cityPopulation.keySet()){
            System.out.println(city + "인구수는 " + cityPopulation.get(city) + "명입니다.");
        }
    }

    public static void main(String[] args) {
        PopulationManager manager = new PopulationManager();
        Scanner scanner = new Scanner(System.in);

        manager.addOrUpdateCity("서울", 10000000);
        manager.addOrUpdateCity("부산", 3500000);

        while (true) {
            System.out.print("명령을 입력하세요 (1. 추가/수정, 2. 삭제, 3. 조회, 4. 전체 조회, 0. 종료): ");
            String command = scanner.next();
            if (command.equals("0")) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }

            String city;
            switch (command) {
                case "1":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    System.out.print("인구를 입력하세요: ");
                    int population = scanner.nextInt();
                    manager.addOrUpdateCity(city, population);
                    break;
                case "2":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.removeCity(city);
                    break;
                case "3":
                    System.out.print("도시 이름을 입력하세요: ");
                    city = scanner.next();
                    manager.displayPopulation(city);
                    break;
                case "4":
                    manager.displayAll();
                    break;
                default:
                    System.out.println("알 수 없는 명령입니다.");
            }
        }
        scanner.close();
    }
}