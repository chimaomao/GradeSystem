/** -------------------------------------
 * class Entry 儲存 id, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * Entry() 建構子
 * setGrade(index, grade) 設定成績 
 * calculateTotalGrade(weight) 計算加權後的分數
 * getTotalGrade() 拿totalGrade的值
 * -------------------------------------*/
public class Entry {
	int id;
	String name;
	float[] grade;
	float totalGrade;
	
	/** -------------------------------------
	 * Entry建構子
	 * 將參數id,name,grade做初始化 
	 * 
	 * @param id 設定id
	 * @param name 設定name
	 * -------------------------------------*/
	public Entry(int id, String name) {
		this.id = id;
		this.name = name;
		grade = new float[5]; 
	}
	
	/** -------------------------------------
	 * Method setGrade
	 * 設定某次考試grade的值 
	 * 
	 * @param index 代表第幾次考試
	 * @param grade 欲輸入之成績
	 * 
	 * Pseudo code:
	 * this.grade[index] = grade
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public void setGrade(int index, float grade) {
		this.grade[index] = grade;
	}
	
	/** -------------------------------------
	 * Method calculateTotalGrade
	 * 根據input的weight計算加權後的分數然後儲存到totalGrade
	 * 
	 * @param weight 分數權重的陣列
	 * 
	 * Pseudo code: 
	 * totalGrade := 0
	 *		for i from 0 to grade.length-1
	 *			totalGrade += grade[i] * weight[i]
	 *
	 * Time estimate: O(n)
	 * -------------------------------------*/
	public void calculateTotalGrade(float[] weight) {
		totalGrade = 0;
		for (int i = 0; i < grade.length; i++)
			totalGrade += grade[i] * weight[i];
	}
	
	/** -------------------------------------
	 * Method getTotalGrade
	 * 回傳 totalGrade的值  
	 * 
	 * @return totalGrade
	 * 
	 * Pseudo code:
	 * 1.return totalGrade
	 * 
	 * Time estimate: O(1)
	 * -------------------------------------*/
	public float getTotalGrade() {
		return totalGrade;
	}
 }
