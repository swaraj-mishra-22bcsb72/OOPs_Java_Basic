class Student {
    private int studentId;
    private String studentName;
    private String residentialStatus;
    private long feesPerMonth;

    public Student(int studentId, String studentName, String residentialStatus, long semesterFees, long hostelFees) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.residentialStatus = residentialStatus;

        if (residentialStatus.equalsIgnoreCase("Hostelite")) {
            this.feesPerMonth = semesterFees + hostelFees;
        } else {
            this.feesPerMonth = semesterFees;
        }
    }

    public void setStudentId(int id) {
        this.studentId = id;
    }

    public void setStudentName(String firstName, String lastName) {
        this.studentName = firstName + " " + lastName;
    }

    public void setResidentialStatus(String status) {
        this.residentialStatus = status;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getResidentialStatus() {
        return residentialStatus;
    }

    public long getFees() {
        return feesPerMonth;
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            System.out.println("Please provide studentId, studentName, residentialStatus, semesterFees as arguments.");
            return;
        }

        int studentId = Integer.parseInt(args[0]);
        String studentName = args[1];
        String residentialStatus = args[2];
        long semesterFees = Long.parseLong(args[3]);
        long hostelFees = 0;

        if (residentialStatus.equalsIgnoreCase("Hostelite") && args.length >= 5) {
            hostelFees = Long.parseLong(args[4]);
        }

        Student student = new Student(studentId, studentName, residentialStatus, semesterFees, hostelFees);

        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Student Name: " + student.getStudentName());
        System.out.println("Residential Status: " + student.getResidentialStatus());
        System.out.println("Fees per Month: " + student.getFees());
    }
}
