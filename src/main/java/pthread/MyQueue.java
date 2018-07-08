package pthread;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

	// 队列最少为0
	private final int min = 0;
	// 队列最大可以通过构造器赋值
	private final int max = 2;
	// 记录队列中元素个数,保证自增或自减的原子操作
	private AtomicInteger count = new AtomicInteger(0);
	// 队列内存储的元素
	private final LinkedList<String> eArray;
	// 消费者和生产者使用的锁
	private final Object obj = new Object();

	// 懒汉的单列模式
	private static MyQueue myQueue = null;
	@SuppressWarnings("unused")
	public static MyQueue getInstance() {
		if (myQueue == null) {
			myQueue = new MyQueue();
		}
		return myQueue;
	}
	
	private MyQueue() {

		eArray = new LinkedList<String>();
	}
	public LinkedList<String> addElement(String e) throws InterruptedException {
		synchronized (obj) {
			if (count.get() == max) {
//				obj.wait();
				System.out.println("任务槽已满,拒绝任务提交");
				return null;
			}
			// 如果能跳出循环说明队列元素个数小于max
			eArray.add(e);
			count.incrementAndGet();
			System.out.println("任务入队列: " + e);
			System.out.println("当前任务队列长度: " + count.get());
			// 通知消费者
			obj.notify();
			return eArray;
		}
	}

	public String takeAnElement() throws InterruptedException {
		synchronized (obj) {
			while (count.get() == min) {
				obj.wait();
			}
			// 如果跳出循环说明队列中有元素可取
			String e = eArray.removeFirst();
			count.decrementAndGet();
			System.out.println("任务出队列: " + e);
			System.out.println("当前任务队列长度: " + count.get());
			// 通知生产者
//			obj.notify();
			return e;
		}
	}

}
