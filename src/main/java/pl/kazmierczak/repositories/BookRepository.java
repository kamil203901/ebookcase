package pl.kazmierczak.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import pl.kazmierczak.domain.Book;

/**
 * Created by kamil on 22.09.17.
 */
public interface BookRepository extends CrudRepository<Book, Integer> {
}
