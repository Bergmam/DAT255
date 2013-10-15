package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import se.chalmers.dat255.risk.model.Province;

public class ProvinceTest {
	Province province= new Province("Thailand");
	
	@Test
	public void testProvince(){
		assertTrue(province.getId()=="Thailand");
		//assertTrue(province.getUnits()==1); //Later!!
	}
	
	@Test
	public void testAddUnits(){
		int provinceUnits = province.getUnits();
		province.addUnits(1);
		assertTrue(province.getUnits()==provinceUnits + 1);
		province.addUnits(10);
		assertTrue(province.getUnits()==provinceUnits + 11);
	}
	
	@Test
	public void testMoveUnits(){
		Province p1 = new Province("Moskva");
		int p1Units = p1.getUnits();
		int provinceUnits = province.getUnits();
		province.moveUnits(3, p1);
		assertTrue(p1.getUnits() == p1Units+3);
		assertTrue(province.getUnits() == provinceUnits - 3);
	}
	
	@Test
	public void testRemoveUnits(){
		int provinceUnits = province.getUnits();
		province.removeUnits(1);
		assertTrue(province.getUnits()==provinceUnits - 1);
		province.removeUnits(5);
		assertTrue(province.getUnits()==provinceUnits - 6);
	}

}
