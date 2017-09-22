package config;

import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by king on 2017/8/15.
 */
public class TestViewResolver extends InternalResourceViewResolver {

    public TestViewResolver() {
        this.setPrefix("/WEB-INF/templates/");
        this.setSuffix(".html");
        this.setExposeContextBeansAsAttributes(true);
    }
}
