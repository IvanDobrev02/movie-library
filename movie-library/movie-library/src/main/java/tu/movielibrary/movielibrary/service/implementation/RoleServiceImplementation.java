package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.movielibrary.model.Role;
import tu.movielibrary.movielibrary.service.RoleService;
import tu.movielibrary.movielibrary.repositories.RoleRepo;

@Service
public class RoleServiceImplementation implements RoleService {

    @Autowired
    private RoleRepo roleRepo;


    @Override
    public void setUserNewRole() {

    }

    @Override
    public void setRole() {

    }

    @Override
    public void findUserByRole(Role role) {

    }



}
