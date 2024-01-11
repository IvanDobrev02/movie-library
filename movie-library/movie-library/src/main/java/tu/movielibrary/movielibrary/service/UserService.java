package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.model.User;

public interface UserService {

    public void saveNewUser(User user);

    public void deleteUser(Long id);

}
