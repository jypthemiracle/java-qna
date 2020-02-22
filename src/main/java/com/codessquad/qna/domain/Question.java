package com.codessquad.qna.domain;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Question {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long questionId;

  @Column(nullable = false, length = 20)
  private String writer;
  private String title;
  private String contents;
  private LocalDateTime localDateTime;
  private int index;

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  public String getWriter() {
    return writer;
  }

  public void setWriter(String writer) {
    this.writer = writer;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContents() {
    return contents;
  }

  public void setContents(String contents) {
    this.contents = contents;
  }

  public String getTime() {
    return DateTimeFormatter.ofPattern("YYYY-MM-DD HH:MM:SS").format(localDateTime);
  }

  public long getQuestionId() {
    return getQuestionId();
  }

  @Override
  public String toString() {
    return "Question" + " title " + " questionId " + questionId + title + " writer " + writer
        + " contents " + contents + " time " + localDateTime;
  }
}