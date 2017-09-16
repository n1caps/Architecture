package CISC;

public class Register {
	int Length;
	int Height;
	String Name=this.getClass().getName();
	int Memery[][];
	int Output[];
	int Pointer;
	byte Flag;
	
	public Register(int bits,int height) {
		this.Length=bits;
		this.Height=height;
		this.Pointer=0;
		this.Memery=new int[this.Length][this.Height];
	}
	
	public int Insert(int data[]) {// input is the data
		if(data.length==this.Length) {
			for(int i=0;i<this.Length;i++) {
				this.Memery[i][this.Pointer]=data[i];
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
		int j=0;
		for(int i=15;i>=0;i--) {
			decAd=decAd+(int)(Bin[i]*(2^j));
			j=j+1;
		}
		return decAd;
	}
	
	public int[] Output(int[] Address){//binary is address
		this.Output=new int[this.Length];
		int decAd;
		decAd=Binary_to_dec(Address);
		for(int i=0;i<this.Length;i++) {
			this.Output[i]=this.Memery[i][decAd];
		}
		return this.Output;
	}
	
}