package br.com.condesales.models;

public class Checkin {

	public int count;

	public String id;

	public long createdAt;

	public String type;

	public String timeZone;

	public long timeZoneOffset;

	public Venue venue;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(long createdAt) {
		this.createdAt = createdAt;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public long getTimeZoneOffset() {
		return timeZoneOffset;
	}

	public void setTimeZoneOffset(long timeZoneOffset) {
		this.timeZoneOffset = timeZoneOffset;
	}

	public Venue getVenue() {
		return venue;
	}

	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
