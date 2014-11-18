package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControlEndGame;

public class TestControlEndGame {
	
	ControlEndGame test;

	@Before
	public void setUp() throws Exception {
		test = new ControlEndGame();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		
	}

}
