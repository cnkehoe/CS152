/**
 * @version date (in_ISO_8601 format: 2018-04-19
 * @author Carly Kehoe
 */

public class Library {
    
    /** Unique books in the library. */
    private Book[] books;
    
    /** Number of copies for each book. */
    private int[] copies;
    
    /** Number of copies currently checked out for each book. */
    private int[] checkedOut;
    
    /** Number of unique books in the library. */
    private int numBooks;
    
    /** Construct a new empty Library. */
    public Library(int librarySize) {
        books = new Book[librarySize];
        copies = new int[librarySize];
        checkedOut = new int[librarySize];
        numBooks = 0;
    }
    
    /**
     * Get the number of total copies of all books that exist in the
     * library.
     * @return Total number of copies in the library.
     */
    public int getTotalCopies() {
        int total = 0;
        for (int copy : copies) {
            total += copy;
        }
        return total;
    }
    
    /**
     * Get the number of copies currently checked out.
     * @return Total number of copies checked out.
     */
    public int getNumCheckedOut() {
        int total = 0;
        for (int book : checkedOut) {
            total += book;
        }
        return total;
    }
    
    /**
     * Get a String representing the status of the library.
     * @return Status string.
     */
    public String getStatus() {
        return "Total unique books: " + numBooks + "\n" +
                "Total number of copies: " + getTotalCopies() + "\n" +
                "Total checked out: " + getNumCheckedOut();
    }
    
    /**
     * Add all the books in the array to the library. Adds one copy of
     * each book.
     * @param newBooks Books to add.
     */
    public void addBooks( Book[] newBooks ) {
        for (Book book : newBooks) {
            addBook(book);
        }
    
    }
    
    /**
     * Add a single book the library.
     *
     * If the book is already present, adds another copy.
     * If the book is new, add it after the existing books.
     * @param b Book to add.
     */
    public void addBook( Book b ) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] != null && b.equals(books[i])) {
                copies[i]++;
                break;
            }
            else if (books[i] == null) {
                books[i] = b;
                copies[i]++;
                numBooks++;
                break;
            }
        }
    
    }
    
    /**
     * Checks out a book from the library if possible.
     * @param b Book to check out.
     * @return String denoting success or failure.
     */
    public String checkOut ( Book b ) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].equals(b)) {
                if (copies[i] - checkedOut[i] == 0) {
                    return "All out of copies.";
                }
                checkedOut[i]++;
                return "Checked out!";
            }
            
        }
        return "Book not found.";
        
    }
    
    /**
     * Checks in a book to the library if possible.
     * @param b Book to check in.
     * @return String denoting success or failure.
     */
    public String checkIn ( Book b ) {
        for (int i = 0; i < numBooks; i++) {
            if (books[i].equals(b)) {
                if (checkedOut[i] != 0) {
                    checkedOut[i]--;
                    return "Checked in!";
                }
                return "All of our copies are already checked in.";
            }
        }
        return "Book not found.";
    }
    
    /**
     * Get string representation of entire library collection and status.
     * @return String representation of library.
     */
    public String toString() {
        String library = "";
        for (int i = 0; i< numBooks; i++) {
            library = library + i + ". " + books[i] + " : " +
                    (copies[i] - checkedOut[i]) + "/" + copies[i] + "\n";
        }
        library = library + "\n" + getStatus();
        return library;
    }
    
    /**
     * Get number of unique books that exist for a given author.
     * @param a The author to check.
     * @return Number of books by the author.
     */
    public int numBooksByAuthor( Author a ) {
        int sameAuth = 0;
        for (Book book : books) {
            if (book == null) {
                break;
            }
            if (book.getAuthor().hasSameName(a)) {
                sameAuth++;
            }
        }
        return sameAuth;
    }
    
    /**
     * Returns a String that lists the unique books which exist for a
     * given author, in standard book format, with a newline after
     * each.  If no books are found for the author, returns string
     * that says so.
     *
     * @param a The author in question.
     * @return String listing books by the author.
     */
    public String listBooksByAuthor( Author a ) {
        String sameBook = "";
        for (Book book : books) {
            if (book == null) {
                break;
            }
            if (book.getAuthor().hasSameName(a)) {
                sameBook += book + "\n";
            }
        }
        if (sameBook.equals("")) {
            sameBook = "No books by " + a + ".";
        }
        return sameBook;
    }
    
    /**
     * Returns string that lists the unique books with contain the
     * given string within their titles, without regard for case, with
     * a newline after each.  If no books are found containing the
     * string, returns string that says so.
     * @param s The string to look for in the titles.
     * @return String listing books that contain given string in titles.
     */
    public String listBooksByTitle( String s ) {
        String bookTitle = "";
        for (Book book : books) {
            if (book == null) {
                break;
            }
            if (book.getTitle().toLowerCase().contains(s.toLowerCase())) {
                bookTitle += book + "\n";
            }
        }
        if (bookTitle.equals("")) {
            bookTitle = "No books with \"" + s + "\" in the title.";
        }
        //why do i have to use the exact punctuation used in the lab write up
        //bc if i don't, my code doesn't pass all the tests
        //i do not like
        return bookTitle;
    }
    
    /**
     * Deletes book entirely from the library.
     * @param b Book to remove.
     * @return String denoting success or failure.
     */
    public String deleteBook( Book b ) {
        String deleteBook = "";
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                break;
            }
            if (books[i].equals(b)) {
                for (int j = i; j < numBooks; j++) {
                    books[j] = books[j + 1];
                    copies[j] = copies[j + 1];
                    checkedOut[j] = checkedOut[j + 1];
                }
                numBooks--;
                deleteBook = "Book removed.";
            }
            if (deleteBook.equals("")) {
                deleteBook = "Book not found.";
            }
        }
        return deleteBook;
    }
    
}