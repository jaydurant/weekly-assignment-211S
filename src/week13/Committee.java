package week13;

import java.time.LocalDate;

public class Committee {
	private final String name;
	private final int numMembers;
	private final Member committeeChair;
	private final LocalDate formationDate;

	
	public Committee(String name, int numMembers, Member committeeChair) {
		this.name = name;
		this.numMembers = numMembers;
		this.committeeChair = committeeChair;
	}

	public String getName() {
		return name;
	}

	public int getNumMembers() {
		return numMembers;
	}

	public Member getCommitteeChair() {
		Member returnMember = new Member(committeeChair.getFirstName(), committeeChair.getLastName(), committeeChair.getAge(), committee.getStatus());
		return committeeChair;
	}

	public LocalDate getFormationDate() {
		return formationDate;
	}
	
	

}
