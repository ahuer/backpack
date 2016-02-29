package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo
import com.points.backpack.Manifest

class ManifestTest {
	private String testFile1 = "src/test/groovy/com/points/backpack/manifest1.txt"
	
	@Test
	public void testCreateManifest() {
		def cargoCombo = new CargoCombo(new Cargo("box", 7, 20))
		def manifest = new Manifest(30, cargoCombo)
		assertEquals(30, manifest.getWeightToLose())
		assertEquals(1, manifest.getCargoAboardPlane().size())
	}
	
	@Test
	public void testCreateManifestInvalidWeight() {
		def cargoCombo = new CargoCombo(new Cargo("box", 7, 20))
		def manifest = new Manifest(-5, cargoCombo)
		assertEquals(0, manifest.getWeightToLose())
	}
	
	@Test
	public void testReadManifestFile() {
		def manifest = Manifest.readManifestFile(testFile1)
		assertEquals(1250, manifest.getWeightToLose())
		
		def manifestList = manifest.getCargoAboardPlane()
		assertEquals(10500, manifestList[0].getCost())		
	}

}
