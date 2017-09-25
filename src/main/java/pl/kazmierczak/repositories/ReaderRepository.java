package pl.kazmierczak.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kazmierczak.domain.Reader;

/**
 * Created by kamil on 22.09.17.
 */
public interface ReaderRepository extends CrudRepository<Reader, Integer> {
}
