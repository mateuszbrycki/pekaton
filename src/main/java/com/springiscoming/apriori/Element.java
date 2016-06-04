package com.springiscoming.apriori; /**
 * Reprezentuje element transakcji
 * 
 */
public class Element {

	private String value;

	/**
	 * @param value string representation of the item
	 */
	public Element(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}

	public boolean equals(Object o) {
		return ((Element) o).value.equals(this.value);
	}

	public int hashCode() {
		return this.value.hashCode();
	}

	@Override
	public String toString()
	{
		return this.value.toString();
	}

}
