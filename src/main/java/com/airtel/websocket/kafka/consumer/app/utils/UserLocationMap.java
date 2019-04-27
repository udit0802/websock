package com.airtel.websocket.kafka.consumer.app.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.airtel.websocket.kafka.consumer.app.vo.Location;

public class UserLocationMap {

	public static HashMap<Long, Location> userLocationMap = new HashMap<>();
	
	public static HashMap<Long, Location> selectedUserLocationMap = new HashMap<>();

	public static synchronized void insertIfNotExist(Long key,Location location) {
		userLocationMap.put(key,location);
	}

	public static synchronized Location getLocation(Long key) {
		return userLocationMap.get(key);

	}
	
	public static synchronized Map<Long,Location> getLocations(List<Long> keys) {
		for(Long key : keys) {
			selectedUserLocationMap.put(key, userLocationMap.get(key));
		}
		return selectedUserLocationMap;

	}

	public static synchronized void removeRetryData(Long key) {
		if (userLocationMap.containsKey(key))
			userLocationMap.remove(key);
	}

}
