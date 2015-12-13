package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo

class CargoTest {
	
	@Test
	public void testCargoConstructorSetsValidData() {
		def cargo = new Cargo(null, -1, 0)
		assertEquals("CARGO", cargo.getSku())
		assertEquals(1, cargo.getWeight())
		assertEquals(1, cargo.getCost())
	}
	
	@Test
	public void testEquals() {
		def cargo1 = new Cargo("box", 7, 10)
		def cargo2 = new Cargo("box", 7, 10)
		def cargo3 = new Cargo("suitcase", 7, 10)
		assertEquals(cargo1, cargo2)
		assertNotEquals(cargo2, cargo3)
	}
	
}
