package com.coding.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import net.sf.jsqlparser.expression.DateTimeLiteralExpression;

import javax.persistence.EmbeddedId;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "sensor_data1")
public class Sensordata {
    private static final long serialVersionUID = 1L;
    /**
     * 时间
     */
    @Column(name = "monitor_time")
    private String monitorTime;

    /**
     * 数据
     */

    @Column(name = "monitor_data")
    private String monitorData;

    /**
     * 传感器所在桥的id
     */
    @Column(name = "bridge_id")
    private String bridgeId;


    /**
     * 传感器的id
     */
    @Column(name = "monitor_id")
    private String monitorId;


    /**
     * 数据的id
     */
    @Id
    @Column(name = "data_id")
    private String dataId;



}
