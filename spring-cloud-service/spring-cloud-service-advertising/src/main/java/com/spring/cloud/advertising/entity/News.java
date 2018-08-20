package com.spring.cloud.advertising.entity;

import com.spring.cloud.advertising.entity.support.BaseEntity;
import javax.persistence.*;

/**
 * <p>
 * 新闻表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "ims_commune_news")
public class News extends BaseEntity {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 源id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "news_id", nullable = false)
    private Integer news_id;

    /**
     * 源id
     */
    private Integer commercial_id;


    /**
     *
     */
    private Integer news_type;

    /**
     *
     */
    private String news_title;

    /**
     *
     */
    private String news_content;

    /**
     *
     */
    private String news_picture;

    /**
     *
     */
    private Integer point_rule_id;

    /**
     *
     */
    private String origin;

    /**
     *
     */
    private Integer comment_count;

    /**
     *
     */
    private Integer reading_count;

    /**
     *
     */
    private Integer good_count;

    /**
     *
     */
    private Integer bad_count;

    /**
     *
     */
    private Integer delete_flag;


    /**
     * 创建时间
     */
    private Integer createtime;


//    @ManyToMany(cascade = { CascadeType.REFRESH }, fetch = FetchType.LAZY)
//    @JoinTable(name = "ims_commune_commercial", joinColumns = { @JoinColumn(name = "news_id") }, inverseJoinColumns = { @JoinColumn(name = "commercial_id") })
//    private java.util.Set<Commercial> commercial;

    public Integer getNews_id() { return news_id; }

    public void setNews_id(Integer id) {
        this.news_id = id;
    }

    public Integer getCommercial_id() { return commercial_id; }

    public void setCommercial_id(Integer id) { this.commercial_id = id; }

    public Integer getNews_type() { return news_type; }

    public void setNews_type(Integer id) { this.news_type = id; }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String name) {
        this.news_title = name;
    }

    public String getNews_content() { return news_content; }

    public void setNews_content(String name) {
        this.news_content = name;
    }

    public String getNews_picture() { return news_picture; }

    public void setNews_picture(String name) { this.news_picture = name; }

    public String getOrigin () { return origin; }

    public void setOrigin(String name) { this.origin = name; }

    public Integer getPoint_rule_id() { return point_rule_id; }

    public void setPoint_rule_id(Integer id) {
        this.point_rule_id = id;
    }

    public Integer getComment_count() { return comment_count; }

    public void setComment_count(Integer id) {
        this.comment_count = id;
    }

    public Integer getReading_count() { return reading_count; }

    public void setReading_count(Integer id) {
        this.reading_count = id;
    }

    public Integer getGood_count() { return good_count; }

    public void setGood_count(Integer id) {
        this.good_count = id;
    }

    public Integer getBad_count() { return bad_count; }

    public void setBad_count(Integer id) {
        this.bad_count = id;
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
