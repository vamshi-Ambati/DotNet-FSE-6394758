package myPackage;

import java.util.Arrays;
import java.util.Comparator;

public class SearchingSystem {
    
    public Product findProductByLinearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                // Found the product
                return product;
            }
        }
        return null;
    }
    

    public Product findProductByBinarySearch(Product[] products, String name) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName));
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(name);
            if (cmp == 0) {
                return products[mid]; // Found the product
            }
            else if (cmp < 0) {
                left = mid + 1; // Eliminating the left half
            }
            else {
                right = mid - 1; // Eliminating the right half
            }
        }
        return null;
    }


    public Book findBookBylinearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public Book findBookByBinarySearch(Book[] books, String title) {
        Arrays.sort(books, Comparator.comparing(b -> b.title.toLowerCase())); 

        int low = 0, high = books.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) return books[mid];
            else if (cmp < 0) low = mid + 1;
            else high = mid - 1;
        }
        return null;
    }

}
