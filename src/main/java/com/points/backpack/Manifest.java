package com.points.backpack;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Manifest {
	private int weightToLose;
	private CargoCombo cargoAboardPlane;
	
	private Manifest() {}
	
	public Manifest(int weightToLose, CargoCombo cargoAboardPlane) {
		this.weightToLose = weightToLose;
		this.cargoAboardPlane = cargoAboardPlane;
		
		if (weightToLose < 0 ) {
			this.weightToLose = 0;
		}
	}
	
	public List getCargoAboardPlane() {
		if (cargoAboardPlane == null ) {
			return null;
		}
		return cargoAboardPlane.getCargo();
	}
	
	public int getWeightToLose() {
		return weightToLose;
	}
	
	public static Manifest readManifestFile(String fileName) {
		int weightOverLimit = 0;
		List<Cargo> cargoList = new ArrayList<>();
		
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader (new File(fileName))) ) {
			String weightString = bufferedReader.readLine();
			
			if (weightString == null || weightString.isEmpty() ) {
				throw new IOException("Invalid weight to lose provided");
			}
			
			weightOverLimit = Integer.valueOf(weightString.trim());
			
			for (String line; (line = bufferedReader.readLine()) != null; ) {
				if (line.isEmpty() ) {
					continue;
				}
				
				String[] cargoInfo = line.split(" ", 3);
				
				if (cargoInfo.length < 3 ) {
					throw new IOException("Invalid number of arguments for cargo");
				}
				
				String sku = cargoInfo[0];
				int weight = Integer.valueOf(cargoInfo[1].trim());
				int cost = Integer.valueOf(cargoInfo[2].trim());
				cargoList.add(new Cargo(sku, weight, cost));
			}		
			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			return null;
		} catch (NumberFormatException ex) {
			System.out.println(ex.getMessage());
			return null;
		}
		
		return new Manifest(weightOverLimit, new CargoCombo(cargoList));
	}
	
	

}
