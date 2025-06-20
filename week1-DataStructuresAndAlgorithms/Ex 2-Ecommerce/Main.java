import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(102, "Shoes", "Footwear"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "T-Shirt", "Apparel")
        };

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String target = sc.nextLine();


        Product linearResult = Search.manualLinearSearch(products, target);
        System.out.println("\nLinear Search Result:");
        System.out.println(linearResult != null ? linearResult : "Product not found.");


        Product binaryResult = Search.manualBinarySearch(products, target);
        System.out.println("\nBinary Search Result:");
        System.out.println(binaryResult != null ? binaryResult : "Product not found.");

        sc.close();
    }
}


