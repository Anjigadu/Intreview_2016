import java.util.concurrent.CountDownLatch;

public class CL_Test {

	public static void main(String[] args) {

		CountDownLatch countDownLatch = new CountDownLatch(4);
		ServiceThread appService = new ServiceThread(countDownLatch,"appService",null);
		ServiceThread restService = new ServiceThread(countDownLatch,"restService",null);
		Thread appServiceThread = new Thread(appService);
		appServiceThread.start();
		Thread restServiceThread = new Thread(restService);
		restServiceThread.start();
		ServiceThread jmsService = new ServiceThread(countDownLatch,"jmsService",null);
		Thread jmsServiceThread = new Thread(jmsService);
		jmsServiceThread.start();
		ServiceThread timerService = new ServiceThread(countDownLatch,"timerService",Thread.currentThread());
		Thread timerServiceThread =  new Thread(timerService);
		timerServiceThread.start();
		System.out.println("I am waiting Now!!!");
		try {
			countDownLatch.await();
		} catch (InterruptedException ie) {
			System.out.println("I am interrupted, So task is not completed");
		}
		System.out.println("I am Done Now!!!");

	}

}

class ServiceThread implements Runnable {

	CountDownLatch countDownLatch;
	String serviceName;
	Thread serviceThread;

	public ServiceThread(CountDownLatch countDownLatch, String serviceName,Thread serviceThread) {
		super();
		this.countDownLatch = countDownLatch;
		this.serviceName = serviceName;
		this.serviceThread = serviceThread;
	}

	@Override
	public void run() {
		System.out.println("Thread Name : " + Thread.currentThread().getName() + " , serviceName : " + serviceName);
		if(serviceName.equalsIgnoreCase("timerService")) {
			System.out.println("Control is comming here before interrupt!!!");
			//throw new RuntimeException(">>");
			serviceThread.interrupt();
			System.out.println("Control is comming here after interrupt!!!");
			
		}else {
			try {
				Thread.sleep(10000L);
			} catch (InterruptedException e) {
				System.out.println("App service method is intterupted by other thred!!");
			}
		}
		countDownLatch.countDown();

	}

}
