package nus.project.FlowerMarket.repository;

import java.sql.ResultSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import nus.project.FlowerMarket.model.Post;
import static nus.project.FlowerMarket.repository.Queries.*;

@Repository
public class PostRepository {

    @Autowired
    private JdbcTemplate temp;

    public Optional<Post> getPostById(Integer postId) {
        return temp.query (
            SQL_GET_POST_BY_POST_ID,
            (ResultSet rs) -> {
                if(!rs.next())
                    return Optional.empty();

                final Post post = Post.populate(rs);
                return Optional.of(post);
            } , postId);
    }

    //insert post data to the flower post table
    public Integer insertPost(Post post) {
       Integer updCount =  temp.update(SQL_INSERT_POST, 
                                post.getImage(),
                                post.getComment(),
                                post.getPoster(),
                                post.getImageType());
            return updCount;

    }
    
}
