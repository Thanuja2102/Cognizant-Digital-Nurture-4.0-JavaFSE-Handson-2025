import java.util.Scanner;

public class Main {


    public static double futureValue(double presentValue, double growthRate, int years) {
        if (years == 0) {
            return presentValue;
        }
        return futureValue(presentValue, growthRate, years - 1) * (1 + growthRate);
    }


    public static double futureValueMemo(double presentValue, double growthRate, int years, double[] memo) {
        if (years == 0) {
            return presentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = futureValueMemo(presentValue, growthRate, years - 1, memo) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter present value: ");
        double presentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (e.g., 0.05 for 5%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();


        double result = futureValue(presentValue, growthRate, years);
        System.out.printf("Recursive Future Value after %d years: %.2f\n", years, result);


        double[] memo = new double[years + 1];
        double resultMemo = futureValueMemo(presentValue, growthRate, years, memo);
        System.out.printf("Memoized Future Value after %d years: %.2f\n", years, resultMemo);
    }
}

