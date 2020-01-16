package animals;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat("Pesho", "BIBI");
        System.out.println(cat.explainSelf());

        Dog dog = new Dog("Florest", "Kokali");
        System.out.println(dog.explainSelf());

        Animal puppy = new Dog("Koko", "morkov");
        System.out.println(puppy.explainSelf());

    }
}
