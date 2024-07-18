package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;

/*
 * In the Producer-Consuer problem, two
 * types of threads share a common buffer: 
 * producers and consumers. Producers 
 * add items to the buffer, while consumers
 * remove items from the buffer. The 
 * problem is to ensure that producers do 
 * not add to a full buffer and consumers
 * do not remove from an empty buffer,
 * using synchronization to coordinate their 
 * actions.
 */

public class SharedBuffer {

	private final int capacity;
	private final Queue<Integer> buffer = new LinkedList<Integer>();

	public SharedBuffer(int capacity) {
		this.capacity = capacity;
	}

	public synchronized void produce(int item) throws InterruptedException {
		while (buffer.size() == capacity) {
			wait(); // Wait until there is space in the buffer
		}
		buffer.add(item);
		System.out.println("Produced: " + item);
		notifyAll(); // Notify consumers that new item is available
	}

	public synchronized int consume() throws InterruptedException {
		while (buffer.isEmpty()) {
			wait();// Wait until there is an item in the buffer
		}
		int item = buffer.poll();
		System.out.println("Consumed: " + item);
		notifyAll(); // Notify producers that space is available in the buffer
		return item;
	}
}
