package com.codessquad.qna;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Question {
    private String writer;
    private String title;
    private String contents;
    private LocalDateTime createdDateTime;
    private int questionId;

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public void setCreatedDatetime(LocalDateTime createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public int getQuestionId() {
        return questionId;
    }

    public String getCreatedDateTime2String() {
        return toStringDateTime(createdDateTime);
    }

    private String toStringDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
