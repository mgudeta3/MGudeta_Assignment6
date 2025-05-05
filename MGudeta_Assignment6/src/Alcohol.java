/**
 * Alcohol class extends Beverage and adds weekend surcharge.
 */
public class Alcohol extends Beverage {
    private boolean isWeekend;
    private final double WEEKEND_FEE = 0.6;

    /**
     * Constructs an Alcohol object.
     *
     * @param bevName   the name of the drink
     * @param size      the size of the drink
     * @param isWeekend true if purchased on a weekend
     */
    public Alcohol(String bevName, Size size, boolean isWeekend) {
        super(bevName, Type.ALCOHOL, size);
        this.isWeekend = isWeekend;
    }

    public boolean getIsWeekend() {
        return isWeekend;
    }

    /**
     * Calculates the price of the alcohol drink.
     */
    @Override
    public double calcPrice() {
        double price = getBasePrice();

        // Add size-based price
        if (getSize() == Size.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == Size.LARGE) {
            price += 2 * getSizePrice();
        }

        if (isWeekend) {
            price += WEEKEND_FEE;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Alcohol [Weekend: " + isWeekend +
                "] $" + String.format("%.2f", calcPrice());
    }
}
