package com.king.service.impl;

import com.king.mapper.PlanMapper;
import com.king.mapper.ResourceMapper;
import com.king.model.Plan;
import com.king.model.PlanView;
import com.king.model.Resource;
import com.king.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by king on 2017/7/26.
 */
@Service
public class PlanServiceImpl implements PlanService {

    private PlanMapper planMapper;
    private ResourceMapper resourceMapper;

    @Autowired
    public PlanServiceImpl(PlanMapper planMapper,ResourceMapper resourceMapper){
        this.planMapper=planMapper;
        this.resourceMapper=resourceMapper;
    }

    /**
     * 获取全部的Plan对象
     * @return
     */
    @Override
    public List<Plan> getPlans() {
        return planMapper.getPlans();
    }

    /**
     * 获取区指定的Plan和Resource
     * @param id 指定编号
     * @return
     */
    @Override
    public PlanView getPlanAndResource(String id) {
        PlanView planView = new PlanView(planMapper.findById(new BigInteger(id)));
        planView.setResources(resourceMapper.findByPlanId(new BigInteger(id)));
        return planView;
    }

    /**
     * 保存plan信息到数据库
     * @param plan
     * @param resourceNames
     * @return
     * @throws IOException
     */
    @Override
    public int save(Plan plan,List<String> resourceNames) throws IOException {
        plan.stuffDateAndStatus();
        int count=planMapper.insert(plan);
        List<Resource> resources = getResources(resourceNames,plan.getId());
        for (int i = 0; i < resources.size(); i++) {
            count = count + resourceMapper.insertResource(resources.get(i));
        }
        return count;
    }



    /**
     * 生成Plan的resource对象
     * @param resourceNames
     * @param planId
     * @return
     * @throws IOException
     */
    private List<Resource> getResources(List<String> resourceNames, BigInteger planId) throws IOException {
        List<Resource> resources = new ArrayList<>();
        for (int i = 0; i < resourceNames.size(); i++) {
            resources.add(new Resource(null,planId,resourceNames.get(i)));
        }

        return resourceNames.stream().map(resourceName ->
                new Resource(null, planId, resourceName)).collect(Collectors.toList());
    }

    /**
     * 修改Plan的信息
     * @param plan
     * @param resourceNames
     * @return
     * @throws IOException
     */
    @Override
    public int modify(Plan plan,List<String> resourceNames) throws IOException {
        int count=planMapper.updateById(plan);
        List<Resource> resources = getResources(resourceNames,plan.getId());
        for (int i = 0; i < resources.size(); i++) {
            count = count + resourceMapper.updateResource(resources.get(i));
        }
        return count;
    }

    /**
     * 删除计划的所有信息
     * @param id
     * @return
     */
    @Override
    public int remove(String id) {
        int count = resourceMapper.deleteResource(new BigInteger(id),new BigInteger(id));
        count=count+planMapper.deleteById(new BigInteger(id));
        return count;
    }
}
