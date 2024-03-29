package springbootactivemq;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
public class Producer implements CommandLineRunner{

	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
	private Queue queue;

	public void run(String... args) throws Exception {
		send("Producer sending message to Consumer");
	}

	public void send(String msg) {
		this.jmsMessagingTemplate.convertAndSend(this.queue, msg);
	}
}
