package config;

import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by king on 2017/8/15.
 */
public class TestMockMvc  {
    private MockMvc mockMvc;

    public TestMockMvc(Object... controllers){
        mockMvc = standaloneSetup(controllers)
                .setViewResolvers(new TestViewResolver()).build();
    }

    public MockMvc getMockMvc() {
        return mockMvc;
    }
}
