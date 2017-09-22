package com.king.service;

import com.king.model.Plan;
import com.king.model.PlanView;
import com.king.model.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by king on 2017/7/26.
 */

public interface PlanService {
    /**
     * 获取全部的计划。
     * @return
     */
    List<Plan> getPlans();

    /**
     *获取指定计划
     * @return
     */
    PlanView getPlanAndResource(String id);

    /**
     * 保存计划
     * @param plan
     * @return
     */
    int save(Plan plan, List<String> resourceNames) throws IOException;

    /**
     * 修改计划
     * @return
     */
    int modify(Plan plan,List<String> resourceNames) throws IOException;

    /**
     * 移除计划
     * @return
     */
    int remove(String id);
}