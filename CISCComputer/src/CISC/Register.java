package CISC;

public class Register {
	int Length;
	int Height;
	String Name=this.getClass().getName();
	int Memory[][];
	int Output[];
	int Pointer;
	byte Flag;
	
	public Register(int bits,int height) {
		this.Length=bits;
		this.Height=height;
		this.Pointer=0;
		this.Memory=new int[this.Length][this.Height];
		for(int i = 0; i < Height; i++) {
			for(int j = 0; j < Length; j++) {
				this.Memory[j][i] = 0;
			}
		}
	}
	
	public int Insert(int data[]) {// input is the data
		if(data.length==this.Length) {
			for(int i=0;i<this.Length;i++) {
				this.Memory[i][this.Pointer]=data[i];
			}
			this.Pointer=this.Pointer+1;
			Flag=0;//0 means complete
		}
		else if(this.Length<data.length) {
			this.Flag=1;//1 means overflow
		}
		else if(this.Length<data.length) {
			this.Flag=2;//2 means short
		}
		else {
			this.Flag=3;//3 means something go wrong
		}
		return this.Flag;
	}
	
	public int Binary_to_dec(int[] Bin) {//binary transfer to dec
		int decAd=0;
		for(int i=0;i<16;i++) {
			int exp = (int) Math.pow(2,(15-i));
			decAd += Bin[i] * (exp);
		}
		return decAd;
	}
	
	public int[] Output(int[] Address){//binary is address
		this.Output=new int[this.Length];
		int decAd;
		decAd=Binary_to_dec(Address);
		if(decAd < Height) {
			for(int i=0;i<this.Length;i++) {
				this.Output[i]=this.Memory[i][decAd];
			}
		}else {
			//Return error code
			return null;
		}
		return this.Output;
	}
	
	public String OutputAsString() {
		String txt = "";
		for(int i = 0; i < Height; i++) {
			for(int j = 0; j < Length; j++) {
				txt += this.Memory[j][i];
			}
		}
		return txt;
	}
	
}