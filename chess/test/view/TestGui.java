package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import view.Gui;

public class TestGui {
	
	Gui test;

	@Before
	public void setUp() throws Exception {
		test = new Gui();
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		
	}

}
