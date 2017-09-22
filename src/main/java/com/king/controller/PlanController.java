package com.king.controller;

import com.king.file.handle.FileHandlerImpl;
import com.king.model.Plan;
import com.king.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by king on 2017/7/25.
 */
@Controller
public class PlanController {

    private PlanService plans;//计划的服务
    @Autowired
    public PlanController(PlanService plans){
        this.plans=plans;
    }

    /**
     * 计划列表显示
     * @param model
     * @return
     */
//    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String getPlan(Model model) {
        model.addAttribute("plans", plans.getPlans());
        return "index";
    }

    /**
     * 创建计划
     * @return
     */
    @RequestMapping(value = {"/create"}, method = RequestMethod.GET)
    public String insertPlan() {
        return "create";
    }

    /**
     * 保存计划
     * @param planFile 计划需要的附加资源
     * @param plan 计划本身
     * @return
     * @throws IOException
     */
    @RequestMapping(value = {"/create"}, method = RequestMethod.POST)
    public String insertPlan(@Validated Plan plan,
            @RequestPart MultipartFile ...planFile
            ) throws IOException {
        plans.save(plan,new FileHandlerImpl().saveFile(planFile));
        return "redirect:/index";
    }

    /**
     * 修改计划（添加资源，删除资源）
     * @param id 要修改计划的编号
     * @param model
     * @return
     */
    @RequestMapping(value = {"/modify"}, method = RequestMethod.GET)
    public String modifyPlan(String id, Model model) {
        model.addAttribute("plan", plans.getPlanAndResource(id));
        return "modify";
    }

    /**
     * 保存修改的计划。
     * @param plan 修改后的计划
     * @param planFile 添加的资源。
     * @return
     */
    @RequestMapping(value = {"/modify"}, method = RequestMethod.POST)
    public String modifyPlan(Plan plan,@RequestPart MultipartFile planFile) throws IOException {
        plans.modify(plan,new FileHandlerImpl().saveFile(planFile));
        return "redirect:/index";
    }

    /**
     * 删除计划（删除计划和附带资源）
     * @param id 要删除计划的编号
     * @return
     */
    @RequestMapping(value = {"/delete"}, method = RequestMethod.GET)
    public String deletePlan(String id) {
        plans.remove(id);
        return "redirect:/index";
    }

    /**
     * 上传文件
     * @return
     */
    @RequestMapping(value = "/upload",method = RequestMethod.GET)
    public String upload(){
        return "upload";
    }

    /**
     * 编程上传的文件
     * @param file 上传的文件
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file)throws IOException{
        System.out.println("---->  " + file.getName() + "  ::  "  + file.getSize());
        return "redirect:/index";
    }
}
