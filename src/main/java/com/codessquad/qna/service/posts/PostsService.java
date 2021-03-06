package com.codessquad.qna.service.posts;

import com.codessquad.qna.controller.posts.PostsRepository;
import com.codessquad.qna.domain.Posts;
import com.codessquad.qna.exception.NoSuchPostException;
import com.codessquad.qna.utils.ErrorMessageUtil;
import com.codessquad.qna.utils.PathUtil;
import com.codessquad.qna.web.dto.posts.PostsDeleteRequestDto;
import com.codessquad.qna.web.dto.posts.PostsListResponseDto;
import com.codessquad.qna.web.dto.posts.PostsResponseDto;
import com.codessquad.qna.web.dto.posts.PostsSaveRequestDto;
import com.codessquad.qna.web.dto.posts.PostsUpdateRequestDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostsService {

  private final PostsRepository postsRepository;

  public PostsService(PostsRepository postsRepository) {
    this.postsRepository = postsRepository;
  }

  @Transactional(readOnly = true)
  public List<PostsListResponseDto> findAllDesc() {
    return postsRepository.findAllDesc().stream()
        .map(posts -> new PostsListResponseDto(posts))
        .collect(Collectors.toList());
  }

  @Transactional
  public Posts save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity());
  }

  @Transactional
  public Posts update(Long id, PostsUpdateRequestDto requestDto) {
    Posts entity = checkValidity(id);
    return entity.update(requestDto.getTitle(), requestDto.getContent());
  }

  @Transactional
  public Posts delete(Long id, PostsDeleteRequestDto requestDto) {
    Posts entity = checkValidity(id);
    return entity.deletePost(requestDto.deleteStatusQuo());
  }

  @Transactional(readOnly = true)
  public PostsResponseDto findById(Long id) {
    Posts entity = checkValidity(id);
    return new PostsResponseDto(entity);
  }

  private Posts checkValidity(Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(
        () -> new NoSuchPostException(PathUtil.NO_SUCH_POSTS_OR_ANSWERS,
            ErrorMessageUtil.QUESTION_NOTFOUND + id));
    if (entity.isDeleted()) {
      throw new NoSuchPostException(PathUtil.NO_SUCH_POSTS_OR_ANSWERS,
          ErrorMessageUtil.QUESTION_NOTFOUND);
    }
    return entity;
  }
}