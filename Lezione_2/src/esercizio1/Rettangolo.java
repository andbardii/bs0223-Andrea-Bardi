package esercizio1;

public class Rettangolo {
	public int height;
	public int width;
	
	public Rettangolo(int h, int w) {
		this.height = h;
		this.width = w;
	}
	
	public int areaRettangolo() {
		return this.height * this.width;
	}
	
	public int perimetroRettangolo() {
		return (this.height + this.width)*2;
	}
}
