public class Book {
    private String title;
    private Author author;
    private int year;
    private String isbn;
    
    public Book() {
        this.title = AuthorBookConstants.UNKNOWN_TITLE;
        this.year = AuthorBookConstants.UNKNOWN_YEAR;
        this.author = AuthorBookConstants.UNKNOWN_AUTHOR;
        this.isbn = AuthorBookConstants.UNKNOWN_ISBN;
    }
    
    public Book(String title) {
        this();
        this.title = title;
    }
    
    public Book(String title, Author author) {
        this(title);
        this.author = author;
    }
    
    public void setTitle(String title) {
    if (title.equals("")){
        System.out.println("A book needs a title.");
    }
    else {
        this.title = title;
    }
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    
    public Author getAuthor() {
        return author;
    }
    
    public void setPublicationYear(int year) {
        if (year > -2000 && year < 2024 && year != 0) {
            try {
                this.year = year;
            }
            catch (Exception e) {
                System.out.println("Please enter a valid year of " +
                        "publication.");
            }
        }
    }
    
    public int getPublicationYear() {
        return year;
    }
    
    public void setIsbn(String isbn) {
        if (isbn.length() >= 10 && isbn.length() <= 13) {
            try {
                this.isbn = isbn;
            }
            catch (Exception e) {
                System.out.println("This is not a valid ISBN");
            }
        }
       
    }
    
    public String getIsbn() {
        return isbn;
    }
    
    public boolean sameAuthor(Book other) {
        return this.author.hasSameName(other.author);
    }
    
    public boolean equals(Book other) {
        return this.getIsbn().equals(other.getIsbn());
    }
    
    public String toString() {
        String info = AuthorBookConstants.UNKNOWN_TITLE;
        if (author != AuthorBookConstants.UNKNOWN_AUTHOR
        && year != AuthorBookConstants.UNKNOWN_YEAR) {
            info = title + " (" + year + "). " + author.toString() + ".";
        }
        else if (author != AuthorBookConstants.UNKNOWN_AUTHOR) {
            info = title + ". " + author.toString() + ".";
        }
        else if (title != AuthorBookConstants.UNKNOWN_TITLE) {
            info = title + ".";
        }
        return info;
    }
    
   
}
