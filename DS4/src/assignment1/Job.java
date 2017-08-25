package assignment1;

/**
 * ClassName  : Job
 * @author    : Vaishali Jain
 * Description: class containing the full details of each arrived job
 */
public class Job {
	//contains job documnet to be printed
	private String jobDocument;
	//contains priority of the job
	private int priority;
	//type of user requested to print the job
	private String userType;
	//job no of the job i.e time at which the job arrives
	private int jobNo;
	
	//parameterize constructor
	public Job(String jobDocument, int priority, String userType, int jobNo) {
		this.jobDocument = jobDocument;
		this.priority = priority;
		this.userType = userType;
		this.jobNo = jobNo;
	}
	
	//default constructor
	public Job(){
		
	}
	
	//getter to getJobDocument
	public String getJobDocument() {
		return jobDocument;
	}
	
	//setter to setJobDocument
	public void setJobDocument(String jobDocument) {
		this.jobDocument = jobDocument;
	}
	
	//getter to get priority of job
	public int getPriority() {
		return priority;
	}
	
	//setter to set priority of queue
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	//getter to get type of user
	public String getUserType() {
		return userType;
	}
	
	//setter to set user type
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	//getter to get job arrival number
	public int getJobNo() {
		return jobNo;
	}
	
	//setter to set job arrival number
	public void setJobNo(int jobNo) {
		this.jobNo = jobNo;
	}
	
	
}
