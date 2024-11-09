package edu.cfd.e_learningPlatform.service;

import edu.cfd.e_learningPlatform.dto.request.CommentRequest;
import edu.cfd.e_learningPlatform.dto.response.CommentVideoResponse;

import java.util.List;

public interface CommentService {
    List<CommentVideoResponse> getCommentVideo(Long idVideo);
    CommentVideoResponse addComment(CommentRequest commentRequest);
    CommentVideoResponse updateComment(CommentRequest commentRequest);
    Long deleteComment(Long idComment);
}