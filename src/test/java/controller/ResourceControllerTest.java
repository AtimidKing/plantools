package controller;

import com.king.controller.ResourceController;
import config.TestConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by king on 2017/8/15.
 */
public class ResourceControllerTest {
    private MockMvc mockMvc;
    @Before
    public void setUp() throws Exception {

        mockMvc=standaloneSetup(new ResourceController())
                .setViewResolvers().build();
    }

    @Test
    public void showResource() throws Exception {
        mockMvc.perform(get("/resource/list").param("id","7777777"))
                .andExpect(view().name("showResource"));
    }

    @Test
    public void downloadResource() throws Exception {
    }

}