package ekarta.karta.service.repository;

import ekarta.karta.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findRoleByRoleName(String s);
}
