package cafeSBC;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UnitTest {
	Cafe sbc;
	
	@BeforeEach
	void init() {
		System.out.println("Chamei @Before");
		sbc = new Cafe();
	}
	
	@Test
	void testCase1() {
		sbc.setNumAndares(3);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);
		temp.add(30);
		sbc.setFuncionarios(temp);
		
		sbc.calculaTempoOtimo();
		assertEquals(80, sbc.getTempoOtimo());
		
		temp = sbc.getAndaresOtimos();
		assertEquals(2, temp.size());
		assertEquals(2, temp.get(0));
		assertEquals(3, temp.get(1));
		
	}
	
	@Test
	void testCase2() {
		sbc.setNumAndares(3);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10);
		temp.add(30);
		temp.add(20);
		sbc.setFuncionarios(temp);
		
		sbc.calculaTempoOtimo();
		assertEquals(60, sbc.getTempoOtimo());
		
		temp = sbc.getAndaresOtimos();
		assertEquals(1, temp.size());
		assertEquals(2, temp.get(0));	
	}
	
	@Test
	void testCase3() {
		sbc.setNumAndares(3);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(30);
		temp.add(10);
		temp.add(20);
		sbc.setFuncionarios(temp);
		
		sbc.calculaTempoOtimo();
		assertEquals(100, sbc.getTempoOtimo());
		
		temp = sbc.getAndaresOtimos();
		assertEquals(2, temp.size());
		assertEquals(1, temp.get(0));
		assertEquals(2, temp.get(1));	
	}
	
	@Test
	void testCase4() {
		sbc.setNumAndares(5);
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(80);
		temp.add(50);
		temp.add(10);
		temp.add(5);
		temp.add(15);
		sbc.setFuncionarios(temp);
		
		sbc.calculaTempoOtimo();
		assertEquals(290, sbc.getTempoOtimo());
		
		temp = sbc.getAndaresOtimos();
		assertEquals(2, temp.size());
		assertEquals(1, temp.get(0));
		assertEquals(2, temp.get(1));	
	}

}
