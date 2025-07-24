package myPackage;

public class LibraryManagement {
    Book[] books;

    public LibraryManagement(Book[] books) {
        this.books = books;
    }
   
    public Book findBookByTitle(String title, String sortingAlgorithm) {
        if (title == null || title.isEmpty()) {
            System.out.println("Title cannot be null or empty.");
            return null;
        }
        SearchingSystem searchingSystem = new SearchingSystem();
        if (sortingAlgorithm.equalsIgnoreCase("linear")) {
            return searchingSystem.findBookBylinearSearch(books, title);
        } else if (sortingAlgorithm.equalsIgnoreCase("binary")) {
            return searchingSystem.findBookByBinarySearch(books, title);
        } else {
            System.out.println("Invalid sorting algorithm specified. Use 'linear' or 'binary'.");
            return null;
        }
    }


    public void displayBooks() {
        for (Book b : books) System.out.println(b);
    }
}
