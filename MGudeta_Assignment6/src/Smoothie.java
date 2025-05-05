/**
 * Smoothie class extends Beverage and includes fruit count and optional protein.
 */
public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;

    private final double COST_PER_FRUIT = 0.5;
    private final double PROTEIN_COST = 1.5;

    /**
     * Constructs a Smoothie object.
     *
     * @param bevName     name of the smoothie
     * @param size        size of the smoothie
     * @param numOfFruits number of fruits in the smoothie
     * @param addProtein  true if protein is added
     */
    public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) {
        super(bevName, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public int getNumOfFruits() {
        return numOfFruits;
    }

    public boolean getAddProtein() {
        return addProtein;
    }

    /**
     * Calculates the price of the smoothie.
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

        price += numOfFruits * COST_PER_FRUIT;

        if (addProtein) {
            price += PROTEIN_COST;
        }

        return price;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Smoothie [Fruits: " + numOfFruits +
                ", Protein: " + addProtein +
                "] $" + String.format("%.2f", calcPrice());
    }
}
