package controller;

import com.king.config.RootConfig;
import com.king.config.WebConfig;
import com.king.controller.PlanController;
import com.king.model.Plan;
import com.king.model.User;
import com.king.service.PlanService;
import config.TestMockMvc;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by king on 2017/7/25.
 */
//@RunWith(SpringRunner.class)
//@WebAppConfiguration(value = "src/main/web")
//@ActiveProfiles("test")
//@ContextHierarchy({
//        @ContextConfiguration(name = "parent", classes = RootConfig.class),
//        @ContextConfiguration(name = "child", classes = WebConfig.class),
//})
public class PlanControllerTest {

//    @Autowired
//    private WebApplicationContext wac;
    private MockMvc mockMvc;
    private PlanService mockPlanService=
            mock(PlanService.class);



    @Before
    public void setUp() {
//        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

        mockMvc=new TestMockMvc(new PlanController(mockPlanService)).getMockMvc();

    }

    @Test
    public void insertPlan() throws Exception {

    }

    @Test
    public void insertPlan1() throws Exception {
        mockPlanService.getPlanAndResource("id");
        verify(mockPlanService).getPlanAndResource("id");
    }


    @Test
    public void getPlan() throws Exception {


        when(mockPlanService.getPlans()).thenReturn(new ArrayList<>());
        mockMvc.perform(get("/"))
                .andExpect(view().name("index"))
                .andExpect(model().attribute("plans", mockPlanService.getPlans()));
    }

    @Test
    public void addPlan() throws Exception {
        mockMvc.perform(get("/create"));
    }



}