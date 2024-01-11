package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tu.movielibrary.movielibrary.repositories.RoleRepo;
import tu.movielibrary.movielibrary.repositories.UserRepo;
import tu.movielibrary.movielibrary.exception.ResourceAlreadyExists;
import tu.movielibrary.movielibrary.exception.ResourceNotFoundException;
import tu.movielibrary.movielibrary.model.Role;
import tu.movielibrary.movielibrary.model.User;
import tu.movielibrary.movielibrary.security.UserDetails;
import tu.movielibrary.movielibrary.service.AuthenticationService;
import tu.movielibrary.movielibrary.utility.FileUpload;
import tu.movielibrary.movielibrary.utility.ImageType;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
public class AuthServiceImplementation implements AuthenticationService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public void signupSubmit(User user) throws ResourceAlreadyExists {

        if (userRepo.findByUsername(user.getUsername()) != null) throw new ResourceAlreadyExists("Username Already exists");

        // defaultní role = user
        Role role = roleRepo.findByRoleName("USER");
        Set<Role> roles = new HashSet<Role>();
        roles.add(role);
        user.setRoles(roles);
        user.setProfilePicPath("/images/profile/default.png");

        user.setEnabled(true);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword())); // password encrypted
        userRepo.save(user);
    }

    @Override
    public List<User> allUser() throws ResourceNotFoundException {
        List<User> users = userRepo.findAllUser();
        if (users.isEmpty())
            throw new ResourceNotFoundException("No User found");
        return users;
    }

    @Override
    public void deleteUser(Long userId) throws ResourceNotFoundException {
        userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        userRepo.deleteById(userId);
    }

    @Override
    public User profile(UserDetails principal) {
        User user = userRepo.findById(principal.getId()).orElse(new User());
        return user;
    }

    @Override
    public User setEditUserPage(Long userId) throws ResourceNotFoundException {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return user;
    }

    @Override
    public void editUserSubmit(Long userId, User userDetails) {

        User user = userRepo.findById(userId).orElse(new User());
        user.setUsername(userDetails.getUsername());
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        user.setRoles(userDetails.getRoles());
        userRepo.save(user);
    }

    @Override
    public void saveUpdatedProfilePicture(Long userId, MultipartFile file) throws ResourceNotFoundException {
        User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found"));
        String path = FileUpload.saveImage(ImageType.USER_PROFILE, user.getUsername(), file);
        user.setProfilePicPath(path);
        userRepo.save(user);
    }
}
