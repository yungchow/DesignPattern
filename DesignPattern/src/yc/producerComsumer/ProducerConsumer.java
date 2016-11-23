package yc.producerComsumer;

import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProducerConsumer {

	public static void main(String args[]) {
		Vector sharedQueue = new Vector();
		int size = 4;
		Thread t1 = new Thread(new Producer(sharedQueue, size), "Producer");
		Thread t2 = new Thread(new Consumer(sharedQueue, size), "Consumer");
		t1.start();
		t2.start();
	}
}

class Producer implements Runnable {
	private final Vector sharedQueue;
	private final int SIZE;

	public Producer(Vector sharedQueue, int size) {
		this.sharedQueue = sharedQueue;
		this.SIZE = size;
	}

	@Override
	public void run() {
		for (int i = 0; i < 7; i++) {
			System.out.println("Produce:" + i);
			try {
				produce(i);
			} catch (Exception e) {
				Logger.getLogger(Consumer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	public void produce(int i) throws InterruptedException {
		while (sharedQueue.size() == SIZE) {
			synchronized (sharedQueue) {
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting,size: "
						+ sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.add(i);
			sharedQueue.notifyAll();
		}
	}
}

class Consumer implements Runnable {
	private final Vector sharedQueue;
	private final int SIZE;

	public Consumer(Vector sharedVecotor, int size) {
		this.sharedQueue = sharedVecotor;
		this.SIZE = size;
	}

	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("Consumer" + consumer());
				Thread.sleep(50);
			} catch (InterruptedException e) {
				Logger.getLogger(Producer.class.getName()).log(Level.SEVERE, null, e);
			}
		}
	}

	private int consumer() throws InterruptedException {
		// waiting if queue is empty
		while (sharedQueue.isEmpty()) {
			synchronized (sharedQueue) {
				System.out.println("Queue is empty " + Thread.currentThread().getName() + " is waiting,size: "
						+ sharedQueue.size());
				sharedQueue.wait();
			}
		}
		synchronized (sharedQueue) {
			sharedQueue.notifyAll();
			return (Integer) sharedQueue.remove(0);
		}
	}
}
