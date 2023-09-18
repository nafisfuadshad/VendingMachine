import java.util.Scanner;

public class VendingMachine {
    private Inventory inventory;
    private double totalAmount = 0.0;

    public VendingMachine() {
        inventory = new Inventory();
    }
    public void displayMenu() {
        System.out.println("Welcome to the Vending Machine!");
        System.out.println("Available items:");

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                if (inventory.isItemAvailable(row, col)) {
                    ItemType item = inventory.getItemType(row, col);
                    double price = inventory.getItemPrice(row, col);
                    String itemInfo = (row + 1) + " " + (col + 1) + ". " + item + " - $" + price;
                    System.out.println(itemInfo);
                }
            }
        }
    }
    public void selectItem(int row, int col) {
        if (inventory.isItemAvailable(row, col)) {
            ItemType selectedItem = inventory.getItemType(row, col);
            double itemPrice = inventory.getItemPrice(row, col);

            System.out.println("You selected: " + selectedItem);
            System.out.println("Price: $" + itemPrice);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Insert coins (e.g., 1.00 for $1.00): $");
            double payment = scanner.nextDouble();

            if (acceptPayment(payment, itemPrice)) {
                inventory.dispenseItem(row, col);
                totalAmount += itemPrice;
            }
        } else {
            System.out.println("Item not available. Please choose another item.");
        }
    }

    public boolean acceptPayment(double payment, double itemPrice) {
        if (payment < itemPrice) {
            System.out.println("Insufficient payment. Please insert more coins.");
            return false;
        } else {
            double change = getChange(payment, itemPrice);
            System.out.println("Dispensing item...");
            if (change > 0) {
                System.out.println("Change: $" + change);
            }
            return true;
        }
    }
    public double getChange(double payment, double itemPrice) {
        return payment - itemPrice;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.displayMenu();

        while (true) {
            System.out.print("Enter your selection (Example 1 4) or 0 to exit: ");
            int row = scanner.nextInt();
            if (row == 0) {
                break;
            }
            int col = scanner.nextInt();

            if (row < 1 || row > 6 || col < 1 || col > 6) {
                System.out.println("Invalid input. Please try again.");
            } else {
                vendingMachine.selectItem(row - 1, col - 1);
            }
        }

        System.out.println("Thank you for using the Vending Machine!");
        System.out.println("Total amount earned: $" + vendingMachine.getTotalAmount());
        scanner.close();
    }
}
