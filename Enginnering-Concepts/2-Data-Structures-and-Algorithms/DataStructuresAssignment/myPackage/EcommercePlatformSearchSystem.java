package myPackage;

public class EcommercePlatformSearchSystem {

    public Product findProduct(Product[] products, String productName, String searchType) {
        SearchingSystem searchingSystem = new SearchingSystem();
        if (products.length == 0) {
            System.out.println("No products available to search.");
            return null; // No products to search
        }
        if (searchType.equalsIgnoreCase("linear")) {
            return searchingSystem.findProductByLinearSearch(products, productName);
        } else if (searchType.equalsIgnoreCase("binary")) {
            return searchingSystem.findProductByBinarySearch(products, productName);
        }
        return null; // Invalid search type
    }


    public void sortOrders(Order[] orders, String sortingOrder, String sortingAlgorithm) {
        SortingSystem sortingSystem = new SortingSystem();
        if (sortingAlgorithm.equalsIgnoreCase("bubble")) {
            if (sortingOrder.equalsIgnoreCase("ascending")) {
                sortingSystem.bubbleSortAscending(orders);
            } else if (sortingOrder.equalsIgnoreCase("descending")) {
                sortingSystem.bubbleSortDescending(orders);
            }
        } else if (sortingAlgorithm.equalsIgnoreCase("quick")) {
            if (sortingOrder.equalsIgnoreCase("ascending")) {
                sortingSystem.quickSortAscending(orders, 0, orders.length - 1);
            } else if (sortingOrder.equalsIgnoreCase("descending")) {
                sortingSystem.quickSortDescending(orders, 0, orders.length - 1);
            }
        }

    }


}