package services.interfaces;

import domain.Posts;

public interface IPostService {

    Posts getPostByID(int post_id);
}
