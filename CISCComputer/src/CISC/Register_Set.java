package CISC;

public class Register_Set {
	//GPR
		Register R0;
		Register R1;
		Register R2;
		Register R3;
			
		//IR
		Register X1;
		Register X2;
		Register X3;
		
		//Main Memory
		Register Memory;
			
		//PC
		Register PC;
		Register CC;
		Register IR;
		Register MAR;
		Register MBR;
		Register MSR;
		Register MFR;
		//GPR
		
		//for instruction
		int[] Opcode;
		int[] R;
		int[] IX;
		int I;
		int[] Address;

		public Register_Set() {
			this.R0=new Register(16,1);
			this.R1=new Register(16,1);
			this.R2=new Register(16,1);
			this.R3=new Register(16,1);

			//IR
			this.X1=new Register(16,1);
			this.X2=new Register(16,1);
			this.X3=new Register(16,1);
		
			//Main Memory
			this.Memory=new Register(16,4096);
			//this.Memory.Pointer=6;
			
			//PC
			this.PC=new Register(12,1);
			this.CC=new Register(4,1);
			this.IR=new Register(16,1);
			this.MAR=new Register(16,1);
			this.MSR=new Register(16,1);
			this.MBR=new Register(16,1);
			this.MFR=new Register(16,1);
			
			Opcode=new int[6];
			R=new int[2];
			IX=new int[2];
			I=0;
			Address=new int[7];
			
		
			// ER=new Erro_Report();
			// DCD=new Decoder();
			// CT=new Controller();
		}
		
		public int Binary_to_dec(int[] Bin) {//binary transfer to dec
			int decAd=0;
			for(int i=0;i<Bin.length;i++) {
				int exp = (int) Math.pow(2,(Bin.length-1-i));
				decAd += Bin[i] * (exp);
			}
			return decAd;
		}

}
