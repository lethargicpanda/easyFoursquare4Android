package br.com.condesales.models;

public class Category {

	private String id;

	private String name;

	private String pluralName;

	//private String icon;

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getPluralName() {
		return pluralName;
	}

//	public String getIcon() {
//		return icon;
//	}

	public String[] getParents() {
		return parents;
	}

	public boolean isPrimary() {
		return primary;
	}

	private String[] parents;

	private boolean primary;

}
