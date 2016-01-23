package freelance.poc.hibernate.ex1.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {

	private String locationName;
	private String locationDesc;

	// For JPA
	@SuppressWarnings("unused")
	private Address() {
		super();
	}

	public Address(String locationName, String locationDesc) {
		super();
		this.locationName = locationName;
		this.locationDesc = locationDesc;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	@Override
	public String toString() {
		return "Address [locationName=" + locationName + ", locationDesc=" + locationDesc + "]";
	}

}
