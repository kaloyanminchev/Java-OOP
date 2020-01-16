package wildFarm.animals;

public class Cat extends Felime {
    private String breed;

    public Cat(String name, String type, Double weight, String livingRegion, String breed) {
        super(name, type, weight, livingRegion);
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public String toString() {
        String baseStr = super.toString();
        int index = baseStr.indexOf(",");

        StringBuilder sb = new StringBuilder(baseStr);
        sb.insert(index + 2, this.breed + ", ");

        return sb.toString();
    }
}
