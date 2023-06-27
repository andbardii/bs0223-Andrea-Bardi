package esercizio2;

public class CallPhone {
	int duration;
	PhoneSim collingPhone;
	int calledPhone;

	
	public CallPhone(int d, PhoneSim col, int cal) {
		this.duration = d;
		
		col.calls ++;
		for(int i=0; i < col.callsNumber.length; i++) {
			if (col.callsNumber[i] == null) {
				col.callsNumber[i] = this;
				i = 5;
			}
		}
		this.collingPhone = col;
		this.calledPhone = cal;
		
		System.out.println("Effettuata una chiamata di: "+ this.duration + "min, al numero: "+ this.calledPhone );
		System.out.println("Numero di chiamate effettuate: " + this.collingPhone.calls);

	}
}
