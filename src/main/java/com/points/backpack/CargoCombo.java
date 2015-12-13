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
		if (cargo != null ) {
			cargoList.add(cargo);
			updateTotalWeightAndCost();
		}		
	}
	
	public CargoCombo(List<Cargo> cargoList) {
		this.cargoList = cargoList;
		if (cargoList == null ) {
			this.cargoList = new ArrayList<>();
		}
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
	
	public Cargo removeLastCargoItem() {
		if (cargoList == null || cargoList.isEmpty() ) {
			return null;
		}
		
		Cargo item = cargoList.remove(cargoList.size() - 1);
		totalWeight -= item.getWeight();
		totalCost -= item.getCost();
		return item;
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
	
	public List getCargo() {
		return cargoList;
	}
}
