package tu.movielibrary.movielibrary.service;

import tu.movielibrary.movielibrary.model.Role;

public interface RoleService {

    public void setUserNewRole();

    public void setRole();

    public void findUserByRole(Role role);
}
