package com.points.backpack;

import java.util.List;
import java.util.Stack;

public class CargoCalculator {
	private CargoCombo cargoCandidate;
	private Manifest manifest;
	private List<Cargo> cargoAboardPlane;
	
	private CargoCalculator() {}
	
	public CargoCalculator(Manifest manifest) {
		this.manifest = manifest;
	}
	
	public CargoCombo calculateCargoToDrop() {
		if (manifest == null ) {
			return null;
		}
		
		cargoAboardPlane = manifest.getCargoAboardPlane();
		
		if (cargoAboardPlane == null ) {
			return null;
		}
		
		CargoCombo currentCargo = new CargoCombo(cargoAboardPlane.get(0));
		
		return recursiveCalcuate(currentCargo);
	}
	
	private CargoCombo recursiveCalcuate(CargoCombo currentCargo) {
		
		 
		/* for (Cargo item : cargoAboard ) {
			if (cargoComboStack.isEmpty() ) {			
				cargoComboStack.push(new CargoCombo(item));
			}
			
			CargoCombo newCombo = cargoComboStack.peek();
			newCombo.addToCargoCombo(item);
			
			if (newCombo.getTotalWeight() > manifest.getWeightToLose() ) {
				if (cargoToDrop == null ) {
					cargoToDrop = newCombo;
				}
				
				if (newCombo.getTotalCost() < cargoToDrop.getTotalCost() ) {
					cargoToDrop = newCombo;
				}
				continue;
			}
			cargoComboStack.push(newCombo);
			recursiveCalcuate(cargoAboard, cargoComboStack);
		}
		*/
		return null;
	}
	

}
