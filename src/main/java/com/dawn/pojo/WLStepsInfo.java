package com.dawn.pojo;

public class WLStepsInfo {
    private Integer stepid;

    private String stepinfo;

    private Integer hours;

    private Integer minutes;

    public Integer getStepid() {
        return stepid;
    }

    public void setStepid(Integer stepid) {
        this.stepid = stepid;
    }

    public String getStepinfo() {
        return stepinfo;
    }

    public void setStepinfo(String stepinfo) {
        this.stepinfo = stepinfo == null ? null : stepinfo.trim();
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}