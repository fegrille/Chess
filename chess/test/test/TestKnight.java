package test;

import model.Rook;

import org.junit.After;
import org.junit.Before;

public class TestKnight {

	Rook test;
	boolean testright;
	
	@Before
	public void setup() {
		test = new Rook(1,1,'b');
		testright = false;
		
	}
	
	/*@Test
	public void testPossibleMoves() {
		List<Integer[]> testfield = new ArrayList<Integer[]>();
		testfield = test.possibleFields();
		if(testfield.size() == 14) {
			testright = true;
		}
		assertTrue(testright);
	}*/
	
	
	@After
	public void tearDown() {
		test = null;
	}

}
