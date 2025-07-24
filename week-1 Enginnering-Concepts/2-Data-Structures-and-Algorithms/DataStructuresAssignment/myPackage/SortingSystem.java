package myPackage;

public class SortingSystem {
    public Order[] bubbleSortAscending(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
        return orders; // Sorted array of orders by total price in ascending order
    }

    public Order[] bubbleSortDescending(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (orders[j].totalPrice < orders[j + 1].totalPrice) {
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
        return orders; // Sorted array of orders by total price in descending order
    }

    public void quickSortAscending(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partitionAscending(orders, low, high);
            quickSortAscending(orders, low, pi - 1);
            quickSortAscending(orders, pi + 1, high);
        }
    }

    private int partitionAscending(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice < pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }

    public void quickSortDescending(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partitionDescending(orders, low, high);
            quickSortDescending(orders, low, pi - 1);
            quickSortDescending(orders, pi + 1, high);
        }
    }


    private int partitionDescending(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice > pivot) { 
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
