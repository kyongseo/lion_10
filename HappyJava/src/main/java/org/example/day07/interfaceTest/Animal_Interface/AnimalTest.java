package org.example.day07.interfaceTest.Animal_Interface;

public class AnimalTest {
    public static void main(String[] args) {
        Animal dog = new Dog();
        Animal cat = new Cat();

        dog.speak();
        cat.speak();

        System.out.println(Animal.AGE);
        System.out.println(Animal.Name);
    }
}
