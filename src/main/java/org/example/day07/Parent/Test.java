package org.example.day07.Parent;

public class Test {
    public static void main(String[] args) {

        Child child = new Child();

        String name = child.getName();
        System.out.println(name);

        System.out.println(child);
        System.out.println(child.toString());

        String str = "hello";
        System.out.println(str);
        System.out.println(str.toString());

        Product product = new Product("검정펜",30000);

 //       product.getTitle();
 //       product.getPrice();

        System.out.println(product);

        Product product2 = new Product("검정펜",2000);

        // == 연산은 주소를 봐주는 것
        if (product == product2){
            System.out.println("== 같아요");
        } else { System.out.println("== 달라요");
        }

        if (product2.equals(product)){
            System.out.println("equals 같아요");
        } else { System.out.println("equals 달라요");
        }

 //       if (product.equals(product))

        /*
         * getClass()로 클래스로 비교하기
         */
        System.out.println(product.getClass()); // 동일
        System.out.println(product2.getClass()); // 동일
    }
}
