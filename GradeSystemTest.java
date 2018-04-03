import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradeSystemTest {

	GradeSystem gs = null;
	
	/** -------------------------------------
	 * Method setUp
	 * this method will run before any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.new a GradeSystem;
	 * -------------------------------------*/
	@Before
	public void setUp() throws Exception {
		gs = new GradeSystem();
	}
	
	/** -------------------------------------
	 * Method tearDown
	 * this method will run after any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.gs = null
	 * -------------------------------------*/
	@After
	public void tearDown() throws Exception {
		gs = null;
	}
	
	/** -------------------------------------
	 * Unit test
	 * testLogIn
	 * 
	 * case 1: 955002056 測試存在於database的id
	 * case 2: 123456789 測試不存在於database的id  
	 * -------------------------------------*/
	@Test
	public void testLogIn() {
		assertEquals(true, gs.logIn(955002056));
		assertEquals(955002056, gs.currentEntry.id);
		assertEquals(false, gs.logIn(123456789));
		assertEquals(null, gs.currentEntry);
	}
	
	/** ------------------------------------- 
	 * Unit test
	 * testCurrentUserName
	 * 
	 * case 1: 955002056 測試存在於database的id
	 * case 2: 123456789 測試不存在於database的id
	 * -------------------------------------*/
	@Test
	public void testCurrentUserName() {
		gs.logIn(955002056);
		assertEquals("許文馨", gs.getCurrentUserName());
		gs.logIn(123456789);
		assertEquals("", gs.getCurrentUserName());
	}
	
	/**
	 * Unit test
	 * testPrintGrade
	 * 
	 * case 1: 955002056 許文馨的成績
	 * case 2: 
	 */
	@Test
	public void testPrintGrade() {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream ps = new PrintStream(baos);
	    PrintStream old = System.out;
	    System.setOut(ps);
	    gs.logIn(955002056);
	    gs.printGrade();
	    
	    assertEquals("許文馨成績：lab1:\t88\n"
				+ "　　　　　　lab2:\t92\n"
				+ "　　　　　　lab3:\t88\n"
				+ "　　　　　　mid-term:\t98\n"
    			+ "　　　　　　final exam:\t91\n"
    			+ "　　　　　　total grade:\t93\n", baos.toString());
	    
	    System.out.flush();
	    System.setOut(old);
	}
	@Test
	public void testPrintRank() {
		fail("Not yet implemented");
	}
	@Test
	public void testPrintAverage() {
		fail("Not yet implemented");
	}
	@Test
	public void testEditWeight() {
		fail("Not yet implemented");
	}

}
