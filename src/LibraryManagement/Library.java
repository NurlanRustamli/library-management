package LibraryManagement;

import java.util.Arrays;
import java.util.Scanner;

public class Library {
    Scanner sc = new Scanner(System.in);
    String[] books = new String[10];
    String[] borrowedBooks = new String[10];
    public void LibraryManage() {

        int choice;

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. View Books");
            System.out.println("2. Borrow a Book");
            System.out.println("3. Return a Book");
            System.out.println("4. Add a Book");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewBooks();
                    break;
                case 2:
                    System.out.print("Enter the name of the book to borrow: ");
                    String borrowedBook = sc.nextLine();
                    borrowBook(borrowedBook);
                    break;
                case 3:
                    System.out.print("Enter the name of the book to return: ");
                    String returnBook = sc.nextLine();
                    returnBook(returnBook);
                    break;
                case 4:
                    System.out.print("Enter the name of the new book: ");
                    String newBook = sc.nextLine();
                    addBook(newBook);
                    break;
                case 5:
                    System.out.println("Exiting the system...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }


    public void viewBooks(){
        System.out.println("Library:");
        for (int i = 0; i < books.length; i++) {
            System.out.println("Book Name "+books[i]);
        }
    }
    public void addBook(String bookName){
//        int[] emptyNumbers = new  int[10];
//        int[] fullNumbers = new int[10];
//        for (int i = 0; i < books.length; i++) {
//            if (books[i] == null) {
//           int j = 0;
//                emptyNumbers[j] = i;
//                j++;
//            }
//
//        }
//
//        books[emptyNumbers[0]]= bookName;
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = bookName;
                System.out.println("Book added: " + bookName);
                return;
            }
        }
        System.out.println("Library is full. Cannot add more books.");
    }
   public void borrowBook(String bookName){
       int j=0;
       for (int i = 0; i < books.length; i++) {
           if (books[i]!=null&&books[i].equals(bookName)) {
               books[i]="borrowed";
               borrowedBooks[j]=bookName;
               j++;
               System.out.println("Book borrowed: " + bookName);
               return;
           }
           System.out.println("You can't take book ");
           return;
       }
       System.out.println("There is no book which name is like this");
    }
    public void returnBook(String bookName){
        System.out.println("Borrowed Books" + (Arrays.toString(borrowedBooks)));

        for (int i = 0; i < books.length; i++) {
            if (books[i].equals("borrowed")) {
books[i]=bookName;
                System.out.println("Successfully returned");
                return;
            }
            return;
        }

        borrowedBooks[findIndex(borrowedBooks,bookName)] = "";
    }
    public static int findIndex(String[] a,String t){
        if (a == null) {
            return -1;
        }
        int len = a.length;
        int i = 0;

        while (i<len){
            if (a[i]==t) {
                return i;
            }
            else{
                i++;
            }
        }
        return -1;
    }
}

