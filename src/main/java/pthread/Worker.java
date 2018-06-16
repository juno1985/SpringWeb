package pthread;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.beans.factory.annotation.Autowired;
import model.PlayerScore;
import mapper.PlayerScoreMapper;

public class Worker implements Runnable {

	private PlayerScoreMapper playerScoreMapper;
	
	private ConcurrentLinkedQueue<Task> workQueue;
	private ConcurrentHashMap<String, Object> resultMap;
	
	
	
	public Worker(PlayerScoreMapper playerScoreMapper) {
		this.playerScoreMapper = playerScoreMapper;
	}

	public void setWorkQueue(ConcurrentLinkedQueue<Task> workQueue) {
		this.workQueue = workQueue;
	}

	public void setResultMap(ConcurrentHashMap<String, Object> resultMap) {
		this.resultMap = resultMap;
	}
	
	@Override
	public void run() {
		while(true){
			Task input = this.workQueue.poll();
			if(input == null) break;
			List<PlayerScore> output = handle(input);
			this.resultMap.put(Integer.toString(input.getId()), output);
		}
	}

	private List<PlayerScore> handle(Task input) {
	
		List<PlayerScore> psList = playerScoreMapper.getPlayerScoresInRange(input.getStart(), input.getLength());
		
		System.out.println("worker: " + Thread.currentThread().getName());
		System.out.println("执行任务: " + input.getStart() + "->" + input.getLength());
		System.out.println(psList);
		System.out.println("----------------------------");

		Collections.sort(psList);
		return psList.subList(0, 10);
		
	}



}
