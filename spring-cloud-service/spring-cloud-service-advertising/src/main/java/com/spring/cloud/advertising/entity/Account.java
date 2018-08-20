package com.spring.cloud.advertising.entity;

import com.spring.cloud.advertising.entity.support.BaseEntity;

import javax.persistence.*;

/**
 * <p>
 * 账户表
 * </p>
 *
 * @author SPPan
 * @since 2016-12-28
 */
@Entity
@Table(name = "ims_account_transfer")
public class Account extends BaseEntity {

	private static final long serialVersionUID = 1L;

	/**
	 * 用户id
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false)
	private Integer id;

	/**
	 *
	 */
	private String user_id;

	/**
	 *
	 */
	private String login_name;

	/**
	 *
	 */
	private String nick_name;

	/**
	 *
	 */
	private String picture_url;

	/**
	 *
	 */
	private Integer point;

	/**
	 *
	 */
	private Integer is_delete;

	/**
	 *
	 */
	private Integer updatetime;



	/**
	 * 创建时间
	 */
	private Integer createtime;


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String name) { this.user_id = name; }

	public String getLogin_name() {
		return login_name;
	}

	public void setLogin_name(String name) {
		this.login_name = name;
	}

	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String name) {
		this.nick_name = name;
	}

	public String getPicture_url() {
		return picture_url;
	}

	public void setPicture_url(String name) {
		this.picture_url = name;
	}

	public Integer getIs_delete() {
		return is_delete;
	}

	public void setIs_delete(Integer point) {
		this.is_delete = point;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Integer getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Integer time) {
		this.updatetime = time;
	}

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer time) {
		this.createtime = time;
	}


}
