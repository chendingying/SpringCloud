package com.spring.cloud.advertising.entity;

import com.spring.cloud.advertising.entity.support.BaseEntity;

import javax.persistence.*;

/**
 * <p>
 * 积分规则表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "ims_commune_point_rule")
public class PointRule extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 源id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "point_rule_id", nullable = false)
    private Integer point_rule_id;

    /**
     *
     */
    private String name;

    /**
     *
     */
    private Integer point;

    /**
     *
     */
    private Integer time;

    /**
     *
     */
    private Integer get_count;

    /**
     *
     */
    private Integer timeout;


    /**
     *
     */
    private Integer delete_flag;


    /**
     * 创建时间
     */
    private Integer createtime;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPoint_rule_id() { return point_rule_id; }

    public void setPoint_rule_id(Integer id) {
        this.point_rule_id = id;
    }

    public Integer getPoint() { return point; }

    public void setPoint(Integer id) { this.point = id; }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer name) {
        this.time = name;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer name) {
        this.timeout = name;
    }

    public Integer getGet_count() {
        return get_count;
    }

    public void setGet_count(Integer name) {
        this.get_count = name;
    }


    public Integer getDelete_flag() { return delete_flag; }

    public void setDelete_flag(Integer id) {
        this.delete_flag = id;
    }

    public Integer getCreatetime() { return createtime; }

    public void setCreatetime(Integer id) {
        this.createtime = id;
    }


}
