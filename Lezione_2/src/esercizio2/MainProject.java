package esercizio2;

public class MainProject {

	public static void main(String[] args) {
		PhoneSim p1 = new PhoneSim(344553422);
		p1.showSim();
		
		PhoneSim p2 = new PhoneSim(542232444);
		p2.showSim();
		
		CallPhone p1c1 = new CallPhone(34433, p1, p2.phoneNumber);
		CallPhone p1c2 = new CallPhone(122,p1, p2.phoneNumber);
		CallPhone p1c3 = new CallPhone(3324,p1, p2.phoneNumber);
		CallPhone p1c4 = new CallPhone(2133,p1, p2.phoneNumber);
		CallPhone p1c5 = new CallPhone(25638,p1, p2.phoneNumber);
		
		CallPhone p2c1 = new CallPhone(42422,p2, p1.phoneNumber);
		
		p1.showCalls();
		p2.showCalls();
	}

}
