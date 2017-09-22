package controller;

import com.king.controller.HelloController;
import com.king.model.User;
import config.TestMockMvc;
import config.TestViewResolver;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by king on 2017/8/14.
 */

public class HelloControllerTest {

    private MockMvc mockMvc;
    @Before
    public void setUp() {
        mockMvc =new TestMockMvc(new HelloController()).getMockMvc();
    }

    @Test
    public void getHello() throws Exception {


        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            users.add(new User("杨", 22));
        }
        mockMvc.perform(get("/hello"))
                .andExpect(view().name("hello"))
                .andExpect(model().attributeExists("users"))
                .andExpect(model().size(1));
    }


}