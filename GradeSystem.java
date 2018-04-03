import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GradeSystem {
	
	Entry currentEntry = null;
	GradeDatabase gd = null;
	
	/** -------------------------------------
	 * GradeSystem�غc�l
	 * 
	 * @throws FileNotFoundException
	 * 
	 * Pseudo code:
	 * 1. new a GradeDatabase
	 * -------------------------------------*/
	public GradeSystem() throws FileNotFoundException {
		gd = new GradeDatabase("gradeinput.txt");
	}
	
	/** -------------------------------------
	 * Method logIn
	 * �Q�ΨϥΪ̿�J��id��X�ҹ�����Entry�ðO���U��
	 * 
	 * @param id �ϥΪ̩ҿ�J��id
	 * @return �O�_����Ʀs�bDatabase
	 * 
	 * Pseudo code:
	 * 1.�j�MgradeDatabase���Ҧ�entry
	 * 2.���p����ơA�O�U�Өæ^��true
	 * 3.���p�S���AcurrentEntry = null�æ^��false
	 * 
	 * Time estimate: O(n)
	 * -------------------------------------*/
	public boolean logIn(int id) {
		for (Entry e : gd.entries){
			if (e.id == id){
				currentEntry = e;
				return true;
			}
		}
		currentEntry = null;
		return false;
	}
	
	/** -------------------------------------
	 * Method getCurrentUserName
	 * �����ϥΪ̦W��
	 * 
	 * @return currentEntry.name
	 * 
	 * Pseudo code:
	 * 1. return currentEntry.name
	 * 2. ���p�S���h�^�ǪŦr��
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public String getCurrentUserName() {	
		return currentEntry == null ? "" : currentEntry.name;
	}
	
	/** -------------------------------------
	 * Method printGrade
	 * ��ܥX���Z
	 * 
	 * Pseudo code:
	 * 1.�N�ϥΪ̹�����entry�̪���ƦL�X��
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public void printGrade() {
		System.out.format("%s���Z�Glab1:\t%s\n"
				+ "�@�@�@�@�@�@lab2:\t%s\n"
				+ "�@�@�@�@�@�@lab3:\t%s\n"
				+ "�@�@�@�@�@�@mid-term:\t%s\n"
    			+ "�@�@�@�@�@�@final exam:\t%s\n"
    			+ "�@�@�@�@�@�@total grade:\t%s\n", 
    			currentEntry.name, 
    			(int)currentEntry.grade[0] + (currentEntry.grade[0] >= 60 ? "" : "*"),
    			(int)currentEntry.grade[1] + (currentEntry.grade[1] >= 60 ? "" : "*"), 
    			(int)currentEntry.grade[2] + (currentEntry.grade[2] >= 60 ? "" : "*"),
    			(int)currentEntry.grade[3] + (currentEntry.grade[3] >= 60 ? "" : "*"), 
    			(int)currentEntry.grade[4] + (currentEntry.grade[4] >= 60 ? "" : "*"),
    			(int)Math.round(currentEntry.totalGrade)  + (Math.round(currentEntry.totalGrade) >= 60 ? "" : "*"));
	}
	
	/** -------------------------------------
	 * Method printRank
	 * ��ܥX�ƦW
	 * 
	 * Pseudo code:
	 * 1.�Nrank�]��1
	 * 2.���p���H���Z�����A�hrank++
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public void printRank() {
		int rank = 1;
		for (Entry e : gd.entries) {
			if(e.totalGrade > currentEntry.totalGrade) rank++;
		}
		System.out.format("%s");
	}
	
	public void printAverage() {
		
	}
	
	public void editWeight() {
		
	}
	
}
