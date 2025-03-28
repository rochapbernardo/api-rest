package dio.api.service.impl;

import dio.api.domain.model.User;
import dio.api.domain.repository.UserRepository;
import dio.api.service.UserService;
import dio.api.service.exception.BusinessException;
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

    @Override
    public User update(Long id, User userToUpdate) {
        User dbUser = this.findById(id);
        if(!dbUser.getId().equals(userToUpdate.getId())){
            throw new BusinessException("Update IDs must be the same.");
        }
        dbUser.setName(userToUpdate.getName());
        dbUser.setAccount(userToUpdate.getAccount());
        dbUser.setCard(userToUpdate.getCard());
        dbUser.setFeatures(userToUpdate.getFeatures());
        dbUser.setNews(userToUpdate.getNews());

        return this.userRepository.save(dbUser);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
