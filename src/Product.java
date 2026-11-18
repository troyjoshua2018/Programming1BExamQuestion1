public class Product implements IProduct {
    private final String[] productNames; // single-dimensional array
    private final int[][] sales;         // two-dimensional array [product][month]

    public Product(String[] productNames, int[][] sales) {
        this.productNames = productNames;
        this.sales = sales;
    }

    @Override
    public int GetTotalProductsSold() {
        int total = 0;
        for (int[] row : sales)
            for (int s : row)
                total += s;
        return total;
    }

    @Override
    public double GetAverageProductSold() {
        int count = sales.length * sales[0].length;
        return (double) GetTotalProductsSold() / count;
    }

    @Override
    public String GetMostPopularProduct() {
        int bestIndex = 0, bestTotal = -1;
        for (int i = 0; i < sales.length; i++) {
            int rowTotal = 0;
            for (int s : sales[i]) rowTotal += s;
            if (rowTotal > bestTotal) {
                bestTotal = rowTotal;
                bestIndex = i;
            }
        }
        return productNames[bestIndex];
    }
}