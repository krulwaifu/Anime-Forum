package repositories.interfaces;

import domain.Posts;

public interface IPostRepository extends IEntityRepository<Posts> {
    Posts getPostByID(int post_id);
}
