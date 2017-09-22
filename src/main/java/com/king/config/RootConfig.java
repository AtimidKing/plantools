package com.king.config;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.*;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * Created by king on 2017/7/25.
 */
@Configuration
@ActiveProfiles("production")
@ComponentScan(basePackages = {"com.king"},
        excludeFilters = {@ComponentScan.Filter
                (type = FilterType.ANNOTATION, value = EnableWebMvc.class)})
public class RootConfig {




    @Bean
    @Profile("production")
    public DataSource dataSource(){
        MysqlDataSource dataSource=new MysqlDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/xiao_yang");
        dataSource.setUser("root");
        dataSource.setPassword("654321");
        return dataSource;

    }
    @Bean
    @Profile("test")
    public DataSource standaloneDataSource(){
        return new EmbeddedDatabaseBuilder()
                .generateUniqueName(true)
                .setType(EmbeddedDatabaseType.H2)
                .setScriptEncoding("UTF-8")
                .addScript("classpath:sql/schema.sql")
                .addScript("classpath:sql/test-data.sql")
                .build();
    }

    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource) throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean =
                new SqlSessionFactoryBean();
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath*:mapper/*.xml"));
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean;
    }
    @Bean
    MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer mapperScannerConfigurer=
                new MapperScannerConfigurer();
        mapperScannerConfigurer.setBasePackage("com.king.mapper");
        return mapperScannerConfigurer;
    }




}
