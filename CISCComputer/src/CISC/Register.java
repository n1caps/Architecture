package CISC;

//When the register output the data, the data will remove from the memory
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
		this.Memory=new int[this.Height][this.Length];
		for(int i = 0; i < Height; i++) {
			for(int j = 0; j < Length; j++) {
				this.Memory[i][j] = 0;
			}
		}
		this.Output = this.Memory[0];
	}
	
	public int Insert(int data[], int address) {// input is the data
		if(data.length==this.Length) {
			for(int i=0;i<this.Length;i++) {
				this.Memory[address][i]=data[i];
			}
			Output = data;
			//I dont thing that we should increment pointer when we insert data
			//this.Pointer=this.Pointer+1;
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
		updatePoint();
		return this.Flag;
	}
	
	public int Insert(int data, int address) {// Allows input of decimal data
		if(data > Math.pow(2, this.Length-1)) {
			this.Flag = 1;
		}else {
			int remainder = data;
			int val = 0;
			for(int i=0;i<this.Length;i++) {
				//Needs some work
				val = (int) (remainder/Math.pow(2,(this.Length-1-i)));
				remainder = (int) (remainder%Math.pow(2,(this.Length-1-i)));
				this.Memory[address][i]= val;
			}
			this.Output = this.Memory[address];	
		}
		updatePoint();
		return this.Flag;
	}
	
	public int Binary_to_dec(int[] Bin) {//binary transfer to dec
		int decAd=0;
		for(int i=0;i<this.Length;i++) {
			int exp = (int) Math.pow(2,(this.Length-1-i));
			decAd += Bin[i] * (exp);
		}
		return decAd;
	}
	
	public int[] Dec_to_binary(int Dec) {//dec transfer to binary
		int[] binary;
		int temp=Dec;
		binary=new int[this.Length];
		for(int i=0;i<this.Length;i++) {
			binary[i]=0;
		}
		for(int i=this.Length;i>=0;i--) {
			binary[i]=temp%2;
			temp=temp/2;
		}
		return binary;
	}
	
	public int[] Output(int[] Address){//binary is address
		this.Output=new int[this.Length];
		int decAd;
		decAd=Binary_to_dec(Address);
		if(decAd < Height) {
			this.Output = this.Memory[decAd];
		}else {
			//Return error code
			return null;
		}
		return this.Output;
	}
	
	public int[] Output(int Address) {
		this.Output=new int[this.Length];
		if(Address < Height) {
			this.Output = this.Memory[Address];
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
				txt += this.Memory[i][j];
			}
		}
		return txt;
	}
	
	public int OutputAsInt() {
		int val = Binary_to_dec(this.Output);
		return val;
	}
	
	public void Pop() {//Clear the Memory and Pointer++ 
		for(int i=0;i<this.Length;i++) {
			this.Memory[this.Pointer][i]=0;
		}
		updatePoint();
	}
	
	public void updatePoint() {//Pointer++
		if(this.Height>1) {
			if(this.Pointer<this.Height-1) {
				this.Pointer++;
			}
			else {
				this.Pointer=0;//!!!!memory start at 6 
			}
		}
	}
	
}