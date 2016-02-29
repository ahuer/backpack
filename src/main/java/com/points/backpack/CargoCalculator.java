package com.points.backpack;

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
	
	public static void main(String[] args) {
		if (args.length < 1 || args.length > 1 ) {
			System.out.println("Invalid number of arguments provided. Please provide the manifest file location");
			System.exit(1);
		}
		
		Manifest manifest = Manifest.readManifestFile(args[0]);
		
		if (manifest == null ) {
			System.out.println("Invalid manifest");
			System.exit(1);
		}
		
		CargoCalculator calculator = new CargoCalculator(manifest);
		CargoCombo answer = calculator.calculateCargoToDrop();
		
		if (answer == null ) {
			System.out.println("Answer could not be calculated");
			System.exit(1);
		}
		
		int cost = answer.getTotalCost();
		System.out.printf("%d\n",cost);
		System.exit(0);
		
	}
	

}
