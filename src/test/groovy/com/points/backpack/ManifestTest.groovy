package com.points.backpack

import static org.junit.Assert.*
import org.junit.Test

import com.points.backpack.Cargo
import com.points.backpack.Manifest

class ManifestTest {
	private String testFile1 = "src/test/groovy/com/points/backpack/manifest1.txt"
	
	@Test
	public void testCreateManifest() {
		def cargoList = [new Cargo("box", 7, 20)]
		def manifest = new Manifest(30, cargoList)
		assertEquals(30, manifest.getWeightToLose())
		assertEquals(cargoList, manifest.getCargoAboardPlane())
	}
	
	@Test
	public void testCreateManifestInvalidWeight() {
		def cargoList = [new Cargo("box", 7, 20)]
		def manifest = new Manifest(-5, cargoList)
		assertEquals(0, manifest.getWeightToLose())
		assertEquals(cargoList, manifest.getCargoAboardPlane())
	}
	
	@Test
	public void testReadManifestFile() {
		def manifest = Manifest.readManifestFile(testFile1)
		assertEquals(1250, manifest.getWeightToLose())
		
		def manifestList = manifest.getCargoAboardPlane()
		assertEquals(10500, manifestList[0].getCost())		
	}

}
