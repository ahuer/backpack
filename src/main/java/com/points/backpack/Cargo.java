package com.points.backpack;

public class Cargo {
	private String sku;
	private int weight;
	private int cost;
	
	private Cargo() {}
	
	public Cargo(String sku, int weight, int cost ) {
		this.sku = sku;
		this.weight = weight;
		this.cost = cost;
		
		if (sku == null || sku.isEmpty() ) {
			this.sku = "CARGO";
		}
		
		if (weight <= 0 ) {
			this.weight = 1;
		}
		
		if (cost <= 0 ) {
			this.cost = 1;
		}
	}
	
	public String getSku() {
		return sku;
	}
	
	public int getWeight() {
		return weight;
	}
	
	public int getCost() {
		return cost;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null ) {
			return false;
		}
		if (getClass() != obj.getClass()) {
	        return false;
	    }
		
	    final Cargo c = (Cargo)obj;
		if (sku == c.sku && weight == c.weight && cost == c.cost ) {
			return true;
		}
		return false;
	}
	
}
