/**
 * Abstract class representing a general beverage.
 */
public abstract class Beverage {
    private String bevName;
    private Type type;
    private Size size;

    private final double BASE_PRICE = 2.0;
    private final double SIZE_PRICE = 1.0;

    /**
     * Constructs a Beverage object
     * 
     * @param bevName the name of the beverage
     * @param type    the type of the beverage (ALCOHOL, COFFEE, SMOOTHIE)
     * @param size    the size of the beverage (SMALL, MEDIUM, LARGE)
     */
    public Beverage(String bevName, Type type, Size size) {
        this.bevName = bevName;
        this.type = type;
        this.size = size;
    }

    public String getBevName() {
        return bevName;
    }

    public Type getType() {
        return type;
    }

    public Size getSize() {
        return size;
    }

    public double getBasePrice() {
        return BASE_PRICE;
    }

    public double getSizePrice() {
        return SIZE_PRICE;
    }

    /**
     * Calculates the price of the beverage. Must be implemented by subclasses.
     * 
     * @return the calculated price
     */
    public abstract double calcPrice();

    @Override
    public String toString() {
        return bevName + ", " + size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Beverage)) return false;

        Beverage other = (Beverage) o;

        return bevName.equals(other.bevName) &&
               type == other.type &&
               size == other.size;
    }
}
