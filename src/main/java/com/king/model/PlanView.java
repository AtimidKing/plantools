package com.king.model;

import java.util.List;

/**
 * Created by king on 2017/7/28.
 */
public class PlanView {
    private Plan plan;
    private String fettle;
    private List<Resource> resources;

    public PlanView(Plan plan) {
        this.plan = plan;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }


    public String getFettle() {
        return fettle;
    }

    private void setFettle() {
        switch (plan.getStatus()) {
            case 0:
                this.fettle = "未开始";
                break;
            case 1:
                this.fettle = "进行中";
                break;
            case 2:
                this.fettle = "已完成";
                break;
            default:
                this.fettle = null;
        }
    }

    public List<Resource> getResources() {
        return resources;
    }

    public void setResources(List<Resource> resources) {
        this.resources = resources;
    }


}
