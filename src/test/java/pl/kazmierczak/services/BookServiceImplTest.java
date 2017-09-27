package pl.kazmierczak.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import pl.kazmierczak.domain.Author;
import pl.kazmierczak.domain.Book;
import pl.kazmierczak.domain.Category;
import pl.kazmierczak.repositories.BookRepository;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.AdditionalAnswers.returnsFirstArg;

public class BookServiceImplTest {
    private BookService bookService;
    private BookRepository bookRepositoryMock;

    private List<Book> bookList;
    private Book book;

    @Before
    public void setUp() {
        bookRepositoryMock = Mockito.mock(BookRepository.class);
        bookService = new BookServiceImpl(bookRepositoryMock);

        bookList = new ArrayList<>();
        book = new Book(3, "a", new Author(), 360, new Category("horror"));

    }

    @Test
    public void listAll() throws Exception {
        Book bookCopy = new Book(this.book);
        bookList.add(book);
        bookList.add(bookCopy);

        Mockito.when(bookRepositoryMock.findAll()).thenReturn(bookList);

        List<Book> testedList = new ArrayList<>(bookService.listAll());
        assertNotEquals(1, testedList.size());
        assertEquals(2, testedList.size());
    }

    @Test
    public void getByAuthorId() throws Exception {
    }

    @Test
    public void getByCategoryName() throws Exception {
    }

    @Test
    public void delete() throws Exception {
    }

    @Test
    public void delete1() throws Exception {
    }

    @Test
    public void saveOrUpdate() throws Exception {
        bookList.add(book);

        Mockito.doAnswer(returnsFirstArg()).when(bookRepositoryMock).save(Matchers.any(Book.class));

        Book book1 = bookService.saveOrUpdate(book);
        assertEquals("a", book1.getTitle());
        assertEquals(Integer.valueOf(3), book1.getId());
        assertNotEquals(100, book1.getPages());
    }

    @Test
    public void saveOrUpdateBookForm() throws Exception {
    }

}