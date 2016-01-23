package freelance.poc.spring.ex1;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class HelloWorld implements ApplicationContextAware {
	private String message;
	private static ApplicationContext context;

	public void setMessage(String message) {
		this.message = message;
	}

	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		context = arg0;

	}
}