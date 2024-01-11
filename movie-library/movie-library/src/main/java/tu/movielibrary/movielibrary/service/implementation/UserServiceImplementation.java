package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.model.User;
import tu.movielibrary.movielibrary.repositories.UserRepo;
import tu.movielibrary.movielibrary.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void saveNewUser(User user) {
        userRepo.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);
    }

    public User findByUsername(String name){
        return userRepo.findByUsername(name);
    }

    public User findById(long id){
        return userRepo.findById(id);
    }

    public User findByEmail(String email){
        return userRepo.findByEmail(email);
    }

    public boolean existsByUserID(long userID){
        return userRepo.existsById(userID);
    }

    public List<User>findAll(){
        return userRepo.findAllUser();
    }

}
