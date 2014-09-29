package enums;

public enum EnumClasses {
	ENGINEER(0),
	ETEC(1),
	MEDIC(2),
	SAM(3),
	SOLDIER(4),
	SQUAD_LEADER(5);
	
	private Integer classId;
	  
	EnumClasses(Integer classId){
		this.classId = classId;
	}
	
	public Integer getClassId(){
		return this.classId;
	}
}
