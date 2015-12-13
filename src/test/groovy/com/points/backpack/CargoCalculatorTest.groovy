package com.points.backpack

import static org.junit.Assert.*

import org.junit.Test

import com.points.backpack.*

class CargoCalculatorTest {
	private String testFile1 = "src/test/groovy/com/points/backpack/manifest1.txt"
	
	@Test 
	public void testCalculatorWithValidData() {
		def manifest = Manifest.readManifestFile(testFile1)
		def calculator = new CargoCalculator(manifest)
		def combo = calculator.calculateCargoToDrop()
		assertEquals(9500, combo.getTotalCost())
		assertEquals(1400, combo.getTotalWeight())
	}
	
	@Test
	public void testCalculatorWithNullManifest() {
		def calculator = new CargoCalculator(null)
		assertEquals(null, calculator.calculateCargoToDrop())
	}
	
	@Test
	public void testCalculatorWithNullCargoCombo() {
		def manifest = new Manifest(700, null)
		def calculator = new CargoCalculator(manifest)
		assertEquals(null, calculator.calculateCargoToDrop())
	}
	
	@Test
	public void testCalculatorWithNullCargo() {
		def manifest = new Manifest(700, new CargoCombo(null))
		def calculator = new CargoCalculator(manifest)
		assertEquals(null, calculator.calculateCargoToDrop())
	}

}
