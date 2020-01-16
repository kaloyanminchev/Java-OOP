package sortedByNameAndAge;

public class Person implements Comparable<Person> {
    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s is %d years old.",
                this.getFirstName(),
                this.getLastName(),
                this.getAge()
        );
    }

    @Override
    public int compareTo(Person person) {
        int comp = this.getFirstName().compareTo(person.getFirstName());
        if (comp != 0) {
            return comp;
        } else {
            return Integer.compare(this.getAge(), person.getAge());
        }
    }
}
