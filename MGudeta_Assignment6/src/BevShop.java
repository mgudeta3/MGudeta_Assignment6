import java.util.ArrayList;

/**
 * BevShop manages beverage orders for multiple customers.
 */
public class BevShop implements BevShopInterface {
    private int numOfAlcoholInCurrentOrder;
    private ArrayList<Order> orders;
    private Order currentOrder;

    private final int MIN_AGE = 21;
    private final int MAX_ORDER_FOR_ALCOHOL = 3;
    private final int MAX_ORDER = 10;
    private final int MIN_TIME = 8;
    private final int MAX_TIME = 23;

    public BevShop() {
        orders = new ArrayList<>();
    }

    @Override
    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    @Override
    public int getMaxNumOfFruits() {
        return 5;
    }

    @Override
    public int getMinAgeForAlcohol() {
        return MIN_AGE;
    }

    @Override
    public boolean isEligibleForMore() {
        return numOfAlcoholInCurrentOrder < MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public boolean isValidAge(int age) {
        return age >= MIN_AGE;
    }

    @Override
    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        orders.add(currentOrder);
        numOfAlcoholInCurrentOrder = 0;
    }

    @Override
    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    @Override
    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    @Override
    public void processAlcoholOrder(String bevName, Size size) {
        currentOrder.addNewBeverage(bevName, size);
        numOfAlcoholInCurrentOrder++;
    }

    @Override
    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0;
    }

    @Override
    public double totalMonthlySale() {
        double total = 0;
        for (Order order : orders) {
            total += order.calcOrderTotal();
        }
        return total;
    }

    @Override
    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    @Override
    public Order getCurrentOrder() {
        return currentOrder;
    }

    @Override
    public Order getOrderAtIndex(int index) {
        if (index >= 0 && index < orders.size()) {
            return orders.get(index);
        }
        return null;
    }

    @Override
    public int getNumOfAlcoholDrink() {
        return numOfAlcoholInCurrentOrder;
    }

    @Override
    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    @Override
    public int getMaxOrder() {
        return MAX_ORDER;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Order order : orders) {
            sb.append(order.toString()).append("\n\n");
        }
        sb.append("Total Monthly Sale: $")
          .append(String.format("%.2f", totalMonthlySale()));
        return sb.toString();
    }
}
