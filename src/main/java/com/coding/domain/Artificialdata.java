package com.coding.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.hibernate.annotations.DynamicInsert;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@DynamicInsert

@Table(name = "artificial_data")
public class Artificialdata {
    private static final long serialVersionUID = 1L;
    /**
     * 图片地址
     */
    @Column(name = "artifitial_pic")
    private String artifitialPic;
    /**
     * 病害位置
     */
    @Column(name = "disease_loc")
    private String diseaseLoc;
    /**
     * 病害监测值
     */
    @Column(name = "disease_data")
    private String diseaseData;
    /**
     * 病害评估
     */
    @Column(name = "disease_evaluate")
    private String diseaseEvaluate;
    /**
     * 补充说明
     */
    @Column(name = "supplementary_notes")
    private String supplementaryNotes;
    /**
     * 检查的时间
     */
    @Column(name = "inspection_time")
    private String inspectionTime;
    /**
     * 检查者的id
     */
    @Column(name = "inspector_id")
    private String inspectorId;
    /**
     * 监测数据id
     */
    @Id
    @Column(name = "id")
    private Long id;
}