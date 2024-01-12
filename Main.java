import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private String ISBN;
    private int quantity;

    public Book(String title, String author, String ISBN, int quantity) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.quantity = quantity;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getQuantity() {
        return quantity;
    }

    public void sellBooks(int quantitySold) {
        if (quantitySold <= quantity && quantitySold > 0) {
            quantity -= quantitySold;
            System.out.println("Yay! You have successfully sold " + quantitySold + " copies of '" + title + "'!");
        } else {
            System.out.println("Oops! Not enough stock to sell. Available quantity: " + quantity);
        }
    }

    public void addStock(int quantityToAdd) {
        if (quantityToAdd > 0) {
            quantity += quantityToAdd;
            System.out.println("Yay! " + quantityToAdd + " copies of '" + title + "' have been added to the stock!");
        } else {
            System.out.println("Invalid quantity. Please enter a positive value.");
        }
    }
}

class BookstoreManagementSystem {
    private ArrayList<Book> inventory;

    public BookstoreManagementSystem() {
        this.inventory = new ArrayList<>();
    }

    public void addBook(String title, String author, String ISBN, int quantity) {
        Book newBook = new Book(title, author, ISBN, quantity);
        inventory.add(newBook);
        System.out.println("Yay! The book '" + title + "' by " + author + " has been added to your cute inventory!");
    }

    public void displayInventory() {
        System.out.println("📚 Your Cute Book Inventory 📚");

        if (inventory.isEmpty()) {
            System.out.println("Oops! Your cute inventory is empty. Add some adorable books!");
        } else {
            for (Book book : inventory) {
                System.out.println("Title: " + book.getTitle());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("ISBN: " + book.getISBN());
                System.out.println("Quantity: " + book.getQuantity());
                System.out.println("------------------------------");
            }
        }
    }

    public void sellBooks(String ISBN, int quantitySold) {
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                book.sellBooks(quantitySold);
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in inventory.");
    }

    public void generateSalesReport() {
        int totalSold = 0;
        int remainingStock = 0;

        System.out.println("📊 Sales Report 📊");

        for (Book book : inventory) {
            int sold = book.getQuantity() - book.getQuantity();
            int remaining = book.getQuantity();

            totalSold += sold;
            remainingStock += remaining;

            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getISBN());
            System.out.println("Quantity Sold: " + sold);
            System.out.println("Remaining Stock: " + remaining);
            System.out.println("------------------------------");
        }

        System.out.println("Total Quantity Sold: " + totalSold);
        System.out.println("Total Remaining Stock: " + remainingStock);
    }

    public void addStock(String ISBN, int quantityToAdd) {
        for (Book book : inventory) {
            if (book.getISBN().equals(ISBN)) {
                book.addStock(quantityToAdd);
                return;
            }
        }
        System.out.println("Book with ISBN " + ISBN + " not found in inventory.");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BookstoreManagementSystem bookstoreManagementSystem = new BookstoreManagementSystem();

        System.out.println("🌸 Welcome to Cute Book Manager! 🌸");

        while (true) {
            System.out.println("1. Add an adorable book");
            System.out.println("2. Display your cute book inventory");
            System.out.println("3. Sell books");
            System.out.println("4. Generate sales report");
            System.out.println("5. Exit");
            System.out.println("6. Add stock");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("📖 Enter details for the adorable book:");
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String ISBN = scanner.nextLine();
                    System.out.print("Quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();

                    bookstoreManagementSystem.addBook(title, author, ISBN, quantity);
                    break;

                case 2:
                    bookstoreManagementSystem.displayInventory();
                    break;

                case 3:
                    System.out.println("💸 Enter details for selling books:");
                    System.out.print("ISBN: ");
                    String sellISBN = scanner.nextLine();
                    System.out.print("Quantity to sell: ");
                    int sellQuantity = scanner.nextInt();
                    scanner.nextLine();

                    bookstoreManagementSystem.sellBooks(sellISBN, sellQuantity);
                    break;

                case 4:
                    bookstoreManagementSystem.generateSalesReport();
                    break;

                case 5:
                    System.out.println("Thank you for using Cute Book Manager! 🌈");
                    scanner.close();
                    System.exit(0);

                case 6:
                    System.out.println("📈 Enter details to add stock:");
                    System.out.print("ISBN: ");
                    String addStockISBN = scanner.nextLine();
                    System.out.print("Quantity to add: ");
                    int quantityToAdd = scanner.nextInt();
                    scanner.nextLine();

                    bookstoreManagementSystem.addStock(addStockISBN, quantityToAdd);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
