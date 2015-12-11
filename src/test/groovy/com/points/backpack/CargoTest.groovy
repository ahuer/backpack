package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo

class CargoTest {
	
	@Test
	public void testCargoConstructorSetValidData() {
		def cargo = new Cargo(null, -1, 0)
		assertEquals("CARGO", cargo.getSku())
		assertEquals(1, cargo.getWeight())
		assertEquals(1, cargo.getCost())
	}
	
}
