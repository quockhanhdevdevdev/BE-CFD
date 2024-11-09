package edu.cfd.e_learningPlatform.repository;

import edu.cfd.e_learningPlatform.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentReponsitory extends JpaRepository<Comment, Long>{
    @Query(value = "select " +
            "c.id as id, " +
            "u.fullname as fullName, " +
            "u.id as idUserComment, " +
            "u.avatar_url as profilePicture, " +
            "c.comment_text as commentText, " +
            "userCommentParent.fullname as nameUserReply, " +
            "c.comment_id as parentId " +
            "from comments c " +
            "inner join users u on c.user_id = u.id " +
            "left join comments commentParent on c.comment_id = commentParent.id " +
            "left join users userCommentParent on commentParent.user_id = userCommentParent.id " +
            "where c.video_id = :id", nativeQuery = true)
    List<Object[]> getCommentVideo(Long id);
}