package freelance.poc.spring.ex1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Ex1 {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("META-INF/Ex1.xml");

		HelloWorld obj = (HelloWorld) context.getBean("helloWorld");

		obj.getMessage();
		
		System.out.println(obj);
		
		HelloWorld obj1 = (HelloWorld) context.getBean("helloWorld");
		System.out.println(obj1);


	}
}