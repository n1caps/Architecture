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
		
		
		public void decoder(int[] Instruction) {
			
			for(int i=0;i<6;i++) {
				Opcode[i]=Instruction[i];
			}
			for(int i=0;i<2;i++) {
				R[i]=Instruction[i+6];
			}
			for(int i=0;i<2;i++) {
				IX[i]=Instruction[i+8];
			}
			
			for(int i=0;i<7;i++) {
				Address[i]=Instruction[i+11];
			}
			I=Instruction[10];
			int decOpcode=Binary_to_dec(Opcode);
			int decR=Binary_to_dec(R);
			int decIX=Binary_to_dec(IX);
			int decAddress=Binary_to_dec(Address);
			switch (decOpcode) {
				case 1:
					LDR(decR,decIX,I,decAddress);
					//fault diagnose
					//information report
				break;
				case 2:
				
				break;
				case 3:
				break;
				case 33:
				break;
				case 34:
				break;
				default:
				break;
			}
		
		}
		
		public int Get_EA(int I,int IX,int R,int Address) {//get Effective Address(is int)
			int EA=0;
			if(I==0) {
				if(IX==0){
					EA=Address;
				}
				else if(IX==1){
					EA=this.X1.OutputAsInt()+Binary_to_dec(this.Memory.Output(Address));
				}
				else if(IX==2) {
					EA=this.X2.OutputAsInt()+Binary_to_dec(this.Memory.Output(Address));
				}
				else if(IX==3) {
					EA=this.X3.OutputAsInt()+Binary_to_dec(this.Memory.Output(Address));
				}
			}
			else {
				if(IX==0) {
					EA=Binary_to_dec(this.Memory.Output(Address));
				}
				else if(IX==1) {
					EA=Binary_to_dec(this.Memory.Output(this.X1.OutputAsInt()+Address));
				}
				else if(IX==2) {
					EA=Binary_to_dec(this.Memory.Output(this.X2.OutputAsInt()+Address));
				}
				else if(IX==3) {
					EA=Binary_to_dec(this.Memory.Output(this.X3.OutputAsInt()+Address));
				}
			}
			return EA;
		}
		
		public void LDR(int R,int IX,int I, int Address) {//all input at here is int only
			int EA=Get_EA(I,IX,R,Address);
			if(R==0){
				this.R0.Insert(this.Memory.Output(Address), 0);
			}
			else if(R==1) {
				this.R1.Insert(this.Memory.Output(Address), 0);
			}
			else if(R==2) {
				this.R2.Insert(this.Memory.Output(Address), 0);
			}
			else if(R==3) {
				this.R3.Insert(this.Memory.Output(Address), 0);
			}
		}
}
