### Multithreading
---

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
11.  ```Read file from classpath```
``` java
import java.io.InputStream;
import java.net.URL;
import java.net.URLClassLoader;

/*
    Example: Read resource from class path
*/
public class WebScrapping {

    public static void main(String[] args) throws Exception {

        InputStream is;
        int i;
        char c;
        is = ClassLoader.getSystemClassLoader().getResourceAsStream("test.io");
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        URL[] urls = ((URLClassLoader) cl).getURLs();
        for (URL url : urls) {
            System.out.println(url.getFile());
        }
        // reads till the end of the stream
        while ((i = is.read()) != -1) {
            // converts integer to character
            c = (char) i;
            // prints character
            System.out.print(c);
        }
        is.close();

    }
}
```
12.  ```Observer pattern with memory leak```

``` java
/*
  + Memory leak
  + Event base programming
  + garbage collection
*/

package leak;

import java.lang.ref.WeakReference;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


public class Publisher {
  
  public static interface Listner {
    public void onEvent(Event event);
    public int getId();
  }
  
  public static class Event {
    private int eventId;
    public Event(int id) {
      this.eventId = id;
    }
    public int getEventId() {
      return eventId;
    }
  }

  /*private static List<Listner> listners = 
      Collections.synchronizedList(new ArrayList<Listner>());
*/  private static List<WeakReference<Listner>> listners = 
      new CopyOnWriteArrayList<WeakReference<Listner>>();
  
  
  public static void subscribe(Listner listner) {
    listners.add(new WeakReference<Listner>(listner));
  }
  
  public static void unsubscribe(Listner listner) {
    listners.remove(listner);
  }
  
  private Publisher() {
    
  }
  
  public static void publishEvent(Event event) {
    System.out.print("{"+event.eventId + "}" + "\t[");
    for (WeakReference<Listner> listner : listners) {
      if(listner.get() == null) {
      }else {
        listner.get().onEvent(event);
        System.out.print(listner.get().getId()+",");
      }
    }
    System.out.println("]");
  }
}


package leak;

import leak.Publisher.Event;

//heavy object
public class Subscriber implements Publisher.Listner{
  
  Object[] objects;
  private volatile static int global_counter;
  private  int counter;

  public Subscriber() {
    Publisher.subscribe(this);
    objects = new Object[10000000];
    global_counter++;
    counter = global_counter;
  }

  @Override
  public void onEvent(Event event) {
  }
  
  @Override
  public String toString() {
    return Integer.toString(counter);
  }

  @Override
  public int getId() {
    return counter;
  }
}


package leak;


public class Main {
  public static void main(String... args) {
    
    //event subscriber thread
    new Thread( new Runnable() {  
      @Override
      public void run() {
        for (int i = 0; i < 100000; i++) {
          Subscriber sub = new Subscriber();
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
    
    //event producer thread
    new Thread( new Runnable() {  
      @Override
      public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
          Publisher.publishEvent( new Publisher.Event(i));
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            e.printStackTrace();
          }
        }
      }
    }).start();
    
  }
}

```
13.  ```Dynamic Attribute```

``` java
import java.util.HashMap;
import java.util.Map;

public class DynamicAttribute {

	Map<String, ContractType> objectMaps = new HashMap<String, ContractType>();

	public void addObject(String key, Object instance) {
		ContractType contractType = new ContractType(key, instance);
		objectMaps.put(key, contractType);
	}

	public <T> T getObject(Class<T> clazz, String key) {
		return clazz.cast(objectMaps.get(key).getInstance());
	}

	@SuppressWarnings("unchecked")
	public <T> T getObject(String key) {
		return (T) getObject(objectMaps.get(key).getType(), key);
	}

}

class ContractType {

	private Class<?> type;
	private String name;
	private Object instance;

	public ContractType(String name, Object instance) {
		super();
		this.type = instance.getClass();
		this.name = name;
		this.instance = instance;
	}

	public Class<?> getType() {
		return type;
	}

	public String getName() {
		return name;
	}

	public Object getInstance() {
		return instance;
	}

	@Override
	public String toString() {
		return "ContractType [type=" + type + ", name=" 
		   + name + ", instance=" + instance + "]";
	}
	
}





class A {

	private String a;

	public String getA() {
		return a;
	}
	
	public void setA(String a) {
		this.a = a;
	}
	
}


class B {
	private String b;

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

}

public class Test {

	public static void main(String[] args) {
		DynamicAttribute da = new DynamicAttribute();

		A a = new A();
		a.setA("A");
		A a1 = new A();
		a1.setA("A1");
		da.addObject("A1", a);
		da.addObject("A2", a);
		da.addObject("A3", a1);
		
		B b = new B();
		b.setB("B");
		B b1 = new B();
		b1.setB("B1");
		da.addObject("B1", b);
		da.addObject("B2", b);
		da.addObject("B3", b1);
		
	
		B bRes = da.getObject("B1");
		System.out.println(bRes.getB());

	}

}

```
### Hibernate
---

##### Tutorial

+ [How to map a composite key with Hibernate?](http://stackoverflow.com/questions/3585034/how-to-map-a-composite-key-with-hibernate)

+ [Essential object-relational mapping in JPA](https://nikojava.wordpress.com/2011/08/04/essential-jpa-relationships/)

+ [Hibernate - Java Brains](https://javabrains.io/courses?topic=hibernate)

+ [JPA Implementation Patterns: Mapping Inheritance Hierarchies](https://dzone.com/articles/jpa-implementation-patterns-mapping)

+ [Hibernate Inheritance Joined Strategy Example](http://www.javaroots.com/2013/07/hibernate-inheritance-joined-strategy.html)

+ [JPA Gotchas and Best Practices: Lessons from Overstock.com](https://www.youtube.com/watch?v=XGiKJzZWnCA)

##### Book

+ [Java Persistence with Hibernate](http://www.amazon.in/Java-Persistence-Hibernate-Christian-Bauer/dp/1617290459?tag=googinhydr18418-21&tag=googinkenshoo-21&ascsubtag=3005f0ab-89e4-4958-8694-b99c6e9ea25e)

+ [Pro JPA 2: Mastering the Java(TM) Persistence API (Expert's Voice in Java Technology)](http://www.amazon.com/gp/product/1430219564/ref=pd_lpo_sbs_dp_ss_1?pf_rd_p=1944687582&pf_rd_s=lpo-top-stripe-1&pf_rd_t=201&pf_rd_i=1430249269&pf_rd_m=ATVPDKIKX0DER&pf_rd_r=0ETFY7M5BZ4SJJPN06A6)


##### Interview Question

+ [Hibernate Interview Questions and Answers](http://www.journaldev.com/3633/hibernate-interview-questions-and-answers)


### Spring
---

##### Tutorial

+ [Bean Scope](http://www.tutorialspoint.com/spring/spring_bean_scopes.htm)

+ [Spring beans autowiring concepts](http://howtodoinjava.com/spring/spring-core/spring-beans-autowiring-concepts/) 

+ [Spring Framework Reference Documentation](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/index.html)


##### Interview Question

+ [Top Spring Core Interview Questions with Answers](http://howtodoinjava.com/2015/02/26/top-spring-core-interview-questions-with-answers/)

##### Book

+ [Spring in Action](http://www.amazon.in/Spring-Action-Craig-Walls/dp/161729120X?tag=googinhydr18418-21)

+ [Expert Spring MVC and Web Flow](http://www.amazon.com/Expert-Spring-Flow-Experts-Voice/dp/159059584X)

### Struts
---

##### Tutorial

+ [Struts 2 Tutorial - JavaBrains](https://javabrains.io/courses?topic=struts2)

+ [Struts 2 Tutorial - Mkyong](http://www.mkyong.com/tutorials/struts-2-tutorials/)

##### Interview Question

+ [Struts 2 Interview Questions](https://itblackbelt.wordpress.com/2015/02/03/struts2-interview-questions-and-answers/)
 
##### Book

+ [Struts 2 in Action](http://www.amazon.in/Struts-2-Action-Donald-Brown/dp/8177228757?tag=googinhydr18418-21&tag=googinkenshoo-21&ascsubtag=3005f0ab-89e4-4958-8694-b99c6e9ea25e)
