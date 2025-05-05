/**
 * Coffee class extends Beverage and adds extra options like extra shot and syrup.
 */
public class Coffee extends Beverage {
    private boolean extraShot;
    private boolean extraSyrup;

    private final double EXTRA_SHOT_COST = 0.5;
    private final double EXTRA_SYRUP_COST = 0.5;

    /**
     * Constructs a Coffee object.
     *
     * @param bevName    name of the coffee
     * @param size       size of the coffee
     * @param extraShot  true if extra shot is added
     * @param extraSyrup true if extra syrup is added
     */
    public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        super(bevName, Type.COFFEE, size);
        this.extraShot = extraShot;
        this.extraSyrup = extraSyrup;
    }

    public boolean getExtraShot() {
        return extraShot;
    }

    public boolean getExtraSyrup() {
        return extraSyrup;
    }

    /**
     * Calculates the total price of the coffee.
     */
    @Override
    public double calcPrice() {
        double price = getBasePrice();

        // Add size price based on size
        if (getSize() == Size.MEDIUM) {
            price += getSizePrice();
        } else if (getSize() == Size.LARGE) {
            price += 2 * getSizePrice();
        }

        if (extraShot) {
            price += EXTRA_SHOT_COST;
        }

        if (extraSyrup) {
            price += EXTRA_SYRUP_COST;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Coffee [Extra Shot: " + extraShot +
                ", Extra Syrup: " + extraSyrup +
                "] $" + String.format("%.2f", calcPrice());
    }
}
