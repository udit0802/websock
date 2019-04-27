package com.airtel.websocket.kafka.consumer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.airtel.websocket.kafka.consumer.app.producer.ProduceData;
import com.airtel.websocket.kafka.consumer.app.utils.UserLocationMap;
import com.airtel.websocket.kafka.consumer.app.vo.Number;

@Controller
public class WebSocketController {
	
	@Autowired
	public SimpMessagingTemplate template;
	
	@Autowired
	private ProduceData data;

	@MessageMapping("/kafka" )
    @SendTo("/topic/showResult")
    public void kafka(List<Long> userIds) throws Exception {
		this.template.convertAndSend("/topic/liveUserMap",UserLocationMap.getLocations(userIds));
    }
	
	
	@MessageMapping("/map" )
//    @SendTo("/topic/showResult")
    public void addNum(@RequestBody Number num) throws Exception {
		this.template.convertAndSend("/topic/showResult",num.getNum1());
    }
	
	@RequestMapping("/start")
    public String start() {
        return "start";
    }
	
	@RequestMapping("/hitProducer")
	public @ResponseBody String putData() {
		data.send();
		return "success";
	}
    
}
