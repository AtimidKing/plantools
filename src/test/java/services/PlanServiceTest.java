package services;

import com.king.mapper.PlanMapper;
import com.king.mapper.ResourceMapper;
import com.king.model.Plan;
import com.king.model.Resource;
import com.king.service.PlanService;
import com.king.service.impl.PlanServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import static jdk.nashorn.internal.runtime.UnwarrantedOptimismException.isValid;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.hamcrest.MockitoHamcrest.argThat;

/**
 * Created by king on 2017/8/16.
 */
public class PlanServiceTest {
    private PlanMapper mockPlanMapper;
    private ResourceMapper mockResourceMapper;
    private PlanService planService;

    @Before
    public void setUp() throws Exception {
        mockPlanMapper =mock(PlanMapper.class);
        mockResourceMapper = mock(ResourceMapper.class);
        planService=new PlanServiceImpl(mockPlanMapper, mockResourceMapper);
    }

    @Test
    public void getPlans() throws Exception {
        List<Plan> plans = new ArrayList<>();
        when(mockPlanMapper.getPlans()).thenReturn(plans);
        assertEquals(plans,planService.getPlans());
    }

    @Test
    public void getPlanAndResource() throws Exception {
        BigInteger bigInteger=new BigInteger("1");
        Plan plan=new Plan();
        List<Resource> resources=new ArrayList<>();
        //返回一个计划
        when(mockPlanMapper.findById(bigInteger))
                .thenReturn(plan);
        //返回计划的附加资源
        when(mockResourceMapper.findByPlanId(bigInteger))
                .thenReturn(resources);
        assertEquals(plan,planService.getPlanAndResource("1").getPlan());
        assertEquals(resources,planService.getPlanAndResource("1").getResources());
    }

    @Test
    public void save() throws Exception {
        Plan plan=new Plan();
        List<String> list = new ArrayList<>();
        list.add("1");
        when(mockPlanMapper.insert(plan)).thenReturn(1);
        when(mockResourceMapper.insertResource(any())).thenReturn(1);
        assertEquals(2,planService.save(plan,list));

    }

    @Test
    public void modify() throws Exception {
        Plan plan = new Plan();
        List<String> list = new ArrayList<>();
        list.add("1");
        when(mockPlanMapper.updateById(plan)).thenReturn(1);
        when(mockResourceMapper.updateResource(any())).thenReturn(1);
        assertEquals(2,planService.modify(plan,list));

    }

    @Test
    public void remove() throws Exception {
        when(mockPlanMapper.deleteById(any())).thenReturn(1);
        when(mockResourceMapper.deleteResource(any(),any())).thenReturn(1);
        assertTrue(planService.remove("1")>1);
    }

}