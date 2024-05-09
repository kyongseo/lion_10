package org.example.toyproject.day11.사원관리시스템;

import java.util.HashSet;
import java.util.Set;

public class EmployeeManager {
    Set<Employee> employees = new HashSet<>();

    public void addEmployee(Employee employee) {
        if (employees.add(employee)) {
            System.out.println("사원 추가 성공 : " + employee);
        } else {
            System.out.println("이미 존재하는 사원입니다. : " + employee);
        }
    }

    void findEmployee(String id) {
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                System.out.println("사원 검색 : " + employee.getName() + " " + employee.getId() + " " +employee.getDepartment());
                return;
            }
        }
        System.out.println("해당 사원을 찾을 수 없습니다.");
    }

    void removeEmployee(Employee employee) {
        if (employees.remove(employee)) {
            System.out.println("사원 삭제 성공 : " + employee);
        } else {
            System.out.println("존재하는 않는 사원입니다." + employee);
        }
    }
}