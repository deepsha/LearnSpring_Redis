package com.shop.app.paymentservice.publisher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shop.app.paymentservice.consumer.PaymentListener;
import com.shop.app.paymentservice.entity.Product;

@RestController
public class PaymentPublisher {
	Logger log=LoggerFactory.getLogger(PaymentPublisher.class);
	@Autowired
	private RedisTemplate template;
	
	@Autowired
	private ChannelTopic topic;
	
	@PostMapping("/publish")
	public String publishMessage(@RequestBody Product product)
	{   log.info("Within payment publisher:"+product.toString());
		template.convertAndSend(topic.getTopic(), product.toString());
		return "Event published!";
	}

}
