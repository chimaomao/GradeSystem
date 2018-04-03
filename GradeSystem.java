import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class GradeSystem {
	
	Entry currentEntry = null;
	GradeDatabase gd = null;
	
	/** -------------------------------------
	 * GradeSystem建構子
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
	 * 利用使用者輸入的id找出所對應之Entry並記錄下來
	 * 
	 * @param id 使用者所輸入之id
	 * @return 是否有資料存在Database
	 * 
	 * Pseudo code:
	 * 1.搜尋gradeDatabase的所有entry
	 * 2.假如有資料，記下來並回傳true
	 * 3.假如沒有，currentEntry = null並回傳false
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
	 * 拿取使用者名稱
	 * 
	 * @return currentEntry.name
	 * 
	 * Pseudo code:
	 * 1. return currentEntry.name
	 * 2. 假如沒有則回傳空字串
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public String getCurrentUserName() {	
		return currentEntry == null ? "" : currentEntry.name;
	}
	
	/** -------------------------------------
	 * Method printGrade
	 * 顯示出成績
	 * 
	 * Pseudo code:
	 * 1.將使用者對應到entry裡的資料印出來
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public void printGrade() {
		System.out.format("%s成績：lab1:\t%s\n"
				+ "　　　　　　lab2:\t%s\n"
				+ "　　　　　　lab3:\t%s\n"
				+ "　　　　　　mid-term:\t%s\n"
    			+ "　　　　　　final exam:\t%s\n"
    			+ "　　　　　　total grade:\t%s\n", 
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
	 * 顯示出排名
	 * 
	 * Pseudo code:
	 * 1.將rank設為1
	 * 2.假如有人成績較高，則rank++
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
