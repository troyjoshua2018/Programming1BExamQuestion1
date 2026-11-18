import java.sql.SQLOutput;
import java.util.Scanner;

public class SalesReport {
    public static void main(String[] args) {
        String[] names = {"Cozy Nights Monarch", "Restonic Barbados", "Sealy Phuket"};
        int months = 3;
        int[][] sales = new int[names.length][months];
        Scanner in = new Scanner(System.in);

        for(int i = 0; i < names.length; i++) {
            for (int j = 0; j < months; j++) {
                System.out.print("Enter Number of Sales for month " + (j + 1) + " for " + names[i] + " mattress: ");
                sales[i][j] = in.nextInt();
                System.out.println();
            }
            System.out.println();
        }

        IProduct product = new Product(names, sales);
        new PrintProduct(product).PrintReport();
    }
}
