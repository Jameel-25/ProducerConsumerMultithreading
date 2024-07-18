package producerConsumer;

public class Producer implements Runnable {

	private final SharedBuffer buffer;

	public Producer(SharedBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		int item = 0;
		while (true) {
			try {
				buffer.produce(item++);
				Thread.sleep(10); // Simulate time taken to produce an item
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

}
