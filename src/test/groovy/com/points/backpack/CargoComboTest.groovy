package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo
import com.points.backpack.CargoCombo

class CargoComboTest {
	
	@Test
	public void testGetTotalWeight() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(12, cargoCombo.getTotalWeight())
	}
	
	@Test
	public void testGetTotalCost() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(75, cargoCombo.getTotalCost())
	}
	
	@Test
	public void testGetCargo() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(cargoList, cargoCombo.getCargo())
	}
	
	@Test
	public void testAddToCargoCombo() {
		def cargoCombo = new CargoCombo(new Cargo("bag", 5, 30))
		assertEquals(true, cargoCombo.addToCargoCombo(new Cargo("suitcase", 7, 45)))
		assertEquals(12, cargoCombo.getTotalWeight())
		assertEquals(75, cargoCombo.getTotalCost())
	}
	
	@Test
	public void testRemoveLastCargoItem() {
		def cargoList = [new Cargo("bag", 5, 30), new Cargo("suitcase", 7, 45)]
		def cargoCombo = new CargoCombo(cargoList)
		assertEquals(new Cargo("suitcase", 7, 45), cargoCombo.removeLastCargoItem())
	}

}