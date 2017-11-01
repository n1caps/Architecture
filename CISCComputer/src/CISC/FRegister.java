package CISC;

public class FRegister extends Register{
	public FRegister(int bits,int height) {
		super(bits,height);
	}
	
	public float OutPutAsFloat() {
		float F;
		F=binary_float(this.Output);
		return F;
	}
	
	public int Binary_to_dec(int[] Bin, int length) {//binary transfer to dec
		int decAd=0;
		for(int i=0;i<Length;i++) {
			int exp = (int) Math.pow(2,(Length-1-i));
			decAd += Bin[i] * (exp);
		}
		return decAd;
	}
	
	public int[] Dec_to_binary(int Dec, int length) {//dec transfer to binary
		int[] binary;
		int temp=Dec;
		binary=new int[Length];
		for(int i=0;i<Length;i++) {
			binary[i]=0;
		}
		for(int i=Length;i>=0;i--) {
			binary[i]=temp%2;
			temp=temp/2;
		}
		return binary;
	}
	
	public float binary_float(int[] input) {//change int[] to float
		int[] exponent=new int[7];
		int[] mantissa=new int[8];
		int ex;
		int man;
		float F;
		for(int i=0;i<7;i++) {
			exponent[i]=input[i+1];
		}
		for(int i=0;i<8;i++) {
			mantissa[i]=input[i+8];
		}
		ex=this.Binary_to_dec(exponent, 7);
		man=this.Binary_to_dec(mantissa, 8);
		F=(float) (ex+(man*0.000000001));//
		if(input[0]==1) {
			F=F*-1;
		}
		return F;
		
	}

	public int[] float_binary(float input) {//change float to int[]
		int exponent;
		float mantissa;
		int man;
		int s;
		int[] F=new int[16];
		if(input<0) {
			s=1;
		}
		else {
			s=0;
		}
		int[] exp=new int[7];
		int[] manti=new int[8];
		String str=String.valueOf(input);
		int idx=str.lastIndexOf(".");
		String Num=str.substring(0,idx);
		exponent=Integer.valueOf(Num);
		mantissa=(float)input-exponent;
		man=(int)(mantissa*100000000);
		exp=this.Dec_to_binary(exponent, 7);
		manti=this.Dec_to_binary(man, 8);
		F[0]=s;
		for(int i=0;i<7;i++) {
			F[i+1]=exp[i];
		}
		for(int i=0;i<8;i++) {
			F[i+8]=manti[i];
		}
		return F;
	}
}
