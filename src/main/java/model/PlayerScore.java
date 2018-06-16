package model;

public class PlayerScore implements Comparable<PlayerScore>{
	
	private Integer id;
	private Float score;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Float getScore() {
		return score;
	}
	public void setScore(Float score) {
		this.score = score;
	}
	public PlayerScore() {
		super();
	}
	public PlayerScore(Integer id, Float score) {
		super();
		this.id = id;
		this.score = score;
	}
	@Override
	public String toString() {
		return "[id=" + id + ", score=" + score + "]";
	}
	@Override
	public int compareTo(PlayerScore ps) {
		return this.score > ps.score?1:((this.score < ps.score)?-1:0);
	}
	

}
