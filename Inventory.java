public class Inventory {
    private ItemType[][] items;
    private double[][] prices;
    private int[][] quantities;

    public Inventory() {
        items = new ItemType[6][6];
        prices = new double[6][6];
        quantities = new int[6][6];

        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 6; col++) {
                items[row][col] = ItemType.EMPTY;
                prices[row][col] = 0.0;
                quantities[row][col] = 0;
            }
        }
        items[0][0] = ItemType.SODA;
        prices[0][0] = 1.50;
        quantities[0][0] = 5;

        items[0][1] = ItemType.CHIPS;
        prices[0][1] = 1.00;
        quantities[0][1] = 5;

        items[0][2] = ItemType.CANDY;
        prices[0][2] = 0.75;
        quantities[0][2] = 5;

        items[0][3] = ItemType.WATER;
        prices[0][3] = 1.25;
        quantities[0][3] = 5;

        items[1][0] = ItemType.COOKIE;
        prices[1][0] = 1.25;
        quantities[1][0] = 5;

        items[1][1] = ItemType.SANDWICH;
        prices[1][1] = 2.50;
        quantities[1][1] = 5;
    }

    public ItemType getItemType(int row, int col) {
        return items[row][col];
    }

    public double getItemPrice(int row, int col) {
        return prices[row][col];
    }

    public boolean isItemAvailable(int row, int col) {
        return quantities[row][col] > 0;
    }

    public void dispenseItem(int row, int col) {
        if (quantities[row][col] > 0) {
            quantities[row][col]--;
        }
    }
}
