package tu.movielibrary.movielibrary.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tu.movielibrary.dao.RoleDao;
import tu.movielibrary.model.Role;
import tu.movielibrary.service.RoleService;

@Service
public class RoleServiceImplementation implements RoleService {

    //TODO
    @Autowired
    private RoleDao roleDao;


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
