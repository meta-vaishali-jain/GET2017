package assignment1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.TimeZone;

/**
 * ClassName  : PriorityQueue
 * @author    : Vaishali Jain
 * Description: Class implementing queue on the basis of priority of the jobs
 */
public class PriorityQueue {
	private Job[] priorityWiseJob;
	private static final int DEFAULT_SIZE = 5;
	private int numberOfJobs;
	private int queueSize;
	
	//default constructor
	public PriorityQueue(){
		priorityWiseJob=new Job[DEFAULT_SIZE];
		numberOfJobs=0;
		queueSize=0;
	}
	
	//getter to get all jobs priority wise
	public Job[] getPriorityWiseJob() {
		return priorityWiseJob;
	}
	
	//setter to set job array
	public void setPriorityWiseJob(Job[] priorityWiseJob) {
		this.priorityWiseJob = priorityWiseJob;
	}
	
	//getter to get number  of the job arrival
	public int getNumberOfJobs() {
		return numberOfJobs;
	}
	
	//setter to set number of the job arrival
	public void setNumberOfJobs(int numberOfJobs) {
		this.numberOfJobs = numberOfJobs;
	}

	public static int getDefaultSize() {
		return DEFAULT_SIZE;
	}
	
	//method to resize the queue
	public Job[] resizeQueue(Job[] priorityWiseJob){
		return(Arrays.copyOf(priorityWiseJob, priorityWiseJob.length * 2));
	}
	
	/**
	 * maxHeapify method to arrange tree in the form so that job with highest priority will be at the top
	 * @param priorityWiseJob array of all jobs
	 * @param queueSize   defines total number of the jobs available
	 * @param i
	 */
	public void maxHeapify(Job[] priorityWiseJob, int queueSize, int i){
		//initialising root node as largest
		int largest = i;
		   int leftJob = 2*i + 1;
		   int rightJob = 2*i + 2;
		   
		   //checking if left job is larger than largest job if so initialising largest job as left job
		   if (leftJob < queueSize ){
			   if(priorityWiseJob[leftJob].getPriority() == priorityWiseJob[largest].getPriority()){
				   if(priorityWiseJob[leftJob].getJobNo()<priorityWiseJob[largest].getJobNo()){
					   largest=leftJob;
				   }
			   }else if(priorityWiseJob[leftJob].getPriority() > priorityWiseJob[largest].getPriority()){
				   largest = leftJob;
			   }
		   }
		   
		   if (rightJob < queueSize ){
			   if(priorityWiseJob[rightJob].getPriority() == priorityWiseJob[largest].getPriority()){
				   if(priorityWiseJob[rightJob].getJobNo()<priorityWiseJob[largest].getJobNo()){
					   largest=rightJob;
				   }
			   }else if(priorityWiseJob[rightJob].getPriority() > priorityWiseJob[largest].getPriority()){
				   largest = rightJob;
			   }
		   }
		     
		   
		   
		   
		   //if largest node is not equal to right node than swapping both node
		   if (largest != i)
		   {	Job temp;
		   		temp=priorityWiseJob[i];
		   		priorityWiseJob[i]=priorityWiseJob[largest];
		   		priorityWiseJob[largest]=temp;
		     // Recursively calling maxHeapify to the affected sub-tree
		     maxHeapify(priorityWiseJob, queueSize, largest);
		   }
	}
	
	
	/**
	 * method to append time zone in the document string of the job
	 * @return
	 */
	public String appendWithTimeZone(){
		String appendedTimeZoneString="";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		appendedTimeZoneString+=dateFormat.format(date)+"\n";
		dateFormat.setTimeZone(TimeZone.getTimeZone("Europe/London"));
		appendedTimeZoneString+=dateFormat.format(date)+" "+TimeZone.getTimeZone("Europe/London").getDisplayName(true, 0) +"\n";
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/Adak"));
		appendedTimeZoneString+=dateFormat.format(date)+" "+TimeZone.getTimeZone("America/Adak").getDisplayName(true, 0) +"\n";
		dateFormat.setTimeZone(TimeZone.getTimeZone("Asia/KolKata"));
		appendedTimeZoneString+=dateFormat.format(date)+" "+TimeZone.getTimeZone("Asia/Kolkata").getDisplayName(true, 0) +"\n";
		dateFormat.setTimeZone(TimeZone.getTimeZone("America/Dawson"));
		appendedTimeZoneString+=dateFormat.format(date)+" "+TimeZone.getTimeZone("America/Dawson").getDisplayName(true, 0) +"\n";
		dateFormat.setTimeZone(TimeZone.getTimeZone("Pacific/Tahiti"));
		appendedTimeZoneString+=dateFormat.format(date)+" "+TimeZone.getTimeZone("Pacific/Tahiti").getDisplayName(true, 0);
		return appendedTimeZoneString;
	}
	
	
	
	/**
	 * method to insert job in the queue
	 * @param jobDocument   document to be printed
	 * @param priority      priority of the job
	 * @param userType      type of the user applying for job to be printed
	 * @return
	 */
	public boolean insert(String jobDocument,int priority,String userType){
		//creating object of class Job
		jobDocument=jobDocument+"\n"+appendWithTimeZone();
		Job arrivedJob=new Job(jobDocument,priority,userType,++numberOfJobs);
			//if queueSize is greater than the Job array size than resize the array 
			if(queueSize>priorityWiseJob.length){
				priorityWiseJob=resizeQueue(this.priorityWiseJob);
			}
			//add the job at the end of the queue
			priorityWiseJob[queueSize++]=arrivedJob;
			//calling maxHeapify on the queue
			for (int i = queueSize/ 2-1; i >=0; i--)
			    maxHeapify(priorityWiseJob,queueSize,i);
			return true;
	}
	
	//method to check if queue is empty or not
	public boolean queueEmpty(){
		if(queueSize==0){
			return true;
		}
		return false;
	}
	
	//return node on the basis of priority and if priority is same than on the basis of arrival of job
	public Job[] print(){
		int counter=0;
		Job[] printedJobs=new Job[queueSize];
		if (!queueEmpty()) {
			while (queueSize != 0) {
				printedJobs[counter++] = priorityWiseJob[0];
				priorityWiseJob[0] = priorityWiseJob[--queueSize];
				maxHeapify(priorityWiseJob, queueSize, 0);
			}
		}else{
			return null;
		}
		return printedJobs;
	}
	
}
