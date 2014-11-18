package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControlColidate;

public class TestControlColidate {
	
	ControlColidate test;

	@Before
	public void setUp() throws Exception {
		test = new ControlColidate();
		
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		
	}

}
