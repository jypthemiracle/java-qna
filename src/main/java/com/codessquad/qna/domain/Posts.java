package com.codessquad.qna.domain;

import com.codessquad.qna.web.HttpSessionUtils;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.servlet.http.HttpSession;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor //왜 이걸 붙여야 하는 지도 생각해보자.
public class Posts extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long Id;


  @Column(columnDefinition = "TEXT", nullable = false)
  private String author;
  private String title;
  private String content;

  @Builder
  public Posts(String title, String content, HttpSession httpSession) {
    Users sessionUser = HttpSessionUtils.getUserFromSession(httpSession);
    assert sessionUser != null;
    this.author = sessionUser.getUserId();
    this.title = title;
    this.content = content;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }

  @Override
  public String toString() {
    return "Posts{" +
        "Id=" + Id +
        ", author='" + author + '\'' +
        ", title='" + title + '\'' +
        ", content='" + content + '\'' +
        '}';
  }
}