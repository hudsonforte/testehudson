package com.texoit.testehudson.domain;

public class Producer {

	private static final long serialVersionUID = -2174229481834944548L;
	private String producer;
    private Long interval;
    private Long previousWin;
    private Long followingWin;
    
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Long getInterval() {
		return interval;
	}
	public void setInterval(Long interval) {
		this.interval = interval;
	}
	public Long getPreviousWin() {
		return previousWin;
	}
	public void setPreviousWin(Long previousWin) {
		this.previousWin = previousWin;
	}
	public Long getFollowingWin() {
		return followingWin;
	}
	public void setFollowingWin(Long followingWin) {
		this.followingWin = followingWin;
	}  
	
}