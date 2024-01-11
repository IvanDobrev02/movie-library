package tu.movielibrary.movielibrary.service;

import org.springframework.web.multipart.MultipartFile;
import tu.movielibrary.movielibrary.exception.ResourceAlreadyExists;
import tu.movielibrary.movielibrary.exception.ResourceNotFoundException;
import tu.movielibrary.movielibrary.model.User;
import tu.movielibrary.movielibrary.security.UserDetails;

import java.util.List;

public interface AuthenticationService {

    void signupSubmit(User user) throws ResourceAlreadyExists;

    List<User> allUser() throws ResourceNotFoundException;

    void deleteUser(Long userId) throws ResourceNotFoundException;

    User profile(UserDetails principal);

    User setEditUserPage(Long userId) throws ResourceNotFoundException;

    void editUserSubmit(Long userId, User userDetails);

    void saveUpdatedProfilePicture(Long userId, MultipartFile file) throws ResourceNotFoundException;

}
