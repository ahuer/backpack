package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo
import com.points.backpack.CargoCombo

class CargoComboTest {
	
	@Test
	public void testCargoComboTotalWeight() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(12, cargoCombo.getTotalWeight())
	}
	
	@Test
	public void testCargoComboTotalCost() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(75, cargoCombo.getTotalCost())
	}
	
	@Test
	public void testAddToCargoCombo() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		
		assertEquals(true, cargoCombo.addToCargoCombo(new Cargo("box", 4, 20)))
		assertEquals(16, cargoCombo.getTotalWeight())
		assertEquals(95, cargoCombo.getTotalCost())
	}

}