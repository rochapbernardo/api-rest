package dio.api.service.impl;

import dio.api.domain.model.User;
import dio.api.domain.repository.UserRepository;
import dio.api.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    //construtor que recebe userRepository, spring entende que para criar o UserServiceImpl
    // precisa injetar o UserRepository
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //busca pelo id e , pelo optional do java, utiliza tratamento de excecoes
    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())){
            throw new IllegalArgumentException("This Account number already exists.");
        }
        return userRepository.save(userToCreate);
    }
}
