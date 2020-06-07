package repositories.interfaces;

import domain.LoginData;
import domain.User;

public interface IUserRepository extends IEntityRepository<User> {
    User getUserByID(int id);

    User getUserByLogin(LoginData loginData);

    User getUserByUsername(String issuer);
}
