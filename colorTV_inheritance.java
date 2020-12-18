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
		resolution = res;
	}
	
	public void printProperty() {
		System.out.printf("%d inch %d pixels %n", super.getSize(), resolution);
	}
}

public class colorTV_inheritance {

	public static void main(String[] args) {
		ColorTV myTV = new ColorTV(32, 1024);
		myTV.printProperty();
	}

}
