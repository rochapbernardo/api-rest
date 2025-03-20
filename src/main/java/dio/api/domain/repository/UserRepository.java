package dio.api.domain.repository;

import dio.api.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//abstrai o acesso aos dados
@Repository
//1º a entidade, 2º tipo do id
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
