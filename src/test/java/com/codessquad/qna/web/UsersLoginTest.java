package com.codessquad.qna.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.codessquad.qna.QnaApplication;
import com.codessquad.qna.controller.UsersAPIController;
import com.codessquad.qna.controller.UsersRepository;
import com.codessquad.qna.service.posts.PostsService;
import org.h2.engine.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest
public class UsersLoginTest {
  @Autowired
  private MockMvc mockMvc;
  private MockHttpSession httpSession;

  @Autowired
  private PostsService postsService;

  @Autowired
  private UsersAPIController usersAPIController;

  @Before
  public void setUp() throws Exception {
    mockMvc = MockMvcBuilders.standaloneSetup(usersAPIController).build();
  }

  @Test
  public void Users가_로그인된다() throws Exception {
    String userId = "javajigi";
    String password = "test";

    mockMvc.perform(post("/login").param("javajigi", "test"))
        .andExpect(status().isOk())
        .andReturn();
    Assert.assertNotNull(httpSession.getSessionContext());
  }
}
//https://wedul.site/131
//https://www.lesstif.com/pages/viewpage.action?pageId=14090472
//https://javafactory.tistory.com/1349