package com.airtel.websocket.kafka.consumer.app.vo;

import com.airtel.websocket.kafka.consumer.app.entity.UserEntity;

/**
 * PRODUCT OF PRODUCT ENGINEERING
 */


public class TrackingRequest {

	private String latitude;

	private String longitude;

	private String travelId;

	private String token;

	private String pk;

	private float dis;

	private long timestamp;

	private UserEntity userEntity;

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public float getDis() {
		return dis;
	}

	public void setDis(float dis) {
		this.dis = dis;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getTravelId() {
		return travelId;
	}

	public void setTravelId(String travelId) {
		this.travelId = travelId;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "{\"latitude\":\"" + latitude + "\",\"longitude\":\"" + longitude + "\",\"travelId\":\"" + travelId
				+ "\",\"token\":\"" + token + "\",\"pk\":\"" + pk + "\",\"dis\":" + dis + ",\"timestamp\":" + timestamp
				+ ",\"userId\":" + getUserId() + "}";
	}

	public String getPk() {
		return pk;
	}

	public void setPk(String pk) {
		this.pk = pk;
	}

	public long getUserId() {
		return userEntity.getUserId();
	}
	
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	public String getrole() {
		return userEntity .getRole();
	}

}