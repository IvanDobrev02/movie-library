package tu.movielibrary.movielibrary.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.model.User;
import tu.movielibrary.movielibrary.repositories.UserRepo;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if( user == null ) throw new UsernameNotFoundException("Username Not Found");
        return new UserDetails(user);
    }
}
