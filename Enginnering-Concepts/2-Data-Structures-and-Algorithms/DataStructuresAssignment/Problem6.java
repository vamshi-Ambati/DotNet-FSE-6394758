import myPackage.Book;
import myPackage.LibraryManagement;
import java.util.Scanner;

public class Problem6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of books: ");
        int n = Integer.parseInt(scanner.nextLine());
        Book[] bookArray = new Book[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for book " + (i + 1) + ":");
            System.out.print("Book ID: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.print("Title: ");
            String title = scanner.nextLine();
            System.out.print("Author: ");
            String author = scanner.nextLine();
            bookArray[i] = new Book(id, title, author);
        }
        LibraryManagement libraryMangement = new LibraryManagement(bookArray);
        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display All Books");
            System.out.println("2. Search Book by Title");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice == 1) {
                System.out.println("\nAll Books:");
                libraryMangement.displayBooks();
            } else if (choice == 2) {
                System.out.print("Enter book title to search: ");
                String searchTitle = scanner.nextLine();
                System.out.print("Choose search algorithm (linear/binary): ");
                String algo = scanner.nextLine();
                Book found = libraryMangement.findBookByTitle(searchTitle, algo);
                System.out.println(found != null ? found : "Book not found.");
            } else if (choice == 3) {
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }
        scanner.close();
    }

    // linear Search: O(1) for best case, O(n) for average and worst case, where n is the number of books
    // binary Search: O(1) for best, O(log n) for average and worst case, where n is the number of books
    // But the Binary search to be sorted so actually the BinarySearch function will take O(n log n) time to sort the books first,
}
