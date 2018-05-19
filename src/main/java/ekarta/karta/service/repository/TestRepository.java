package ekarta.karta.service.repository;

import ekarta.karta.entity.Test;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestRepository extends CrudRepository<Test,Integer> {
}
