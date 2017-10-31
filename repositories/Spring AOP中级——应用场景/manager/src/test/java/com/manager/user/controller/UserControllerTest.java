package com.manager.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.manager.user.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * UserController单元测试
 * Created by Kevin on 2017/10/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath*:applicationContext.xml", "classpath*:spring-servlet.xml"})
@WebAppConfiguration
public class UserControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mvc;

    @Before
    public void initMockHttp() {
        this.mvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void testQueryUsers() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testAddUser() throws Exception {
        User user = new User();
        user.setName("kevin");
        user.setAge(23);
        mvc.perform(MockMvcRequestBuilders.post("/users")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("kevin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(23));
    }

    @Test
    public void testQueryUserById() throws Exception {
        User user = new User();
        user.setId(8);
        mvc.perform(MockMvcRequestBuilders.get("/users/" + user.getId()))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("kevin"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.age").value(23));

    }

    @Test
    public void testUpdateUserById() throws Exception {
        User user = new User();
        user.setId(9);
        user.setName("tony");
        user.setAge(99);
        mvc.perform(MockMvcRequestBuilders.put("/users/" + user.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(user)))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDeleteUserById() throws Exception {
        long id = 10;
        mvc.perform(MockMvcRequestBuilders.delete("/users/" + id))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}