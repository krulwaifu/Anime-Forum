package domain;

public class AccessToken {
    private String token;

    public AccessToken(String token) {
        setToken(token);
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        token = token;
    }
}
