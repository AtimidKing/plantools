package com.king.controller;

import com.king.model.Resource;
import com.king.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigInteger;

/**
 * Created by king on 2017/7/28.
 */
@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    ResourceService resourceService;

    /**
     * 显示目标计划的附加资源
     *
     * @param model
     * @param id    目标计划的编号
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String showResource(Model model, String id) {
        //TODO 取得目标的计划的资源列表
        model.addAttribute("resourceList", resourceService.getResourceByPlan(new BigInteger(id)));
        return "showResource";
    }

    /**
     * 下载资源
     *
     * @param id 目标计划的编号
     * @return
     */
    @GetMapping("/download/*")
    public ResponseEntity<byte[]> downloadResource(
            @RequestParam String id,@RequestParam String planId) throws IOException {
        Resource resource = resourceService.getResource(new BigInteger(id), new BigInteger(planId));
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        responseHeaders.setContentDispositionFormData("attachment",
                resource.getAddress());
        return new ResponseEntity<byte[]>(resourceService.download(resource.getAddress()), responseHeaders, HttpStatus.CREATED);
    }
}
