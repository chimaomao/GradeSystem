/** -------------------------------------
 * class Entry �x�s id, name, lab1, lab2, lab3, midTerm, finalExam, and totalGrade
 * 
 * Entry() �غc�l
 * setGrade(index, grade) �]�w���Z 
 * calculateTotalGrade(weight) �p��[�v�᪺����
 * getTotalGrade() ��totalGrade����
 * -------------------------------------*/
public class Entry {
	int id;
	String name;
	float[] grade;
	float totalGrade;
	
	/** -------------------------------------
	 * Entry�غc�l
	 * �N�Ѽ�id,name,grade����l�� 
	 * 
	 * @param id �]�wid
	 * @param name �]�wname
	 * -------------------------------------*/
	public Entry(int id, String name) {
		this.id = id;
		this.name = name;
		grade = new float[5]; 
	}
	
	/** -------------------------------------
	 * Method setGrade
	 * �]�w�Y���Ҹ�grade���� 
	 * 
	 * @param index �N��ĴX���Ҹ�
	 * @param grade ����J�����Z
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
	 * �ھ�input��weight�p��[�v�᪺���ƵM���x�s��totalGrade
	 * 
	 * @param weight �����v�����}�C
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
	 * �^�� totalGrade����  
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
