package com.spring.cloud.advertising.entity;

import com.spring.cloud.advertising.entity.support.BaseEntity;
import javax.persistence.*;

/**
 * <p>
 * 信息表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "ims_commune_information")
public class Information extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 源id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "information_id", nullable = false)
    private Integer information_id;

    /**
     * 源id
     */
    private Integer commercial_id;


    /**
     * 源名称
     */
    private String information_title;

    /**
     * 源logo
     */
    private String information_content;

    /**
     * 源名称
     */
    private Integer like_count;


    /**
     * 创建时间
     */
    private Integer createtime;


    public Integer getInformation_id() {
        return information_id;
    }

    public void setInformation_id(Integer information_id) {
        this.information_id = information_id;
    }

    public Integer getCommercial_id() {
        return commercial_id;
    }

    public void setCommercial_id(Integer commercial_id) {
        this.commercial_id = commercial_id;
    }

    public String getInformation_title() {
        return information_title;
    }

    public void setInformation_title(String information_title) {
        this.information_title = information_title;
    }

    public String getInformation_content() {
        return information_content;
    }

    public void setInformation_content(String information_content) {
        this.information_content = information_content;
    }

    public Integer getLike_count() {
        return like_count;
    }

    public void setLike_count(Integer like_count) {
        this.like_count = like_count;
    }

    public Integer getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Integer createtime) {
        this.createtime = createtime;
    }
}
