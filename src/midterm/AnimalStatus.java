package midterm;

public enum AnimalStatus {
	NEW_UNDEREVALUATION("NEW_UNDEREVALUATION"),
	TEMP_RESIDENT("TEMP_RESDIENT"),
	PERM_RESIDENT("PERM_RESIDENT");
	
	private String status;
	private boolean adoptionStatus;
	
	private AnimalStatus(String status) {
		this.status = status;
		this.adoptionStatus = this.processAdoptionStatus();
	}
	
	private boolean processAdoptionStatus() {
		boolean adoptionResult = false;
		switch(this) {
			case PERM_RESIDENT:
				adoptionResult = false;
				break;
			case TEMP_RESIDENT:
			case NEW_UNDEREVALUATION:
				adoptionResult = true;
				break;
		}
		
		return adoptionResult;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public boolean getAdoptionStatus() {
		return this.adoptionStatus;
	}
}
