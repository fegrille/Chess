package view;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.ControlGame;
import view.Tui;

public class TestGui {
	
	Tui test;

	@Before
	public void setUp() throws Exception {
		test = new Tui(new ControlGame());
	}

	@After
	public void tearDown() throws Exception {
		test = null;
	}

	@Test
	public void test() {
		
	}

}
