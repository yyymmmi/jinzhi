package com.coding.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)

@Table(name = "sensor_detail")
public class Sensordetail{
    private static final long serialVersionUID = 1L;
    /**
     * 传感器的名字
     */
    @Column(name = "sensor_name")
    private String sensorName;
    /**
     * 传感器类型
     */
    @Column(name = "sensor_type")
    private String sensorType;
    /**
     * 传感器的id
     */
    @Id
    @Column(name = "sensor_id")
    private String sensorId;
    /**
     * 传感器的位置
     */
    @Column(name = "sensor_loc")
    private String sensorLoc;

    /**
     * 传感器的状态
     */
    @Column(name = "sensor_state")
    private String sensorState;
    /**
     * 传感器所在的桥的id
     */
    @Column(name = "bridge_id")
    private String bridgeId;
}
