package esercizio1;

public class MainZone {

	public static void main(String[] args) {
		
		System.out.println("CHECK STRING");
		System.out.println(stringaPariDispari("Andrea"));
		System.out.println(stringaPariDispari("Alehandro"));
		
		System.out.println("CHECK YEAR");
		System.out.println(annoBisestile(2023));
		System.out.println(annoBisestile(2400));
		
	}
	
	public static boolean stringaPariDispari(String s) {
		
		if(s.length()%2 == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	public static boolean annoBisestile(int anno) {
		
		if(anno%4 == 0) {
			return true;
		}else if(anno%100 == 0 && anno%400 == 0) {
			return true;
		}else {
			return false;
		}
	}
	

}
