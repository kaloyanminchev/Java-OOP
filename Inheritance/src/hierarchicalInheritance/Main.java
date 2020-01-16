package hierarchicalInheritance;

public class Main {
    public static void main(String[] args) {
        Animal animal = new Animal();
        System.out.println("hierarchicalInheritance.Animal:");
        animal.eat();

        Dog dog = new Dog();
        System.out.println("hierarchicalInheritance.Dog:");
        dog.eat();
        dog.bark();

        Puppy puppy = new Puppy();
        System.out.println("hierarchicalInheritance.Puppy:");
        puppy.eat();
        puppy.bark();
        puppy.weep();

        Cat cat = new Cat();
        System.out.println("hierarchicalInheritance.Cat:");
        cat.eat();
        cat.meow();
    }
}
