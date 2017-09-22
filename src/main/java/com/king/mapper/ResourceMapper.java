package com.king.mapper;

import com.king.model.Resource;
import org.apache.ibatis.annotations.Param;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by king on 2017/7/28.
 */
public interface ResourceMapper {
    int insertResource(Resource resource);

    List<Resource> findByPlanId(BigInteger id);

    Resource findByIdAndPlanId(@Param("id") BigInteger id,@Param("planId") BigInteger plaId);

    int updateResource(Resource resource);

    int deleteResource(@Param("id") BigInteger id, @Param("planId") BigInteger planId);
}
