import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EntryTest {
	
	Entry entry = null;
	
	float[] grade = {80, 60, 42, 100, 70};
	float[] weight = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	float[] weight_1 = {0.1f, 0.2f, 0.1f, 0.3f, 0.3f};
	
	/** -------------------------------------
	 * Method setUp 
	 * this method will run before any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.new a Entry
	 * 2.設定grade
	 * -------------------------------------*/
	@Before
	public void setUp() throws Exception {
		entry = new Entry(123,"John");
		for (int i = 0; i < 5; i++)
			entry.setGrade(i, grade[i]);
	}
	
	/** -------------------------------------
	 * Method tearDown
	 * this method will run after any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.entry = null 
	 * --------------------------------------*/
	@After
	public void tearDown() throws Exception {
		entry = null;
	}
	
	/** -------------------------------------
	 * Unit test
	 * testSetGrade
	 * 
	 * case 1: 測試grade[0]是否被設為80
	 * case 2: 測試grade[1]是否被設為60
	 * -------------------------------------*/
	@Test
	public void testSetGrade() {
		assertEquals(80, entry.grade[0], 0.001);
		assertEquals(60, entry.grade[1], 0.001);
	}
	
	/** -------------------------------------
	 * Unit test
	 * testCalculateTotalGrade
	 * 
	 * case 1: weight = [0.1, 0.1, 0.1, 0.3, 0.4] grade = [80, 60, 42, 100, 70]
	 * case 2: weight = [0.1, 0.2, 0.1, 0.3, 0.3] grade = [80, 60, 42, 100, 70]
	 * -------------------------------------*/
	@Test
	public void testCalculateTotalGrade() {
		entry.calculateTotalGrade(weight);
		assertEquals(76.2f, entry.getTotalGrade(), 0.001);
		entry.calculateTotalGrade(weight_1);
		assertEquals(75.2f, entry.getTotalGrade(), 0.001);
	}
	
	/**
	 * Unit test
	 * testGetTotalGrade
	 * 
	 * @return
	 * 
	 * case 1: weight = [0.1, 0.1, 0.1, 0.3, 0.4] grade = [80, 60, 42, 100, 70]
	 * case 2: weight = [0.1, 0.2, 0.1, 0.3, 0.3] grade = [80, 60, 42, 100, 70]
	 */
	@Test
	public void testGetTotalGrade() {
		entry.calculateTotalGrade(weight);
		assertEquals(76.2f, entry.getTotalGrade(), 0.001);
		entry.calculateTotalGrade(weight_1);
		assertEquals(75.2f, entry.getTotalGrade(), 0.001);
	}
}
