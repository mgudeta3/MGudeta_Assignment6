public interface OrderInterface {
    boolean isWeekend();

    void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup);

    void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein);

    void addNewBeverage(String bevName, Size size);

    Beverage getBeverage(int index);

    int getTotalItems();

    double calcOrderTotal();
}
