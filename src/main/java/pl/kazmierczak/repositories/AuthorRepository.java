package pl.kazmierczak.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kazmierczak.domain.Author;

/**
 * Created by kamil on 22.09.17.
 */
public interface AuthorRepository extends CrudRepository<Author, Integer> {
}
