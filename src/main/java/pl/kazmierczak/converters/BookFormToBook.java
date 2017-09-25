package pl.kazmierczak.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import pl.kazmierczak.commands.BookForm;
import pl.kazmierczak.domain.Author;
import pl.kazmierczak.domain.Book;
import pl.kazmierczak.domain.Category;

/**
 * Created by kamil on 22.09.17.
 */
@Component
public class BookFormToBook implements Converter<BookForm, Book> {
    @Override
    public Book convert(BookForm bookForm) {
        Book book = new Book();
        if (bookForm.getId() != null && !StringUtils.isEmpty(bookForm.getId())) {
            book.setId(new Integer(bookForm.getId()));
        }
        book.setAuthor(new Author(bookForm.getAuthorName(), bookForm.getAuthorSurname()));
        book.setCategory(new Category(bookForm.getCategoryName()));
        book.setPages(bookForm.getPages());
        book.setTitle(bookForm.getTitle());
        return book;
    }
}
