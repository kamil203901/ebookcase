package pl.kazmierczak.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.kazmierczak.domain.Category;

/**
 * Created by kamil on 22.09.17.
 */
public interface CategoryRepository extends CrudRepository<Category, Integer> {
}
