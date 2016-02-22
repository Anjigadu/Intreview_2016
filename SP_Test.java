import java.util.concurrent.Semaphore;

public class SP_Test {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		Pool pool = new Pool();

		System.out.println(pool.getItem());
		System.out.println(pool.getItem());
		System.out.println(pool.getItem());
		System.out.println(pool.getItem());

	}

}

class Pool {
	private static final int MAX_AVAILABLE = 3;
	private final Semaphore available = new Semaphore(MAX_AVAILABLE, true);

	public Object getItem() throws InterruptedException {
		available.acquire();
		return getNextAvailableItem();
	}

	public void putItem(Object x) {
		if (markAsUnused(x))
			available.release();
	}

	protected Object[] items = new Object[MAX_AVAILABLE];
	protected boolean[] used = new boolean[MAX_AVAILABLE];

	public Pool() {
		items[0] = 1;
		items[1] = 2;
		items[2] = 3;
	}

	protected synchronized Object getNextAvailableItem() {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (!used[i]) {
				used[i] = true;
				return items[i];
			}
		}
		return null; // not reached
	}

	protected synchronized boolean markAsUnused(Object item) {
		for (int i = 0; i < MAX_AVAILABLE; ++i) {
			if (item == items[i]) {
				if (used[i]) {
					used[i] = false;
					return true;
				} else
					return false;
			}
		}
		return false;
	}

}