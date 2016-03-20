
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
