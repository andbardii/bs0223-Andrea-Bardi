package esercizio1;

public class MainProject {

	public static void main(String[] args) {
		Rettangolo r1 = new Rettangolo(10, 20);
		Rettangolo r2 = new Rettangolo(20, 20);
		
		System.out.println("PRIMO RETTANGOLO");
		stampaRettangolo(r1);
		System.out.println("SECONDO RETTANGOLO");
		stampaRettangolo(r2);
		
		stampaDueRettangoli(r1, r2);
			
	}

	public static void stampaRettangolo(Rettangolo r) {
		System.out.println(r.areaRettangolo());
		System.out.println(r.perimetroRettangolo());
	}
	
	public static void stampaDueRettangoli(Rettangolo r1, Rettangolo r2) {
		System.out.println("PRIMO RETTANGOLO");
		stampaRettangolo(r1);
		System.out.println("SECONDO RETTANGOLO");
		stampaRettangolo(r2);
		
		System.out.println("AREE SOMMATE");
		System.out.println(r1.areaRettangolo() + r2.areaRettangolo());
		System.out.println("PERIMETRI SOMMATI");
		System.out.println(r1.perimetroRettangolo() + r2.perimetroRettangolo());
	}


}
