// ColorTV inheritance
// exercise

class TV { // given
	private int size;
	public TV(int size) { this.size = size; }
	protected int getSize() { return size; }
}

class ColorTV extends TV {
	private int resolution;
	
	public ColorTV(int size, int res) {
		super(size);
		this.resolution = res;
	}
	
	public void printProperty() {
		System.out.printf("%d inch %d pixels %n", super.getSize(), resolution);
	}
	
	protected int getRes() {
		return resolution;
	}
}
class IPTV extends ColorTV {
	private String address;
	
	public IPTV(String address, int size, int res) {
		super(size, res);
		this.address = address;
	}
	
	public void printProperty() {
		System.out.println("My IPTV address is " + address);
		System.out.printf("It is %d inch and of %d pixels %n",
				super.getSize(), super.getRes());
	}
}

public class colorTV_inheritance {

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
		
		System.out.println();
		IPTV iptv = new IPTV("192.1.1.2", 32, 2048);
		iptv.printProperty();
	}

}
