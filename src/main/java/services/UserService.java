package services;

import domain.User;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import services.interfaces.IUserService;

public class UserService implements IUserService {
    private IUserRepository userRepo = new UserRepository();

    @Override
    public User getUserByID(int id) {
        return userRepo.getUserByID(id);
    }
}
