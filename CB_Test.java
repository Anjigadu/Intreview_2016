import java.util.Date;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CB_Test {
	

	static class ServiceThread implements Runnable {

		CyclicBarrier cyclicBarrier;
		String serviceName;
		Thread serviceThread;

		public ServiceThread(CyclicBarrier cyclicBarrier, String serviceName,Thread serviceThread) {
			super();
			this.cyclicBarrier = cyclicBarrier;
			this.serviceName = serviceName;
			this.serviceThread = serviceThread;
		}

		@Override
		public void run() {
			System.out.println("START : " + "Thread Name : " + Thread.currentThread().getName() + " , serviceName : " + serviceName);
			try {
				System.out.println( "START : ServiceName : " + serviceName + ", Time : " + new Date().getTime());
				cyclicBarrier.await();
				System.out.println( "END : ServiceName : " + serviceName + ", Time : " + new Date().getTime());
			} catch (InterruptedException e) {
				System.out.println("InterruptedException : "  + "Thread Name : " + Thread.currentThread().getName() + " , serviceName : " + serviceName);
			} catch (BrokenBarrierException e) {
				System.out.println("BrokenBarrierException : "  + "Thread Name : " + Thread.currentThread().getName() + " , serviceName : " + serviceName);
			}
			
			System.out.println("END : " + "Thread Name : " + Thread.currentThread().getName() + " , serviceName : " + serviceName);

		}

	}

	
	public static void main(String[] args) {

		CyclicBarrier cyclicBarrier = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				System.out.println("cyclicBarrier is finalized>>");
			}
		});
		
		ServiceThread appService = new ServiceThread(cyclicBarrier,"appService",null);
		ServiceThread restService = new ServiceThread(cyclicBarrier,"restService",null);
		Thread appServiceThread = new Thread(appService);
		appServiceThread.start();
		Thread restServiceThread = new Thread(restService);
		restServiceThread.start();
		ServiceThread jmsService = new ServiceThread(cyclicBarrier,"jmsService",null);
		Thread jmsServiceThread = new Thread(jmsService);
		jmsServiceThread.start();
		ServiceThread timerService = new ServiceThread(cyclicBarrier,"timerService",Thread.currentThread());
		Thread timerServiceThread =  new Thread(timerService);
		timerServiceThread.start();
		
		System.out.println("I am Done Now!!!");

	}

}
