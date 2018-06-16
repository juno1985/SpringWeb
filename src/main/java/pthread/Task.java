package pthread;

public class Task {

	//任务号
	private Integer id;
	private Integer start;
	private Integer length;
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Task() {
		super();
	}
	public Task(Integer id, Integer start, Integer length) {
		super();
		this.id = id;
		this.start = start;
		this.length = length;
	}
	
}
