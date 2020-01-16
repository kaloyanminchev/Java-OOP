package salaryIncrease;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;
    private double salary;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
//        this.salary = salary;
    }

    public Person(String firstName, String lastName, int age, double salary) {
        this(firstName, lastName, age);
        this.salary = salary;
    }

    private String getFirstName() {
        return this.firstName;
    }

    private String getLastName() {
        return this.lastName;
    }

    private int getAge() {
        return this.age;
    }

    private double getSalary() {
        return this.salary;
    }

    private void setSalary(double salary) {
        this.salary = salary;
    }

    public void increaseSalary(double bonus) {
        double percentage;
        if (this.getAge() < 30) {
            percentage = 1 + bonus / 200;
        } else {
            percentage = 1 + bonus / 100;
        }
        double finalSalary = this.salary * percentage;
        setSalary(finalSalary);
    }

    @Override
    public int compareTo(Person person) {
        int comp = this.firstName.compareTo(person.getFirstName());
        if (comp == 0) {
            return this.age - person.getAge();
        } else {
            return comp;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %s leva",
                this.getFirstName(),
                this.getLastName(),
                this.getSalary());
    }
}
