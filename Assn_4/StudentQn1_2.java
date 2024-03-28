class Student{
	int studentId;
	char studentType;
	String studentName;
	
	static int studentCount = 0;
	static{
		studentCount = 10;
	}
	
	Student(){
		studentId = studentCount+550;
		studentName = null;
		++studentCount;
	}
	Student(String firstName, String lastName, char studentType){
		this.studentId = studentCount+550;
		this.studentName = firstName+" "+lastName;
		this.studentType = studentType;
		++studentCount;
	}
	
	void displayStudentDetails(Student current){
		System.out.println("{");
		System.out.println("\tStudent Id : " +current.studentId);
		System.out.println("\tStudent Name : " +current.studentName);
		System.out.println("\tStudent Type : " +current.studentType);
		System.out.println("}");
	}
	
	static int getStudentCount(){
		return studentCount;
	}
}
class Driver{
	public static void main(String[] args){
		Student one = new Student("Bony", "Thomas", 'D');
		one.displayStudentDetails(one);
		Student two = new Student("Dinil", "Bose", 'H');
		two.displayStudentDetails(two);
		
		System.out.println(Student.getStudentCount());
	}
}