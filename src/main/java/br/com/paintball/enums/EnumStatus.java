package br.com.paintball.enums;

public enum EnumStatus {
	ATIVO(1),
	INATIVO(0);
	
	private Integer status;
	  
	EnumStatus(Integer status){
		this.status = status;
	}
	
	public Integer getStatus(){
		return this.status;
	}
}
