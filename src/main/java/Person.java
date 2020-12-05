public class Person {
    private String name;
    private int age;

    Person(String name, int age) {
        this.name = name;
        if (age > 50) {
            throw new IllegalArgumentException();
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
