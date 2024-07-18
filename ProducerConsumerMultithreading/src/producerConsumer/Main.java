package producerConsumer;

public class Main {

	public static void main(String[] args) {
		SharedBuffer buffer = new SharedBuffer(10); // Buffer capacity is 5
		Thread producerThread = new Thread(new Producer(buffer), "Producer");
		Thread consumerThread = new Thread(new Consumer(buffer), "Consumer");

		producerThread.start();
		consumerThread.start();
	}
}
