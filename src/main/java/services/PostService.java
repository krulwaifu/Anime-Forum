package services;

import domain.Posts;
import repositories.PostRepository;
import repositories.interfaces.IPostRepository;
import services.interfaces.IPostService;

public class PostService implements IPostService {
    private IPostRepository postRepo = new PostRepository();
    @Override
    public Posts getPostByID(int post_id) {
        return postRepo.getPostByID(post_id);
    }
}
