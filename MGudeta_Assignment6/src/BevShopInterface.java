public interface BevShopInterface {
    boolean isValidTime(int time);

    int getMaxNumOfFruits();

    int getMinAgeForAlcohol();

    boolean isEligibleForMore();

    boolean isValidAge(int age);

    void startNewOrder(int time, Day day, String customerName, int customerAge);

    void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup);

    void processAlcoholOrder(String bevName, Size size);

    void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein);

    int findOrder(int orderNo);

    double totalOrderPrice(int orderNo);

    double totalMonthlySale();

    int totalNumOfMonthlyOrders();

    Order getCurrentOrder();

    Order getOrderAtIndex(int index);

    int getNumOfAlcoholDrink();

    int getMaxOrderForAlcohol();

    int getMaxOrder();
}
