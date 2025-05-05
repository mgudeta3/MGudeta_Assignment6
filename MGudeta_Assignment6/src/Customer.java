/**
 * Represents a Customer with name and age.
 */
public class Customer {
    private String name;
    private int age;

    /**
     * Constructs a Customer object with a name and age.
     *
     * @param name the customer's name
     * @param age  the customer's age
     */
    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Copy constructor to create a deep copy of a customer.
     *
     * @param other the Customer object to copy
     */
    public Customer(Customer other) {
        this.name = other.name;
        this.age = other.age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return name + ", " + age;
    }
}
