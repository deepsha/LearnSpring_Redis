package com.shop.app.paymentservice.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;


public class PaymentListener implements MessageListener {

	Logger log=LoggerFactory.getLogger(PaymentListener.class);
	@Override
	public void onMessage(Message message, byte[] bytes) {
		log.info("within PaymentListener consumed event:"+message);
		
	}

}
