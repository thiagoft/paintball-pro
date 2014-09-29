package br.com.paintball.model.entity;

public class Commands {
	
	private Integer medic;
	private Integer etec;
	private Integer suport;
	private Integer live;
	private Integer leaderCall;
	
	public Integer getMedic() {
		return medic;
	}
	public void setMedic(Integer medic) {
		this.medic = medic;
	}
	public Integer getEtec() {
		return etec;
	}
	public void setEtec(Integer etec) {
		this.etec = etec;
	}
	public Integer getSuport() {
		return suport;
	}
	public void setSuport(Integer suport) {
		this.suport = suport;
	}
	public Integer getLive() {
		return live;
	}
	public void setLive(Integer live) {
		this.live = live;
	}
	public Integer getLeaderCall() {
		return leaderCall;
	}
	public void setLeaderCall(Integer leaderCall) {
		this.leaderCall = leaderCall;
	}
	
	public Commands(Integer medic, Integer etec, Integer suport, Integer live,
			Integer leaderCall) {
		this.medic = medic;
		this.etec = etec;
		this.suport = suport;
		this.live = live;
		this.leaderCall = leaderCall;
	}

}
