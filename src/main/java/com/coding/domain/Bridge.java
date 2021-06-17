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

@Table(name = "bridge_detail")
public class Bridge implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 桥的名字
     */
    @Column(name = "bridge_name")
    private String bridgeName;
    /**
     * 桥的id
     */
    @Id
    @Column(name = "bridge_id")
    private String bridgeId;
    /**
     * 桥的位置
     */
    @Column(name = "bridge_loc")
    private String bridgeLoc;
    /**
     * 桥的具体信息
     */
    @Column(name = "bridge_inf")
    private String bridgeInf;
}
