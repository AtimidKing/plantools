package com.king.mapper;

import com.king.model.Plan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

/**
 * Created by king on 2017/7/25.
 */

public interface PlanMapper {
     List<Plan> getPlans();
     Plan findById(BigInteger id);

    int insert(Plan plan);

    int updateById(Plan plan);

    int updateStatus(@Param("id") BigInteger id,@Param("status") int status);

    int deleteById(BigInteger id);
}
