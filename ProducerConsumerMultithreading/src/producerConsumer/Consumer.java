package producerConsumer;

public class Consumer implements Runnable {

	private final SharedBuffer buffer;

	public Consumer(SharedBuffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		while (true) {
			try {
				buffer.consume();
				Thread.sleep(1000); // Simulate time taken to consume an item
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
