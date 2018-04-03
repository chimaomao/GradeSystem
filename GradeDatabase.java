import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
/** -------------------------------------
 * class GradeDatabase 儲存所有的Entry
 * 
 * GradeDatabase(filname) 建構子
 * getEntry(index) 
 * -------------------------------------*/
public class GradeDatabase {
	List<Entry> entries;
	float[] weight = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	
	/** -------------------------------------
	 * GradeDatabase 建構子 
	 * 利用傳進來的filename讀取資料，然後放入entry
	 * 並且maintain所有的entries
	 * 
	 * @param filename 傳入檔案名稱 
	 * @throws FileNotFoundException 
	 * 
	 * Pseudo code:
	 * 1.看看是否file還有下一行，假如有繼續掃描
	 * 2.掃描每一行中的資料並儲存起來
	 * 3.將儲存的資料計算加權平均
	 * 
	 * Time estimate: O(n)
	 * -------------------------------------*/
	
	public GradeDatabase(String filname) throws FileNotFoundException{
		File file = new File("gradeinput.txt");
		Scanner scan = new Scanner(file,"UTF-8");
		entries = new ArrayList<Entry>(); 

		scan.useDelimiter("[ \n\r]+");
		
		while(scan.hasNext()) {
			Entry e = new Entry(scan.nextInt(),scan.next());
			for(int i = 0; i < 5; i++) {
				e.grade[i] = scan.nextInt();
			}
			e.calculateTotalGrade(weight);
			entries.add(e);
		}	
		scan.close();
	}
	
	/** -------------------------------------
	 * Method getEntry
	 * 利用index選擇出所需要的entry然後回傳
	 * 
	 * @param index 用index選entry
	 * @return
	 * 
	 * Pseudo code:
	 * 1.return entries[index] 
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/

	public Entry getEntry(int index) {
		return  entries.get(index);
	}	
}
