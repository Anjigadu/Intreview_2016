1.  [JDK IO 2014 - Java Concurrency and Non blocking IO - Dr Heinz M. Kabutz](https://www.youtube.com/watch?v=vkjNjZiMt4w
)

2.  [Finding Subtle but Common Concurrency Issues in Java Programs](https://www.youtube.com/watch?v=Oi6-pXX11qw
)

3.  [Modern Java Concurrency - by Martijn Verburg & Ben Evans at JAX London Nov 2011](https://www.youtube.com/watch?v=qrCUy9H76IA)

4.  [What is CountDownLatch in Java - Concurrency Example Tutorial](http://javarevisited.blogspot.in/2012/07/countdownlatch-example-in-java.html)

5.  [JSR-166: Concurrency Utilities](http://gee.cs.oswego.edu/dl/concurrency-interest/jsr166-slides.pdf)

6. [Java EE 7 Recipes for Concurrency](https://www.youtube.com/watch?v=2I6D93gZGfE)  


### Core Java Interview Questions
---
1.  Difference between HashSet, TreeSet, and LinkedHashSet?

2.  What's the difference between ConcurrentHashMap and Collections.synchronizedMap(Map)?

3.  what is fail-safe & fail-fast Iterators in java & how they are implemented?

4.  Difference between equals() and hashCode()?

5.  How to Use the Java Collections Sort Method?

6.  Difference between HashMap, LinkedHashMap and TreeMap?

7.  What is BlockingQueue?

8.  [JVM and Garbage Collection Interview Questions: The Beginners Guide](https://dzone.com/articles/jvm-and-garbage-collection)

9.  Difference between StringBuilder and StringBuffer?  

10.  What is the difference between a soft reference and a weak reference in Java?

11.  Write code to find the max depth of a binary tree

12.  wait(), notify()

13.  in public static main() call object.wait() what happens?

14. what is the complexity of binary tree max depth

15. inner class vs static inner class (this guy can ask anything, annoymous inner class etc- be careful)

16.  [Threading interview Questoins](https://dzone.com/articles/threads-top-80-interview)

``` java
package com.sample;

/*
 * 1) How to create thread (Runnable/extend thread)
 * 
 * 2) How to send interrupt message(interrupt)
 * 
 * 3) Get thread name, completion status of thread(isActive), and wait for current thread to complete (join)
 * 
 * 4) Get current thread name
 * 
 * 5) When do I need to call this method Runtime.getRuntime().addShutdownHook()
			http://stackoverflow.com/questions/8722826/when-do-i-need-to-call-this-method-runtime-getruntime-addshutdownhook
			
 */
public class Thread1 {

	public static void main(String... strings) throws InterruptedException {
		

		 Runtime.getRuntime().addShutdownHook(new Thread() {
		      public void run() {
		        System.out.println("Running Shutdown Hook");
		      }
		    });
		System.out.println("Main :- " + Thread.currentThread().getName());
		DemoT demoT = new DemoT();
		Thread thread = new Thread(demoT);
		System.out.println("Main :- " + Thread.currentThread().getName());
		System.out.println("Main1 :- " + thread.isAlive());

		thread.start();

		System.out.println("Main2 :- " + thread.isAlive());

		thread.interrupt();
		System.out.println("Main21 :- " + thread.isAlive());
		
	}
}


class DemoT implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("Interrupted Thread!!!!!");
		}
		System.out.println(Thread.currentThread().getName());
	}
	
}

```
