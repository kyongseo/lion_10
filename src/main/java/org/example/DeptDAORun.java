package org.example;

public class DeptDAORun {
    public static void main(String[] args) {
        DeptDAO deptDAO = new DeptDAO();
        DeptDTO deptDTO = new DeptDTO();
        deptDTO.setDeptno(60);
        deptDTO.setDeptname("like");
        deptDTO.setLoc("판교");


        // add
//        boolean resultFlag = deptDAO.addDept(deptDTO);
//        if (resultFlag)
//            System.out.println("성공!!");
//        else
//            System.out.println("실패ㅠㅠ");
//
        // update
        int resultCount = deptDAO.updateDept(deptDTO);
        System.out.println(resultCount);

    }
}
