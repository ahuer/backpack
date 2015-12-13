package com.points.backpack;

import java.util.ArrayList;
import java.util.List;

public class CargoCalculator {
	private CargoCombo cargoCandidate;
	private Manifest manifest;
	private List<Cargo> cargoAboardPlane;
	private CargoCombo currentCombo;
	
	private CargoCalculator() {}
	
	public CargoCalculator(Manifest manifest) {
		this.manifest = manifest;
	}
	
	public CargoCombo calculateCargoToDrop() {
		if (manifest == null ) {
			return null;
		}
		
		cargoAboardPlane = manifest.getCargoAboardPlane();
		
		if (cargoAboardPlane == null || cargoAboardPlane.size() < 1 ) {
			return null;
		}
		
		currentCombo = new CargoCombo(cargoAboardPlane.get(0));
		
		return recursiveCalcuate();
	}
	
	private CargoCombo recursiveCalcuate() {
		
		if (currentCombo.getCargo().isEmpty() ) {
			return cargoCandidate;
		}
		
		if (cargoCandidate != null && currentCombo.getTotalCost() > cargoCandidate.getTotalCost() ) {
			popAndAddNext(true);
			recursiveCalcuate();
		}
		
		if (currentCombo.getTotalWeight() > manifest.getWeightToLose() ) {
			if (cargoCandidate == null ) {
				cargoCandidate = new CargoCombo(currentCombo.getCargo());
			}
			
			if (currentCombo.getTotalCost() < cargoCandidate.getTotalCost() ) {
				cargoCandidate = new CargoCombo(currentCombo.getCargo());
			}
			popAndAddNext(true);
			recursiveCalcuate();
		}
		
		popAndAddNext(false);
		recursiveCalcuate();
		
		return cargoCandidate;
	}
	
	private void popAndAddNext(boolean doPop) {
		if (currentCombo == null || currentCombo.getCargo() == null || currentCombo.getCargo().isEmpty() ) {
			return;
		}
		
		int nextCargoIndex;
		
		if (doPop ) {
			Cargo lastItem = currentCombo.removeLastCargoItem();
			nextCargoIndex = cargoAboardPlane.indexOf(lastItem) + 1;
		} else {
			List<Cargo> cargoList = currentCombo.getCargo();
			Cargo lastItem = cargoList.get(cargoList.size() - 1);
			nextCargoIndex = cargoAboardPlane.indexOf(lastItem);
		}		
				
		if (nextCargoIndex < cargoAboardPlane.size() ) {
			currentCombo.addToCargoCombo(cargoAboardPlane.get(nextCargoIndex));
		} else {
			popAndAddNext(true);
		}
	}
	

}
