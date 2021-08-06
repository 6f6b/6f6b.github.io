package com.jusekj.inquiry.shukang.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author tao.xiong
 * @Description 测评结果
 * @Date 2021/8/2 18:53
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class AssessmentResult {
    /**
     * 危险因素
     */
    private HazardsAnalysis hazardsAnalysis;
    /**
     * 运动测评结果
     */
    private List<PhysicalAssessment> physicalAssessment;

    /**
     * 疼痛测评结果
     */
    private PainAssessment painAssessment;

    /**
     * 身体评估结果（⼈形图）
     */
    private List<BodyAssessment> bodyAssessment;
    /**
     * 其他评估
     */
    private Object otherAssessment;

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public static class HazardsAnalysis {
        private String diagnose;
        //api 返回String
        private List<String> hazards;

        @Data
        @EqualsAndHashCode(callSuper = false)
        @Accessors(chain = true)
        private static class Hazard {
            private String icon;
            private String keyword;
            private String valueText;
        }
    }

    @Data
    @EqualsAndHashCode(callSuper = false)
    @Accessors(chain = true)
    public static class PhysicalAssessment {
        private String title;
        private List<Item> items;

        @Data
        @EqualsAndHashCode(callSuper = false)
        @Accessors(chain = true)
        private static class Item {
            private String id;
            private String description;
            private String icon;
            private List<Result> results;

            @Data
            @EqualsAndHashCode(callSuper = false)
            @Accessors(chain = true)
            private static class Result {
                private String result;
                //1：差
                //2：较差
                //3：中等偏下
                //4：中等
                //5：中等偏上
                //6：良好
                //7：优秀
                private Number level1;