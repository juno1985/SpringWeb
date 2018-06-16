package pthread;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;
@Component
public class FutureClient {

	private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public String request() {
		
		Thread producer = new Thread(new Runnable() {

			@Override
			public void run() {
				try {
					//调用时间作为任务队列的值
					MyQueue.getInstance().addElement(formatter.format(new Date()));
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		},"producer");
		
		producer.start();
		
		return "Sort request is being processed in backgroud";
	}
}
