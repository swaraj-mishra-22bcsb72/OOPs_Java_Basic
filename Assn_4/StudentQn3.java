class Student{
	int studentId;
	char studentType;
	String studentName;
	String residentialStatus;
	double feesPerMonth;
	
	static int studentCount = 0;
	static double semesterFees = 150000.0;
	static double hostelFees = 3200.0;
	
	Student(){
		studentId = studentCount++ +550;
		studentName = null;
	}
	Student(String firstName, String lastName, char studentType){
		this.studentId = studentCount++ +550;
		this.studentName = firstName+" "+lastName;
		this.studentType = studentType;
	}
	void calculateFees(double semesterFees){
		feesPerMonth = semesterFees / 6.0;
	}
	void calculateFees(double semesterFees, double hostelFees){
		feesPerMonth = semesterFees / 6.0;
		feesPerMonth = feesPerMonth+ hostelFees;
	}
	void setStudentId(int studentId){
		this.studentId = studentId;
	}
	void setStudentType(char studentType){
		this.studentType = studentType;
	}
	void setStudentName(String firstName,String lastName){
		this.studentName = studentName;
	}
	void setResidentialStatus(String residentialStatus){
		this.residentialStatus = residentialStatus;
	}
	int getStudentId(){
		return studentId;
	}
	char getStudentType(){
		return studentType;
	}
	String getStudentName(){
		return studentName;
	}
	String getResidentialStatus(){
		return residentialStatus;
	}
	double getFees(){
		return feesPerMonth;
	}
	void displayStudentDetails(Student current){
		System.out.println("{");
		System.out.println("\tStudent Id : " +current.studentId);
		System.out.println("\tStudent Name : " +current.studentName);
		System.out.println("\tStudent Type : " +current.studentType);
		System.out.println("\tResidential Status : " +residentialStatus);
		System.out.println("\tFees/Month : " +feesPerMonth);
		System.out.println("}");
	}
	
	int getStudentCount(){
		return studentCount;
	}
}
class Driver{
	public static void main(String[] args){
		/*
		Student one = new Student("Bony", "Thomas", 'H');
		one.setResidentialStatus("Day Scholar");
		one.setStudentType('D');
		if (one.getResidentialStatus().equalsIgnoreCase("Day Scholar")){
			one.calculateFees(Student.semesterFees);
			
		}
		else{
			one.calculateFees(Student.semesterFees, Student.hostelFees);
			
		}
		System.out.println(one.getStudentId());
		System.out.println(one.getStudentName());
		System.out.println(one.getStudentType());
		System.out.println(one.getResidentialStatus());
		System.out.println(one.getFees());
		//one.displayStudentDetails(one);
		*/
		Student one = new Student("Raju", "Thomas", 'D');
		one.setResidentialStatus("Day Scholar");
		one.setStudentType('D');
		if (one.getResidentialStatus().equalsIgnoreCase("Hostelite")){
			one.calculateFees(Student.semesterFees);
			
		}
		else{
			one.calculateFees(Student.semesterFees, Student.hostelFees);
			
		}
		System.out.println(one.getStudentId());
		System.out.println(one.getStudentName());
		System.out.println(one.getStudentType());
		System.out.println(one.getResidentialStatus());
		System.out.println(one.getFees());
		//one.displayStudentDetails(one);
	}
}