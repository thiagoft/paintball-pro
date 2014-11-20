package br.com.paintball.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COMMAND")
public class Commands {
	
	private Long commandId;
	private Integer medic;
	private Integer etec;
	private Integer suport;
	private Integer live;
	private Integer leaderCall;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
    @Column(name = "CD_COMMAND", unique = true, nullable = false, precision = 11, scale = 0)
	public Long getCommandId() {
		return commandId;
	}
	
	@Column(name = "FG_MEDIC", nullable = false, precision = 1, scale = 0)
	public Integer getMedic() {
		return medic;
	}
	
	public void setMedic(Integer medic) {
		this.medic = medic;
	}
	
	@Column(name = "FG_ETEC", nullable = false, precision = 1, scale = 0)
	public Integer getEtec() {
		return etec;
	}
	
	public void setEtec(Integer etec) {
		this.etec = etec;
	}
	
	@Column(name = "FG_SUPORT", nullable = false, precision = 1, scale = 0)
	public Integer getSuport() {
		return suport;
	}
	
	public void setSuport(Integer suport) {
		this.suport = suport;
	}
	
	@Column(name = "FG_LIVE", nullable = false, precision = 1, scale = 0)
	public Integer getLive() {
		return live;
	}
	
	public void setLive(Integer live) {
		this.live = live;
	}
	
	@Column(name = "FG_LEADER_CALL", nullable = false, precision = 1, scale = 0)
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
	
	public Commands(){}

}
