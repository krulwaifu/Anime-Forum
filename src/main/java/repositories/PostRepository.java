package repositories;

import domain.Posts;
import repositories.interfaces.IDBRepository;
import repositories.interfaces.IPostRepository;

import javax.ws.rs.BadRequestException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class PostRepository implements IPostRepository {
    private final IDBRepository dbRepo = new PostgresRepository();

    @Override
    public void add(Posts entity) {

    }

    @Override
    public void update(Posts entity) {

    }

    @Override
    public void remove(Posts entity) {

    }

    @Override
    public List<Posts> query(String sql) {
        return null;
    }

    @Override
    public Posts getPostByID(int post_id) {
        String sql = "SELECT * FROM posts WHERE post_id = "+ post_id + "LIMIT 1";
        return queryOne(sql);
    }

    @Override
    public Posts queryOne(String sql) {
        try {
            Statement stmt = dbRepo.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if(rs.next()){
                Posts post = new Posts(
                       rs.getInt("post_id"),
                       rs.getString("title"),
                       rs.getString("content"),
                       rs.getDate("pub_date"),
                       rs.getInt("author_id")
                );
                return post;
            }
        } catch (SQLException e) {
            throw new BadRequestException();
        }
        return null;
    }

}
