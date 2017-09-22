package com.king.service;

import com.king.model.Resource;

import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by king on 2017/7/28.
 */
public interface ResourceService {
    /**
     * 保存资源到信息
     *
     * @param resource
     * @return
     */
    int save(Resource resource);

    /**
     * 下载资源信息
     *
     * @param id     资源编号
     * @param planId 所属计划编号
     * @return
     */
    byte[] download(String fileName) throws IOException;

    List<Resource> getResourceByPlan(BigInteger planId);

    Resource getResource(BigInteger id, BigInteger planId);
}
