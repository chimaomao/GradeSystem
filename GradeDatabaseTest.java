import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.*;
import java.util.Scanner;

public class GradeDatabaseTest {
	
	GradeDatabase db = null;
	
	/** -------------------------------------
	 * Method setUp 
	 * this method will run before any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.new a GradeDatabase
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	@Before
	public void setUp() throws Exception {
		db = new GradeDatabase("gradeinput.txt");
	}

	/** -------------------------------------
	 * Method tearDown
	 * this method will run after any test method
	 * 
	 * @throws Exception
	 * 
	 * Pseudo code:
	 * 1.db = null
	 * 
	 * -------------------------------------*/
	@After
	public void tearDown() throws Exception {
		db = null;
	}
	
	/** -------------------------------------
	 * Unit test
	 * testGetEntry
	 * 
	 * case 1: 測試db.entries.size()是否不為 0
	 * case 2: 將所有Database的Entry皆比較過一次
	 * -------------------------------------*/
	@Test
	public void testGetEntry() throws FileNotFoundException{
		File file = new File("gradeinput.txt");
		Scanner scan = new Scanner(file, "UTF-8");
		scan.useDelimiter("[ \n\r]+");
		
		assertNotEquals(0,db.entries.size());
		for (int i = 0; i < db.entries.size(); i++) {
			assertEquals(scan.nextInt(),db.entries.get(i).id);
			assertEquals(scan.next(),db.entries.get(i).name);
			assertEquals(scan.nextInt(),(int)db.entries.get(i).grade[0]);
			assertEquals(scan.nextInt(),(int)db.entries.get(i).grade[1]);
			assertEquals(scan.nextInt(),(int)db.entries.get(i).grade[2]);
			assertEquals(scan.nextInt(),(int)db.entries.get(i).grade[3]);
			assertEquals(scan.nextInt(),(int)db.entries.get(i).grade[4]);
		}
		scan.close();
	}
}
