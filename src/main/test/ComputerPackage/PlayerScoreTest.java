package ComputerPackage;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import mapper.PlayerScoreMapper;
import model.PlayerScore;
import pthread.Master;
import pthread.MyQueue;
import pthread.Task;
import pthread.Worker;
import service.PlayerScoreService;

@RunWith(SpringJUnit4ClassRunner.class)
// 加载spring的配置文件和mybatis的配置文件
@ContextConfiguration({ "classpath:/spring/spring.xml", "classpath:/spring/spring-mybatis.xml" })
public class PlayerScoreTest {

	@Autowired
	private PlayerScoreService playerScoreService;

	@Autowired
	private PlayerScoreMapper playerScoreMapper;

	@Test
	public void testGetPlayerScoreSorted() throws InterruptedException {
		for(int i = 1; i < 5; i++) {
			playerScoreService.getSortedResult();
			Thread.sleep(5000);
		}
		while(true) {
			Thread.sleep(5000);
			MyQueue.getInstance().takeAnElement();
			System.out.println("消费者取任务");
			ConsumerProcess();
		}
		
	}

	public void ConsumerProcess() {
		// 10个worker
		Master master = new Master(new Worker(playerScoreMapper), 10);
		// 创建任务
		for (int i = 1; i <= 100; i++) {
			Task t = new Task(i, (i - 1) * 100, 100);
			master.submit(t);
		}
		master.execute();

		while (true) {

			if (master.isComplete()) {
				List<PlayerScore> result = master.getResult();
				System.out.println("最终结果：" + result);
				break;
			}
		}
	}
}
