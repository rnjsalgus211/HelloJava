package co.gui.dao;

public class EmployeeVO { //value Object 
	private int employeeId;
	private String fristName;
	private String lastName;
	private String email;
	private String hireDate;
	private String jobId;
	
	
	public EmployeeVO(int employeeId, String fristName, String lastName, String email, String hireDate, String jobId) {
		super();
		this.employeeId = employeeId;
		this.fristName = fristName;
		this.lastName = lastName;
		this.email = email;
		this.hireDate = hireDate;
		this.jobId = jobId;
	}


	public int getEmployeeId() {
		return employeeId;
	}


	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}


	public String getFristName() {
		return fristName;
	}


	public void setFristName(String fristName) {
		this.fristName = fristName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHireDate() {
		return hireDate;
	}


	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}


	public String getJobId() {
		return jobId;
	}


	public void setJobId(String jobId) {
		this.jobId = jobId;
	}


	@Override
	public String toString() {
		return "EmployeeVO [employeeId=" + employeeId + ", fristName=" + fristName + ", lastName=" + lastName
				+ ", email=" + email + ", hireDate=" + hireDate + ", jobId=" + jobId + "]";
	}
	
	

}
