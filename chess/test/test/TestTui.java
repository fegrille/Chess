package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.Tui;

public class TestTui {
	
	Tui test;

	@Before
	public void setUp() throws Exception {
		test = new Tui();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		
	}

}
