package services;

import domain.AccessToken;
import domain.LoginData;
import domain.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import repositories.UserRepository;
import repositories.interfaces.IUserRepository;
import services.interfaces.IAuthorizationService;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

public class AuthorizationService implements IAuthorizationService {
    private final IUserRepository userRepo = new UserRepository();

    @Override
    public AccessToken authenticate(LoginData loginData) throws Exception {
       User user = signIn(loginData);
       AccessToken token = new AccessToken(getToken(user));
       return token;
    }

    @Override
    public User getUserByUsername(String issuer) {
        return userRepo.getUserByUsername(issuer);
    }

    private User signIn(LoginData loginData) throws Exception {
        User user = userRepo.getUserByLogin(loginData);
        if(user == null){
            throw new Exception("User does not exist");
        }
        return user;
    }

    private String getToken (User user){
        Instant now = Instant.now();
        String secretWord = "TheStrongestSecretKeyICanThinkOf";
        return Jwts.builder()
                .setIssuer(user.getUsername())
                .setIssuedAt(Date.from(now))
                .claim("1d20", new Random().nextInt(20) + 1)
                .setExpiration(Date.from(now.plus(10, ChronoUnit.MINUTES)))
                .signWith(Keys.hmacShaKeyFor(secretWord.getBytes()))
                .compact();
    }
}
