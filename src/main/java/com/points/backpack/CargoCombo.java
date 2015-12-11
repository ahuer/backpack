package com.points.backpack;

import java.util.ArrayList;
import java.util.List;

public class CargoCombo {
	private List<Cargo> cargoList;
	private int totalWeight;
	private int totalCost;
	
	private CargoCombo() {}
	
	public CargoCombo(Cargo cargo) {
		this.cargoList = new ArrayList<>();
		cargoList.add(cargo);
		updateTotalWeightAndCost();
	}
	
	public CargoCombo(List<Cargo> cargoList) {
		this.cargoList = cargoList;
		updateTotalWeightAndCost();
	}
	
	public boolean addToCargoCombo(Cargo cargo) {
		if (cargo == null ) {
			return false;
		}
		
		cargoList.add(cargo);
		totalWeight += cargo.getWeight();
		totalCost += cargo.getCost();
		return true;
	}
	
	private void updateTotalWeightAndCost() {
		totalWeight = cargoList.stream().mapToInt(c -> c.getWeight()).sum();
		totalCost = cargoList.stream().mapToInt(c -> c.getCost()).sum();
	}
	
	public int getTotalWeight() {
		return totalWeight;
	}
	
	public int getTotalCost() {
		return totalCost;
	}
}
