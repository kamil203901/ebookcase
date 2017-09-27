package pl.kazmierczak.services;

import pl.kazmierczak.commands.BookForm;
import pl.kazmierczak.domain.Book;

import java.util.List;

/**
 * Created by kamil on 22.09.17.
 */
public interface BookService {
    List<Book> listAll();
    List<Book> getByAuthorId(Integer authorId);
    List<Book> getByCategoryName(String categoryName);
    void delete(Integer id);
    void delete(String title);
    Book saveOrUpdate(Book book);
}
