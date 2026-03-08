package com.kclm.owep.entity.vo;

import java.util.Arrays;

public class SummaryVideo {

    private String name; //前端要用到的name
    private int[] numbers; //每周的播放量
    private int week;
    private String videoName;
    private int number;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "SummaryVideo{" +
                "name='" + name + '\'' +
                ", numbers=" + Arrays.toString(numbers) +
                ", week=" + week +
                ", videoName='" + videoName + '\'' +
                ", number=" + number +
                '}';
    }
}
