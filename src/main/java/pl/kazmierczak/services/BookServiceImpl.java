package pl.kazmierczak.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kazmierczak.commands.BookForm;
import pl.kazmierczak.converters.BookFormToBook;
import pl.kazmierczak.domain.Book;
import pl.kazmierczak.repositories.BookRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Created by kamil on 22.09.17.
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> listAll() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add); // e -> books.add(e) == books::add --> JAVA 8
        return books;
    }

    @Override
    public List<Book> getByAuthorId(Integer authorId) {
        List<Book> books = this.listAll().stream()
                .filter(e -> e.getAuthor().getId().equals(authorId))
                .collect(Collectors.toCollection(ArrayList::new));




        /*bookRepository.findAll().forEach(e -> {
            if (e.getAuthor().getId().equals(authorId))
                books.add(e);
        });*/

        /*
         * for (Book e : bookRepository.findAll())
         *      if (e.getAuthor().getId().equals(userId))
         *          books.add(e);
         */
        return books;
    }

    @Override
    public List<Book> getByCategoryName(String categoryName) {
        List<Book> booksList = new ArrayList<>(bookRepository.findBooksByCategory_Name(categoryName));
        return booksList;
    }

    @Override
    public void delete(Integer id) {
        bookRepository.delete(id);
    }

    @Override
    public void delete(String title) {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(e -> {
            if (e.getTitle().equals(title))
                books.add(e);
        });
        bookRepository.delete(books);
    }

    @Override
    public Book saveOrUpdate(Book book) {
        return bookRepository.save(book);
    }

}
