package singleInheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("singleInheritance.multipleInheritance.hierarchicalInheritance.Animal:");
        animal.eat();

        Dog dog = new Dog();
        System.out.println("singleInheritance.multipleInheritance.hierarchicalInheritance.Dog:");
        dog.eat();
        dog.bark();
    }
}
