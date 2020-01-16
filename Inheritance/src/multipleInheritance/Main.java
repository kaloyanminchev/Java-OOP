package multipleInheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("multipleInheritance.hierarchicalInheritance.Animal:");
        animal.eat();

        Dog dog = new Dog();
        System.out.println("multipleInheritance.hierarchicalInheritance.Dog:");
        dog.eat();
        dog.bark();

        Puppy puppy = new Puppy();
        System.out.println("multipleInheritance.hierarchicalInheritance.Puppy:");
        puppy.eat();
        puppy.bark();
        puppy.weep();
    }
}
