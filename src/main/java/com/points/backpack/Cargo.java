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
	
}
