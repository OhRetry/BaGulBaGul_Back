package com.BaGulBaGul.BaGulBaGul.domain.post.controller;


import com.BaGulBaGul.BaGulBaGul.domain.post.dto.GetPostCommentChildPageResponse;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.GetPostCommentPageResponse;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentChildModifyRequest;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentChildRegisterRequest;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentChildRegisterResponse;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentModifyRequest;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentRegisterRequest;
import com.BaGulBaGul.BaGulBaGul.domain.post.dto.PostCommentRegisterResponse;
import com.BaGulBaGul.BaGulBaGul.global.response.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostCommentController {
    ApiResponse<Page<GetPostCommentPageResponse>> getPostCommentPage(Long postId, Long requestUserId, Pageable pageable);
    ApiResponse<Page<GetPostCommentChildPageResponse>> getPostCommentChildPage(Long postCommentId, Long requestUserId, Pageable pageable);
    ApiResponse<PostCommentRegisterResponse> registerPostComment(Long postId, Long userId, PostCommentRegisterRequest postCommentRegisterRequest);
    ApiResponse<Object> modifyPostComment(Long postCommentId, Long userId, PostCommentModifyRequest postCommentModifyRequest);
    ApiResponse<Object> deletePostComment(Long postCommentId, Long userId);
    ApiResponse<PostCommentChildRegisterResponse> registerPostCommentChild(Long postCommentId, Long userId, PostCommentChildRegisterRequest postCommentChildRegisterRequest);
    ApiResponse<Object> modifyPostCommentChild(Long postCommentChildId, Long userId, PostCommentChildModifyRequest postCommentChildModifyRequest);
    ApiResponse<Object> deletePostCommentChild(Long postCommentChildId, Long userId);
    ApiResponse<Object> addLikeToComment(Long postCommentId, Long userId);
    ApiResponse<Object> deleteLikeToComment(Long postCommentId, Long userId);
    ApiResponse<Object> addLikeToCommentChild(Long postCommentChildId, Long userId);
    ApiResponse<Object> deleteLikeToCommentChild(Long postCommentChildId, Long userId);
}