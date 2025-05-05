import java.util.Scanner;

public class BevShopDriverApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        BevShop shop = new BevShop();

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        // First Order
        System.out.println("Start please a new order:");
        System.out.println("Your Total Order for now is 0.0");
        System.out.print("Would you please enter your name: ");
        String name1 = input.nextLine();

        System.out.print("Would you please enter your age: ");
        int age1 = input.nextInt();
        input.nextLine(); // Consume newline

        if (shop.isValidAge(age1)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
        } else {
            System.out.println("Your age is not eligible for alcohol.");
        }

        shop.startNewOrder(12, Day.FRIDAY, name1, age1);

        // Alcohol 1
        if (shop.isValidAge(age1)) {
            System.out.println("Would you please add an alcohol drink");
            shop.processAlcoholOrder("Wine", Size.SMALL);
            System.out.println("The current order of drinks is 1");
            System.out.printf("The Total price on the Order is %.1f\n", shop.getCurrentOrder().calcOrderTotal());

            // Alcohol 2
            if (shop.isEligibleForMore()) {
                System.out.println("Your current alcohol drink order is less than 4");
                System.out.println("Would you please add a second alcohol drink");
                shop.processAlcoholOrder("Vodka", Size.MEDIUM);
                System.out.println("The current order of drinks is 2");
                System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());
            }

            // Alcohol 3
            if (shop.isEligibleForMore()) {
                System.out.println("Your current alcohol drink order is less than 4");
                System.out.println("Add third alcohol drink");
                shop.processAlcoholOrder("Beer", Size.LARGE);
                System.out.println("The current order of drinks is 3");
                System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());
            }

            // Alcohol 4 (exceeds max)
            if (!shop.isEligibleForMore()) {
                System.out.println("You have a maximum alcohol drinks for this order");
            }
        }

        // Add Coffee
        System.out.println("Would you please add a COFFEE to your order:");
        shop.processCoffeeOrder("Espresso", Size.MEDIUM, true, false);
        System.out.println("Total items on your order is " + shop.getCurrentOrder().getTotalItems());
        System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());

        System.out.println("#------------------------------------#");

        // Second Order
        System.out.println("Would you please start a new order");
        System.out.print("Would you please enter your name: ");
        String name2 = input.nextLine();

        System.out.print("Would you please enter your age: ");
        int age2 = input.nextInt();
        input.nextLine();

        shop.startNewOrder(15, Day.SATURDAY, name2, age2);
        System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());

        
        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Berry Blend", Size.LARGE, 3, true);
        System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());

        
        System.out.println("Would you please add a SMOOTHIE to order");
        shop.processSmoothieOrder("Tropical Splash", Size.MEDIUM, 2, false);

        // Coffee
        System.out.println("Would you please add a COFFEE to order");
        shop.processCoffeeOrder("Latte", Size.SMALL, false, true);
        System.out.printf("The Total Price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());

        
        System.out.println("Would you please add a drink");
        if (!shop.isValidAge(age2)) {
            System.out.println("Your Age is not appropriate for alcohol drink!!");
        }

        System.out.println("The current order of drinks is " + shop.getCurrentOrder().getTotalItems());
        System.out.printf("The Total price on the Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());

        System.out.println("The total number of fruits is 5");
        System.out.println("You reached a Maximum number of fruits");

        // Summary
        System.out.printf("\nTotal price on the second Order: %.1f\n", shop.getCurrentOrder().calcOrderTotal());
        System.out.printf("Total amount for all Orders: %.1f\n", shop.totalMonthlySale());

        input.close();
    }
}
