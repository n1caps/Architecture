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
			this.Memory.Pointer=6;
			
			//PC 
			this.PC=new Register(12,1);
			//CC
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
		
		
		public String decoder(int[] Instruction) {//the function will return String Information of what have do
			String Information;
			Information="The Instruction is:";
			Information=Information+"Opcode:";
			int[] Opcode=new int[6];
			int[] R=new int[2];
			int[] IX=new int[2];
			int I;
			int[] Address=new int[5];
			
			for(int i=0;i<6;i++) {
				Opcode[i]=Instruction[i];
				Information=Information+Instruction[i];
			}
			Information=Information+"   R:";
			for(int i=0;i<2;i++) {
				R[i]=Instruction[i+6];
				Information=Information+Instruction[i+6];
			}
			Information=Information+"   IX:";
			for(int i=0;i<2;i++) {
				IX[i]=Instruction[i+8];
				Information=Information+Instruction[i+8];
			}
			Information=Information+"   Address:";
			for(int i=0;i<5;i++) {
				Address[i]=Instruction[i+11];
				Information=Information+Instruction[i+11];
			}
			Information=Information+"\n";
			I=Instruction[10];
			int decOpcode=Binary_to_dec(Opcode);
			int decR=Binary_to_dec(R);
			int decIX=Binary_to_dec(IX);
			int decAddress=Binary_to_dec(Address);
			int fault;
			switch (decOpcode) {
				case 1:
					Information=Information+LDR(decR,decIX,I,decAddress);
					//fault diagnose
					//information report
				break;
				case 2:
					Information=Information+STR(decR,decIX,I,decAddress);
				break;
				case 41:
					Information=Information+LDX(decR,decIX,I,decAddress);
				break;
				case 42:
					Information=Information+STX(decR,decIX,I,decAddress);
				break;
				case 34:
				break;
				default:
				break;
			}
			return Information;
		
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
		
		public String LDR(int R,int IX,int I,int Address) {//all input at here is int only
			int EA=Get_EA(I,IX,R,Address);
			String Information;
			Information="";
			Information=Information+R+" "+IX+" "+I+" "+Address+" \n";
			if(R==0){
				this.R0.Insert(this.Memory.Output(Address), 0);
				Information=Information+"R0<-c("+EA+").\n";
				return Information;
			}
			else if(R==1) {
				this.R1.Insert(this.Memory.Output(Address), 0);
				Information=Information+"R1<-c("+EA+").\n";
				return Information;
			}
			else if(R==2) {
				this.R2.Insert(this.Memory.Output(Address), 0);
				Information=Information+"R2<-c("+EA+").\n";
				return Information;
			}
			else if(R==3) {
				this.R3.Insert(this.Memory.Output(Address), 0);
				Information=Information+"R3<-c("+EA+").\n";
				return Information;
			}
			else {
				Information="Instruction LDR fail .\n";
				return Information;//fault
			}
		}
		
		public String STR(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,R,Address);
			String Information;
			if(R==0) {
				this.Memory.Insert(this.R0.Output(0), Address);
				Information="Memory("+EA+")<-c(R0).\n";
				return Information;
			}
			else if(R==1) {
				this.Memory.Insert(this.R1.Output(0), Address);
				Information="Memory("+EA+")<-c(R1).\n";
				return Information;
			}
			else if(R==2) {
				this.Memory.Insert(this.R2.Output(0), Address);
				Information="Memory("+EA+")<-c(R2).\n";
				return Information;
			}
			else if(R==3) {
				this.Memory.Insert(this.R3.Output(0), Address);
				Information="Memory("+EA+")<-c(R3).\n";
				return Information;
			}
			else {
				Information="Instruction STR fail.\n";
				return Information;
			}
		}
		
		public String LDA(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,R,Address);
			String Information;
			if(R==0) {
				this.R0.Insert(Address,0);
				Information="R0<-"+EA+".\n";
				return Information;
			}
			else if(R==1) {
				this.R1.Insert(Address,0);
				Information="R1<-"+EA+".\n";
				return Information;
			}
			else if(R==2) {
				this.R2.Insert(Address,0);
				Information="R2<-"+EA+".\n";
				return Information;
			}
			else if(R==3) {
				this.R3.Insert(Address,0);
				Information="R3<-"+EA+".\n";
				return Information;
			}
			else {
				Information="Instruction LDA Fail";
				return Information;
			}
		}
		
		public String LDX(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,R,Address);
			String Information;
			if(IX==0) {
				Information="No Register X0.\n";
				return Information;
			}
			else if(IX==1) {
				this.X1.Insert(this.Memory.Output(EA), 0);
				Information="X1<-c("+EA+").\n";
				return Information;
			}
			else if(IX==2) {
				this.X2.Insert(this.Memory.Output(EA), 0);
				Information="X2<-c("+EA+").\n";
				return Information;
			}
			else if(IX==3) {
				this.X3.Insert(this.Memory.Output(EA), 0);
				Information="X3<-c("+EA+").\n";
				return Information;
			}
			else {
				Information="Instruction LDX fail.\n";
				return Information;
			}
		}
		
		public String STX(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,R,Address);
			String Information;
			if(IX==0) {
				Information="No Register X0.\n";
				return Information;
			}
			else if(IX==1) {
				this.Memory.Insert(this.X1.OutputAsInt(), EA);
				Information="Memory("+EA+")<-X1.\n";
				return Information;
			}
			else if(IX==2) {
				this.Memory.Insert(this.X2.OutputAsInt(), EA);
				Information="Memory("+EA+")<-X2.\n";
				return Information;
			}
			else if(IX==3) {
				this.Memory.Insert(this.X3.OutputAsInt(), EA);
				Information="Memory("+EA+")<-X3.\n";
				return Information;
			}
			else {
				Information="Instruction STX fail.\n";
				return Information;
			}
		}
		
}
