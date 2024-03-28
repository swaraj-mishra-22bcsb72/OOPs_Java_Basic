class Time{
	int hrs;
	int mins;
	int secs;
	
	Time(){
		hrs = 0;
		mins = 0;
		secs = 0;
	}
	Time(int hrs, int mins, int secs){
		this.hrs = hrs;
		this.mins = mins;
		this.secs = secs;
	}
	
	void displayTime(){
		System.out.println("The time is: "+hrs+":"+mins+":"+secs);
	}
	
	void addTime(Time t1, Time t2){
		secs = t1.secs + t2.secs;
		mins = t1.mins + t2.mins + secs/60;
		hrs = t1.hrs + t2.hrs + mins/60;
		
		secs %= 60;
		mins %= 60;
		hrs %= 12;
	}
}

//Driver Class
class AdditionOfTime{
	public static void main(String []args){
		Time ob = new Time();
		ob.displayTime();
		Time ob1 = new Time(11, 55, 43);
		ob1.displayTime();
		Time ob2 = new Time(0, 4, 23);
		ob2.displayTime();
		ob.addTime(ob1, ob2);
		ob.displayTime();
	}
}