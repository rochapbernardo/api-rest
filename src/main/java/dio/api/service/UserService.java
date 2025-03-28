package dio.api.service;

import dio.api.domain.model.User;

//classe utilizada para nao expor as implementacoes, por meio do encapsulamento
public interface UserService {
    User findById(Long id);
    User create(User userToCreate);
    User update(Long id, User user);
    void delete(Long id);
}
