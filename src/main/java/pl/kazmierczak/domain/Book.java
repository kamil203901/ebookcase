package pl.kazmierczak.domain;

import javax.persistence.*;

/**
 * Created by kamil on 22.09.17.
 */
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id", foreignKey = @ForeignKey(name = "AUTHOR_ID_FK"))
    private Author author;
    private int pages;
    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "CATEGORY_ID_FK"))
    private Category category;

    public Book() {
    }

    public Book(Integer id, String title, Author author, int pages, Category category) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.category = category;
    }

    public Book(Book bookToCopy) {
        this(   bookToCopy.getId(),
                bookToCopy.getTitle(),
                bookToCopy.getAuthor(),
                bookToCopy.getPages(),
                bookToCopy.getCategory()
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
