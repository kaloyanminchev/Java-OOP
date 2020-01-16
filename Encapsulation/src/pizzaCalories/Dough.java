package pizzaCalories;

public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    public void setFlourType(String flourType) {
        ValidatorUtil.validateFlour(flourType);
        this.flourType = flourType;
    }

    public void setBakingTechnique(String bakingTechnique) {
        ValidatorUtil.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    public void setWeight(double weight) {
        ValidatorUtil.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        double flourModifier = 0;
        switch (this.flourType) {
            case "White":
                flourModifier = 1.5;
                break;
            case "Wholegrain":
                flourModifier = 1.0;
                break;
        }

        double techniqueModifier = 0;
        switch (this.bakingTechnique) {
            case "Crispy":
                techniqueModifier = 0.9;
                break;
            case "Chewy":
                techniqueModifier = 1.1;
                break;
            case "Homemade":
                techniqueModifier = 1.0;
                break;
        }

        return (2 * this.weight) * flourModifier * techniqueModifier;
    }
}
