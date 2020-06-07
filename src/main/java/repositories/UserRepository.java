package repositories;

import domain.LoginData;
import domain.User;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IUserRepository;

import javax.ws.rs.BadRequestException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final IDBRepository dbRepo = new PostgresRepository();

    @Override
    public void add(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void remove(User entity) {

    }

    @Override
    public List<User> query(String sql) {
        return null;
    }

    @Override
    public User queryOne(String sql) {
        try {
            Statement stmt = dbRepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
                return user;
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }
        return null;
    }

    @Override
    public User getUserByID(int id) {
        String sql = "SELECT * FROM users WHERE id = "+ id + "LIMIT 1";
        return queryOne(sql);
    }

    @Override
    public User getUserByLogin(LoginData loginData) {
        String sql = "SELECT * FROM users WHERE username=? AND password=? LIMIT 1";
        try {
            PreparedStatement stmt =dbRepo.getConnection().prepareStatement(sql);
            stmt.setString(1,loginData.getUsername());
            stmt.setString(2,loginData.getPassword());
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            return user;
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        try {
            String sql = "SELECT * FROM users WHERE username = ? LIMIT 1";
            PreparedStatement stmt = dbRepo.getConnection().prepareStatement(sql);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getDate("birthday"),
                        rs.getString("role")
                );
            }
        } catch (SQLException ex) {
            throw new BadRequestException("Cannot run SQL statement: " + ex.getMessage());
        }
        return null;


    }

}
