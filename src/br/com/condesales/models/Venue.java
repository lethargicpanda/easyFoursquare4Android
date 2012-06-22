package br.com.condesales.models;

public class Venue {

	private String id;

	private String name;

	private Location location;

	private Category[] categories;

	private boolean verified;

	private Statistics stats;

	private HereNow beenHere;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public Category[] getCategories() {
		return categories;
	}

	public boolean isVerified() {
		return verified;
	}

	public Statistics getStats() {
		return stats;
	}

	public HereNow getBeenHere() {
		return beenHere;
	}

}
