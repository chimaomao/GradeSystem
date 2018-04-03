import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;
/** -------------------------------------
 * class GradeDatabase �x�s�Ҧ���Entry
 * 
 * GradeDatabase(filname) �غc�l
 * getEntry(index) 
 * -------------------------------------*/
public class GradeDatabase {
	List<Entry> entries;
	float[] weight = {0.1f, 0.1f, 0.1f, 0.3f, 0.4f};
	
	/** -------------------------------------
	 * GradeDatabase �غc�l 
	 * �Q�ζǶi�Ӫ�filenameŪ����ơA�M���Jentry
	 * �åBmaintain�Ҧ���entries
	 * 
	 * @param filename �ǤJ�ɮצW�� 
	 * @throws FileNotFoundException 
	 * 
	 * Pseudo code:
	 * 1.�ݬݬO�_file�٦��U�@��A���p���~�򱽴y
	 * 2.���y�C�@�椤����ƨ��x�s�_��
	 * 3.�N�x�s����ƭp��[�v����
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
	 * �Q��index��ܥX�һݭn��entry�M��^��
	 * 
	 * @param index ��index��entry
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
