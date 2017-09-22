package com.king.service.impl;

import com.king.file.handle.FileHandler;
import com.king.mapper.ResourceMapper;
import com.king.model.Resource;
import com.king.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

/**
 * Created by king on 2017/7/28.
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    private ResourceMapper resourceMapper;
    private FileHandler fileHandler;
    @Autowired
    ResourceServiceImpl(ResourceMapper resourceMapper,FileHandler fileHandler){
        this.resourceMapper=resourceMapper;
        this.fileHandler=fileHandler;
    }
    @Override
    public int save(Resource resource) {
        resourceMapper.insertResource(resource);
        return 0;
    }

    @Override
    public byte[] download(String fileName) throws IOException {
        File file = new File("E:" + File.separator + "temp" + File.separator + "uploads", fileName);
        return fileHandler.fileToByteArray(file);
    }

    @Override
    public List<Resource> getResourceByPlan(BigInteger planId) {
        return resourceMapper.findByPlanId(planId);
    }

    @Override
    public Resource getResource(BigInteger id, BigInteger planId) {
        return resourceMapper.findByIdAndPlanId(id,planId);
    }
}
