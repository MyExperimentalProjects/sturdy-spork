import java.util.*;

class Job{
	int startTime;
	int finishTime;
	int value;

	Job(int s, int t, int v){
		startTime = s;
		finishTime = t;
		value = v;
	}

	public int getStartTime(){
		return startTime;
	}

	public int getFinishTime(){
		return finishTime;
	}

	public int getValue(){
		return value;
	}

	public String print(){
		return startTime + " - " + finishTime + " - " + value;
	}
}

class FinishTimeComparator implements Comparator<Job>{

	public int compare(Job m, Job n){
		return m.finishTime - n.finishTime;
	}

}

class StartTimeComparator implements Comparator<Job>{

	public int compare(Job m, Job n){
		return m.startTime - n.startTime;
	}

}

class ValueComparator implements Comparator<Job>{

	public int compare(Job m, Job n){
		return m.value - n.value;
	}

}

class WeightedIntervalScheduling{
	ArrayList<Job> jobs;
	ArrayList<Integer> nonConflictingJobs;

	WeightedIntervalScheduling(){
		jobs = new ArrayList<>();
		nonConflictingJobs = new ArrayList<>();
	}

	public void add(Job j){
		jobs.add(j);
	}

	public void sortByFinishTime(){
		Collections.sort(jobs, new FinishTimeComparator());
	}

	public void findCompatibleJobs(){
		sortByFinishTime();
		for(int i = jobs.size() - 1 ; i >= 0 ; --i){
			for(int j = i-1 ; j >= 0  ; --j){
				if(jobs.get(j).getFinishTime() <= jobs.get(i).getStartTime()){
					nonConflictingJobs.add(0,j);
					break;
				}
			}
		}
		nonConflictingJobs.add(0,0);
		for(Integer i:nonConflictingJobs){
			System.out.println(i);
		}
	}

	public int scheduleMaxProfit(){
		int[] M = new int[jobs.size()+1];
		M[0] = 0;
		for(int i = 1 ; i <= jobs.size() ; ++i){
			M[i] = Math.max(M[i-1], jobs.get(i-1).getValue() + M[nonConflictingJobs.get(i-1)+1]);
		}
		return M[jobs.size()];
	}

	public void printJobs(){
		
		findCompatibleJobs();
		int counter = 0;
		for(Job j:jobs){
			System.out.println(j.print() + "----" + nonConflictingJobs.get(counter));
			counter++;
		}
	}

	public static void main(String[] args){
		Job j1 = new Job(1,2,50);
		Job j2 = new Job(3,5,20);
		Job j3 = new Job(6,19,100);
		Job j4 = new Job(2,100,200);
		WeightedIntervalScheduling scheduler = new WeightedIntervalScheduling();
		scheduler.add(j1);
		scheduler.add(j3);
		scheduler.add(j2);
		scheduler.add(j4);
		//Collections.sort(scheduler.jobs, new FinishTimeComparator());
		scheduler.printJobs();
		System.out.println(scheduler.scheduleMaxProfit());

	}
}