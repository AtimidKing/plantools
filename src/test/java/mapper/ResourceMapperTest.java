package mapper;

import com.king.mapper.ResourceMapper;
import com.king.model.Resource;
import config.TestMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigInteger;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by king on 2017/8/17.
 */
public class ResourceMapperTest extends TestMapper {

    @Autowired
    private ResourceMapper resourceMapper;
    @Test
    public void insertResource() throws Exception {
    }

    @Test
    public void findByPlanId() throws Exception {
        BigInteger planid=new BigInteger("194457");
        List<Resource> resourceList = resourceMapper.findByPlanId(planid);
        assertEquals(2, resourceList.size());
    }

    @Test
    public void updateResource() throws Exception {
//        12447,194457
        Resource resource=new Resource(new BigInteger("12447")
                ,new BigInteger("194457"),"s");
        assertEquals(1, resourceMapper.updateResource(resource));
    }

    @Test
    public void deleteResource() throws Exception {
        assertEquals(1, resourceMapper.deleteResource(null,
                new BigInteger("194456")));
    }

}