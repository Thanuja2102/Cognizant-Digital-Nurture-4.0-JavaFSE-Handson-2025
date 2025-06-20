public class Search {


    public static boolean isEqualIgnoreCase(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (Character.toLowerCase(s1.charAt(i)) != Character.toLowerCase(s2.charAt(i))) {
                return false;
            }
        }
        return true;
    }


    public static int compareIgnoreCase(String s1, String s2) {
        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            char c1 = Character.toLowerCase(s1.charAt(i));
            char c2 = Character.toLowerCase(s2.charAt(i));
            if (c1 != c2) return c1 - c2;
        }
        return s1.length() - s2.length();
    }

    public static Product manualLinearSearch(Product[] products, String targetName) {
        for (Product p : products) {
            if (isEqualIgnoreCase(p.productName, targetName)) {
                return p;
            }
        }
        return null;
    }


    public static void manualSort(Product[] products) {
        int n = products.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (compareIgnoreCase(products[j].productName, products[j + 1].productName) > 0) {
                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }

    public static Product manualBinarySearch(Product[] products, String targetName) {
        manualSort(products);

        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = compareIgnoreCase(products[mid].productName, targetName);

            if (cmp == 0) return products[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }
}


