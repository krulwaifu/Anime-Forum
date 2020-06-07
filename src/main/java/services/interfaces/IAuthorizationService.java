package services.interfaces;

import domain.AccessToken;
import domain.LoginData;
import domain.User;

public interface IAuthorizationService {
    AccessToken authenticate(LoginData loginData) throws Exception;

    User getUserByUsername(String issuer);
}
