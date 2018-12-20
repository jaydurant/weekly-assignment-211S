package midterm;

public class Volunteer {
	private String firstName, lastName, phone, groupName;

	public Volunteer(Builder builder) {
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.phone = builder.phone;
		this.groupName = builder.groupName;
	}
	
	public static class Builder{
		private String firstName, lastName, phone, groupName;
		
		public Builder() {
		}
		
		public Builder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}
		
		public Builder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}
		
		public Builder phone(String phone) {
			this.phone = phone;
			return this;
		}
		
		public Builder groupName(String groupName) {
			this.groupName = groupName;
			return this;
		}
		
		public Volunteer build() {
			Volunteer volunteer = new Volunteer(this);
			
			if (lastName == null || firstName == null) {
				throw new IllegalStateException();
			}
			
			return volunteer;
		}
		
	}

}
