package CISC;

public class MainMemory extends Register{

	public MainMemory(int bits, int height) {
		super(bits, height);
		// TODO Auto-generated constructor stub
	}

	public void updatePoint() {//Pointer++
		if(this.Height>1) {
			if(this.Pointer<this.Height-1) {
				this.Pointer++;
			}
			else {
				this.Pointer=6;//!!!!memory start at 6 
			}
		}
	}
	
	

}
