package com.airtel.websocket.kafka.consumer.app.entity;

import java.io.Serializable;

public class UserEntity implements Serializable {

	/**
	*
	 */
	private static final long serialVersionUID = 1L;

	private Long userId;

	private String olmId;

	private String name;

	private String mobile;

	private String role;

	private boolean isActive;

	private String lob;

	private String circle;

	private String area;

	private String zone;

	private String section;

	public String getLob() {
		return lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getCircle() {
		return circle;
	}

	public void setCircle(String circle) {
		this.circle = circle;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getOlmId() {
		return olmId;
	}

	public void setOlmId(String olmId) {
		this.olmId = olmId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

}
