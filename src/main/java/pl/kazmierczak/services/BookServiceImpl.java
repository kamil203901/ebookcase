package pl.kazmierczak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kazmierczak.commands.BookForm;
import pl.kazmierczak.converters.BookFormToBook;
import pl.kazmierczak.domain.Book;
import pl.kazmierczak.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by kamil on 22.09.17.
 */
@Service
public class BookServiceImpl implements BookService {
    private BookRepository bookRepository;
    private BookFormToBook bookFormToBook;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, BookFormToBook bookFormToBook) {
        this.bookRepository = bookRepository;
        this.bookFormToBook = bookFormToBook;
    }

    @Override
    public List<Book> listAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add); // e -> books.add(e) == books::add --> JAVA 8
        return books;
    }

    @Override
    public List<Book> getByUserId(Integer userId) {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> {
            if (e.getAuthor().getId().equals(userId))
                books.add(e);
        });
        /*
         * for (Book e : bookRepository.findAll())
         *      if (e.getAuthor().getId().equals(userId))
         *          books.add(e);
         */
        return books;
    }

    @Override
    public List<Book> getByCategoryName(String categoryName) {
        List<Book> booksList = new ArrayList<>();
        bookRepository.findAll().forEach(
                e -> { if (e.getCategory().getName().equals(categoryName))
                    booksList.add(e); });
        return booksList;
    }

    @Override
    public void delete(Integer id) {
        bookRepository.delete(id);
    }

    @Override
    public void delete(String title) {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> { if (e.getTitle().equals(title)) books.add(e);  });
        bookRepository.delete(books);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public Book saveOrUpdateBookForm(BookForm bookForm) {
        Book savedBook = saveOrUpdate(bookFormToBook.convert(bookForm));

        System.out.println("Saved book id: " + savedBook.getId());

        return savedBook;
    }
}
