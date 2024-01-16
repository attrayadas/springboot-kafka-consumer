package com.attraya;

import com.attraya.dto.PaymentRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
@Slf4j // Lombok annotation to generate Logger log = LoggerFactory.getLogger(LogExample.class);
public class SpringbootKafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootKafkaConsumerApplication.class, args);
	}

	@KafkaListener(topics = "payment-topic1", groupId = "Payment_consumer_group")
	public void paymentConsumer1(PaymentRequest paymentRequest) throws JsonProcessingException {
		// business logic
		log.info("paymentConsumer1 consumed message {}", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	/*
	If there are 3 partitions in the topic and 4 consumer, 1 consumer will be on bench
	 */
	@KafkaListener(topics = "payment-topic1", groupId = "Payment_consumer_group")
	public void paymentConsumer2(PaymentRequest paymentRequest) throws JsonProcessingException {
		// business logic
		log.info("paymentConsumer2 consumed message {}", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "payment-topic1", groupId = "Payment_consumer_group")
	public void paymentConsumer3(PaymentRequest paymentRequest) throws JsonProcessingException {
		// business logic
		log.info("paymentConsumer3 consumed message {}", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "payment-topic1", groupId = "Payment_consumer_group")
	public void paymentConsumer4(PaymentRequest paymentRequest) throws JsonProcessingException {
		// business logic
		log.info("paymentConsumer4 consumed message {}", new ObjectMapper().writeValueAsString(paymentRequest));
	}

	@KafkaListener(topics = "payment-topic1", groupId = "Payment_consumer_group")
	public void paymentConsumer5(PaymentRequest paymentRequest) throws JsonProcessingException {
		// business logic
		log.info("paymentConsumer5 consumed message {}", new ObjectMapper().writeValueAsString(paymentRequest));
	}

}
