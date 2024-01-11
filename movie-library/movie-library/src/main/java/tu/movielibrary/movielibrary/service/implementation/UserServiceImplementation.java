package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.dao.UserDao;
import tu.movielibrary.model.User;
import tu.movielibrary.service.UserService;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveNewUser(User user) {
        userDao.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteById(id);
    }

    public User findByUsername(String name){
        return userDao.findByUsername(name);
    }

    public User findById(long id){
        return userDao.findById(id);
    }

    public User findByEmail(String email){
        return userDao.findByEmail(email);
    }

    public boolean existsByUserID(long userID){
        return userDao.existsById(userID);
    }

    public List<User>findAll(){
        return userDao.findAllUser();
    }

}
