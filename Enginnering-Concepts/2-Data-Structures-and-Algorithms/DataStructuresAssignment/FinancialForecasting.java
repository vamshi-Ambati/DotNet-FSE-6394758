import java.util.Scanner;
import myPackage.FutureForcast;

public class FinancialForecasting {
    public static void main(String[] args) {
        FutureForcast futureForcast = new FutureForcast();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\nFuture Value Prediction");
                System.out.print("Enter present value: ");
                double presentValue = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter annual growth rate (e.g., 0.10 for 10%): ");
                double annualGrowthRate = Double.parseDouble(scanner.nextLine());
                System.out.print("Enter number of years: ");
                int years = Integer.parseInt(scanner.nextLine());
                double futureValue = futureForcast.predictFutureValue(presentValue, annualGrowthRate, years);
                System.out.printf("Future Value after %d years: ₹%.2f\n", years, futureValue);
                System.out.print("Do you want to calculate again? (yes/no): ");
                String again = scanner.nextLine();
                if (!again.equalsIgnoreCase("yes")) {
                    System.out.println("Exiting...");
                    break;
                }
            }
        }
    }

    // Time Complexity: O(n), where n is the number of years.
    // Here there is a Space Complexity of O(n) due to the recursive stack space used by the function calls.
}
