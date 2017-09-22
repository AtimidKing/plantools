package mapper;

import com.king.config.RootConfig;
import com.king.config.WebConfig;
import com.king.mapper.PlanMapper;
import com.king.model.Plan;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by king on 2017/7/25.
 */
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(classes = RootConfig.class)
public class PlanMapperTest {
    @Autowired
    private PlanMapper planMapper;

    @Test
    public void getPlans() throws Exception {
        assertTrue(planMapper.getPlans().size()>5);
    }

    @Test
    public void findById() throws Exception {
//        (194456, '学习Javascript',
//                '这是前端技术的中要组成部分，是一个全站工程师必须学会的东西。', '2017-8-12', 1),
        BigInteger id=new BigInteger("194456");
        assertEquals(planMapper.findById(id).getId().toString(),id.toString());
    }

    @Test
    public void updateById() throws Exception {
        BigInteger id=new BigInteger("194456");
        System.out.println(planMapper.findById(id));
        System.out.println(LocalDate.now());
        Plan plan=new Plan(id,"Javascript","前端技术的中要组成部分", LocalDate.now(), 1);
        assertEquals(1,planMapper.updateById(plan));
        assertEquals(plan.getTitle(), planMapper.findById(id).getTitle());
    }

    @Test
    public void updateStatus() throws Exception {
        BigInteger id=new BigInteger("194457");
        assertEquals(1,planMapper.updateStatus(id,2));
        assertEquals(2,planMapper.findById(id).getStatus());
    }

    @Test
    public void deleteById() throws Exception {
        BigInteger id=new BigInteger("194462");
        assertEquals(1, planMapper.deleteById(id));
        assertNull(planMapper.findById(id));
    }

    @Test
    public void insert() throws Exception {
        Plan plan=new Plan();
        plan.setTitle("Javascript");
        plan.setDetail("前端技术的中要组成部分");
        plan.setDate(LocalDate.now());
        plan.setStatus(0);

        assertEquals(1,planMapper.insert(plan));
        assertNotNull(planMapper.findById(plan.getId()));

    }
}