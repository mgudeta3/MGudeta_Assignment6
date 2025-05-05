import java.util.ArrayList;
import java.util.Random;

/**
 * Represents a single customer's order.
 */
public class Order implements OrderInterface, Comparable<Order> {
    private int orderTime;
    private Day orderDay;
    private Customer customer;
    private int orderNo;
    private ArrayList<Beverage> beverages;

    /**
     * Constructs an Order object.
     *
     * @param orderTime order time in hours (0–23)
     * @param orderDay  day of the week
     * @param customer  the customer placing the order
     */
    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer); // deep copy
        this.orderNo = generateOrder();
        this.beverages = new ArrayList<>();
    }

    private int generateOrder() {
        Random rand = new Random();
        return rand.nextInt(80001) + 10000; // 10000–90000
    }

    @Override
    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    @Override
    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    @Override
    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    @Override
    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    @Override
    public Beverage getBeverage(int index) {
        if (index >= 0 && index < beverages.size()) {
            return beverages.get(index);
        }
        return null;
    }

    @Override
    public int getTotalItems() {
        return beverages.size();
    }

    @Override
    public double calcOrderTotal() {
        double total = 0;
        for (Beverage b : beverages) {
            total += b.calcPrice();
        }
        return total;
    }

    @Override
    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }

    public int getOrderTime() {
        return orderTime;
    }

    public Day getOrderDay() {
        return orderDay;
    }

    public Customer getCustomer() {
        return new Customer(customer); // return a copy
    }

    public int getOrderNo() {
        return orderNo;
    }

    public ArrayList<Beverage> getBeverages() {
        return beverages;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Order Number: " + orderNo + "\n");
        sb.append("Time: ").append(orderTime).append(", Day: ").append(orderDay).append("\n");
        sb.append("Customer: ").append(customer.toString()).append("\n");

        for (Beverage b : beverages) {
            sb.append(b.toString()).append("\n");
        }

        sb.append("Order Total: $").append(String.format("%.2f", calcOrderTotal()));

        return sb.toString();
    }
}
