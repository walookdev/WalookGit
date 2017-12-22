class Person {
    private String name;
    private String lastName;

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Person() {
        this.name = "John";
        this.lastName = "Doe";
    }

    public String getFirstName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }
}