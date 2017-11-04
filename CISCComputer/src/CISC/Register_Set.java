package CISC;

import java.io.IOException;
import java.lang.*;
import java.util.*;

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
		MainMemory Memory;
			
		//PC
		Register PC;
		Register CC;
		Register IR;
		Register MAR;
		Register MBR;
		Register MSR;
		Register MFR;
		//GPR
		//Cache Cache;
		//Cache 
		Inputdevice INPUT;
		PrinterDevice PRINTER;
		
		public boolean isWaitingForInput = false;
		FRegister FR0;
		FRegister FR1;
		
		public boolean isRunning = false;

		public Register_Set() {
			//GPR
			this.R0=new Register(16,1);
			this.R1=new Register(16,1);
			this.R2=new Register(16,1);
			this.R3=new Register(16,1);

			//IR
			this.X1=new Register(16,1);
			this.X2=new Register(16,1);
			this.X3=new Register(16,1);
		
			//Main Memory
			this.Memory=new MainMemory(16,4096,16,16,16);
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
			
			this.INPUT=new Inputdevice();
			this.PRINTER = new PrinterDevice();
			
			this.FR0=new FRegister(16,1);
			this.FR1=new FRegister(16,1);
			//Cache
			//this.Cache=new Register(16,16);
			// ER=new Erro_Report();
			// DCD=new Decoder();
			// CT=new Controller();
		}
		
		/**
		 * Binary Array to Integer converter helper function
		 * @param Bin
		 * @return
		 */
		public int Binary_to_dec(int[] Bin) {//binary transfer to dec
			int decAd=0;
			for(int i=0;i<Bin.length;i++) {
				int exp = (int) Math.pow(2,(Bin.length-1-i));
				decAd += Bin[i] * (exp);
			}
			return decAd;
		}
		
		public int[] Dec_to_binary(int Dec, int Length) {//dec transfer to binary
			int[] binary;
			int temp=Dec;
			binary=new int[Length];
			for(int i=0;i<Length;i++) {
				binary[i]=0;
			}
			for(int i=Length-1;i>=0;i--) {
				binary[i]=temp%2;
				temp=temp/2;
			}
			return binary;
		}
		
		/**
		 * Decodes and executes the instruction
		 * @param Instruction
		 */
		public String decoder(int[] Instruction) {//the function will return String Information of what have do
			String Information;
			Information="The Instruction is:";
			Information=Information+"Opcode:";
			int[] Opcode=new int[6];
			int[] R=new int[2];
			int[] IX=new int[2];
			int[] Rx=new int[2];
			int[] Ry=new int[2];
			int[] Count=new int[4];
			int[] DevId=new int[5];
			int I;
			int[] Address=new int[5];
			
			//Parse out the Opcode, Register, IX, I, and Address from the instruction word
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
			Information=Information+"   Rx:";
			for(int i=0;i<2;i++) {
				Rx[i]=Instruction[i+6];
				Information=Information+Instruction[i+6];
			}
			Information=Information+"   Ry:";
			for(int i=0;i<2;i++) {
				Ry[i]=Instruction[i+8];
				Information=Information+Instruction[i+8];
			}
			Information=Information+"   AL:";
			int decAL = Instruction[8];
			Information=Information+Instruction[8];
			Information=Information+"   LR:";
			int decLR = Instruction[9];
			Information=Information+Instruction[9];
			Information=Information+"   Count:";
			for(int i=0;i<4;i++) {
				Count[i]=Instruction[i+12];
				Information=Information+Instruction[i+12];
			}
			Information=Information+"   DevId:";
			for(int i=0;i<5;i++) {
				DevId[i]=Instruction[i+11];
				Information=Information+Instruction[i+11];
			}
			Information=Information+"   DevId:";
			I=Instruction[10];
			Information=Information+Instruction[10];
			
			Information=Information+"\n";
			
			//Convert parsed values to easier to user INTEGER value (base 10)
			int decOpcode=Binary_to_dec(Opcode);
			int decR=Binary_to_dec(R);
			int decIX=Binary_to_dec(IX);
			int decAddress=Binary_to_dec(Address);
			int decRx=Binary_to_dec(Rx);
			int decRy=Binary_to_dec(Ry);
			int decCount=Binary_to_dec(Count);
			int decDevId=Binary_to_dec(DevId);
			
			//Using switch statement to determine which instruction to run
			//Opcodes in the document are in BASE 8!!!
			//Note that the opcode is switched using its BASE 10 VALUE!
			switch (decOpcode) {
				case 1:
					Information=Information+LDR(decR,decIX,I,decAddress);
					//fault diagnose
					//information report
					break;
				case 2:
					Information=Information+STR(decR,decIX,I,decAddress);
					break;
				case 3:
					Information=Information+LDA(decR,decIX,I,decAddress);
					break;
				case 4:
					Information=Information+AMR(decR,decIX,I,decAddress);
					break;
				case 5:
					Information=Information+SMR(decR,decIX,I,decAddress);
					break;
				case 6:
					Information=Information+AIR(decR,decIX,I,decAddress);
					break;
				case 7:
					Information=Information+SIR(decR,decIX,I,decAddress);
					break;
				case 8:
					Information=Information+JZ(decR,decIX,I,decAddress);
					break;
				case 9:
					Information=Information+JNE(decR,decIX,I,decAddress);
					break;
				case 10:
					Information=Information+JCC(decR,decIX,I,decAddress);
					break;
				case 11:
					Information=Information+JMA(decR,decIX,I,decAddress);
					break;
				case 12:
					Information=Information+JSR(decR,decIX,I,decAddress);
					break;
				case 13:
					Information=Information+RFS(decR,decIX,I,decAddress);
					break;
				case 14:
					Information=Information+SOB(decR,decIX,I,decAddress);
					break;
				case 15:
					Information=Information+JGE(decR,decIX,I,decAddress);
					break;
				case 16:
					Information=Information+MLT(decRx,decRy);
					break;
				case 17:
					Information=Information+DVD(decRx,decRy);
					break;
				case 18:
					Information=Information+TRR(decRx,decRy);
					break;
				case 19:
					Information=Information+AND(decRx,decRy);
					break;
				case 20:
					Information=Information+ORR(decRx,decRy);
					break;
				case 21:
					Information=Information+NOT(decRx);
					break;
				case 25:
					Information=Information+SRC(decR,decCount, decLR, decAL);
					break;
				case 26:
					Information=Information+RRC(decR,decCount, decLR, decAL);
					break;
				case 33:
					Information=Information+LDX(decR,decIX,I,decAddress);
					break;
				case 34:
					Information=Information+STX(decR,decIX,I,decAddress);
					break;
				case 49:
					Information=Information+IN(decR,decDevId);
					break;
				case 50:
					Information=Information+OUT(decR,decDevId);
					break;
				case 51:
					Information=Information+CHK(decR,decDevId);
					break;
				case 0:
				default:
					Information=Information+"Halted.\n";
		  			//When it halts Return PC to the beginning of program memory
		  			this.PC.Insert((new int[] {0,0,0,0,0,0,0,0,0,1,1,0}), 0);
		  			isRunning = false;
		  			//do nothing;
				break;
			}
			return Information;
		
		}
		
		/**
		 * Calculate affective address based on I,IX, and address
		 * @param I
		 * @param IX
		 * @param Address
		 * @return
		 */
		public int Get_EA(int I,int IX,int Address) {//get Effective Address(is int)
			int EA=0;
			if(I==0) {
				if(IX==0){
					EA=Address;
				}
				else if(IX==1){
					EA=this.X1.OutputAsInt()+Address;
				}
				else if(IX==2) {
					EA=this.X2.OutputAsInt()+Address;
				}
				else if(IX==3) {
					EA=this.X3.OutputAsInt()+Address;
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
			int EA=Get_EA(I,IX,Address);
			String Information;
			Information="";
			if(R==0){
				this.R0.Insert(this.Memory.Output(EA), 0);
				Information=Information+"R0<-c("+EA+").\n";
				return Information;
			}
			else if(R==1) {
				this.R1.Insert(this.Memory.Output(EA), 0);
				Information=Information+"R1<-c("+EA+").\n";
				return Information;
			}
			else if(R==2) {
				this.R2.Insert(this.Memory.Output(EA), 0);
				Information=Information+"R2<-c("+EA+").\n";
				return Information;
			}
			else if(R==3) {
				this.R3.Insert(this.Memory.Output(EA), 0);
				Information=Information+"R3<-c("+EA+").\n";
				return Information;
			}
			else {
				Information="Instruction LDR fail .\n";
				return Information;//fault
			}
		}
		
		public String STR(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				this.Memory.Insert(this.R0.Output(0), EA);
				Information="Memory("+EA+")<-c(R0).\n";
				return Information;
			}
			else if(R==1) {
				this.Memory.Insert(this.R1.Output(0), EA);
				Information="Memory("+EA+")<-c(R1).\n";
				return Information;
			}
			else if(R==2) {
				this.Memory.Insert(this.R2.Output(0), EA);
				Information="Memory("+EA+")<-c(R2).\n";
				return Information;
			}
			else if(R==3) {
				this.Memory.Insert(this.R3.Output(0), EA);
				Information="Memory("+EA+")<-c(R3).\n";
				return Information;
			}
			else {
				Information="Instruction STR fail.\n";
				return Information;
			}
		}
		
		public String LDA(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				this.R0.Insert(EA,0);
				Information="R0<-"+EA+".\n";
				return Information;
			}
			else if(R==1) {
				this.R1.Insert(EA,0);
				Information="R1<-"+EA+".\n";
				return Information;
			}
			else if(R==2) {
				this.R2.Insert(EA,0);
				Information="R2<-"+EA+".\n";
				return Information;
			}
			else if(R==3) {
				this.R3.Insert(EA,0);
				Information="R3<-"+EA+".\n";
				return Information;
			}
			else {
				Information="Instruction LDA Fail";
				return Information;
			}
		}
		
		public String LDX(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,0,Address);
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
			int EA=Get_EA(I,0,Address);
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
		
		public String JZ(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				if(this.R0.OutputAsInt()==0) {
					Information="R0==0\n";
					this.PC.Insert(EA,0);
					Information=Information+"PC<-("+EA+")\n";
				}
				else {
					Information="R0!=0\n";
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==1) {
				
				if(this.R1.OutputAsInt()==0) {
					Information="R1==0\n";
					this.PC.Insert(EA,0);
					Information=Information+"PC<-("+EA+")\n";
				}
				else {
					Information="R1!=0\n";
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==2) {
				if(this.R2.OutputAsInt()==0) {
					Information="R2==0\n";
					this.PC.Insert(EA,0);
					Information=Information+"PC<-("+EA+")\n";
				}
				else {
					Information="R2!=0\n";
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==3) {
				if(this.R3.OutputAsInt()==0) {
					Information="R3==0\n";
					this.PC.Insert(EA,0);
					Information=Information+"PC<-("+EA+")\n";
				}
				else {
					Information="R3!=0\n";
					Information=Information+"PC<-PC+1\n";
				}
			}
			else {
				Information="Instruction JZ fail.\n";
			}
			return Information;
		};
		
		public String JNE(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				if(this.R0.OutputAsInt()!=0) {
					this.PC.Insert(EA, 0);
					Information="R0!=0\nPC<-EA\n";
				}
				else {
					Information="R0==0\nPC<-PC+1\n";
				}
			}
			else if(R==1) {
				if(this.R1.OutputAsInt()!=0) {
					this.PC.Insert(EA, 0);
					Information="R1!=0\nPC<-EA\n";
				}
				else {
					Information="R1==0\nPC<-PC+1\n";
				}
			}
			else if(R==2) {
				if(this.R2.OutputAsInt()!=0) {
					this.PC.Insert(EA, 0);
					Information="R2!=0\nPC<-EA\n";
				}
				else {
					Information="R2==0\nPC<-PC+1\n";
				}
			}
			else if(R==3) {
				if(this.R3.OutputAsInt()!=0) {
					this.PC.Insert(EA, 0);
					Information="R3!=0\nPC<-EA\n";
				}
				else {
					Information="R3==0\nPC<-PC+1\n";
				}
			}
			else {
				Information="Instruction JNE fail.\n";
			}
			return Information;
		}
		
		public String JCC(int C,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(C==1) {
				Information="cc bit==1\n";
				this.PC.Insert(EA, 0);
				Information=Information+"PC<-EA\n";
			}
			else {
				Information="cc bit!=1\n";
				Information=Information+"PC<-PC+1\n";
			}
			return Information;
		}
		
		public String JMA(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			this.PC.Insert(EA, 0);
			Information="PC<-EA\n";
			return Information;
		}  
		
		public String JSR(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			this.R3.Insert(this.PC.OutputAsInt(), 0);
			Information="R3<-PC+1\n";
			this.PC.Insert(EA, 0);
			Information=Information+"PC<-EA\n";
			return Information;
		}
		
		public String RFS(int R,int IX,int I,int Address) {
			String Information ="";
			this.R0.Insert(Address, 0);
			this.PC.Insert(this.R3.OutputAsInt(), 0);
			Information = "R0 <- Immed; PC <- c(R3)\n";
			return Information;
		}
		
		public String SOB(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				this.R0.Insert(this.R0.OutputAsInt()-1, 0);
				Information="R0<-C(R0)-1\n";
				if(this.R0.OutputAsInt()>0) {
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==1) {
				this.R1.Insert(this.R1.OutputAsInt()-1, 0);
				Information="R1<-C(R1)-1\n";
				if(this.R1.OutputAsInt()>0) {
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==2) {
				this.R2.Insert(this.R2.OutputAsInt()-1, 0);
				Information="R2<-C(R2)-1\n";
				if(this.R2.OutputAsInt()>0) {
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information=Information+"PC<-PC+1\n";
				}
			}
			else if(R==3) {
				this.R0.Insert(this.R0.OutputAsInt()-1, 0);
				Information="R3<-C(R3)-1\n";
				if(this.R3.OutputAsInt()>0) {
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information=Information+"PC<-PC+1\n";
				}
			}
			else {
				Information="Instruction SOB fail.\n";
			}
			return Information;
		}
		
		public String JGE(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				if(this.R0.OutputAsInt()>=0) {
					Information="R0>=0\n";
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information="R0<0\nPC<-PC+1\n";
				}
			}
			else if(R==1) {
				if(this.R1.OutputAsInt()>=0) {
					Information="R1>=0\n";
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information="R1<0\nPC<-PC+1\n";
				}
			}
			else if(R==2) {
				if(this.R2.OutputAsInt()>=0) {
					Information="R2>=0\n";
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information="R2<0\nPC<-PC+1\n";
				}
			}
			else if(R==3) {
				if(this.R3.OutputAsInt()>=0) {
					Information="R3>=0\n";
					this.PC.Insert(EA, 0);
					Information=Information+"PC<-EA\n";
				}
				else {
					Information="R3<0\nPC<-PC+1\n";
				}
			}
			else {
				Information="Instruction JGE fail.\n";
			}
			return Information;
		}
		
		public String AMR(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				this.R0.Insert(this.R0.OutputAsInt()+this.Memory.Binary_to_dec(this.Memory.Output(EA)), 0);
				Information="R0<-c(R0)+c(EA)\n";
			}
			else if(R==1) {
				this.R1.Insert(this.R1.OutputAsInt()+this.Memory.Binary_to_dec(this.Memory.Output(EA)), 0);
				Information="R1<-c(R1)+c(EA)\n";
			}
			else if(R==2) {
				this.R2.Insert(this.R2.OutputAsInt()+this.Memory.Binary_to_dec(this.Memory.Output(EA)), 0);
				Information="R2<-c(R2)+c(EA)\n";
			}
			else if(R==3) {
				this.R3.Insert(this.R3.OutputAsInt()+this.Memory.Binary_to_dec(this.Memory.Output(EA)), 0);
				Information="R3<-c(R3)+c(EA)\n";
			}
			else {
				Information="Instruction AMR fail.\n";
			}
			return Information;
		}
		
		public String SMR(int R,int IX,int I,int Address) {
			int EA=Get_EA(I,IX,Address);
			String Information;
			if(R==0) {
				int value=this.R0.OutputAsInt()-this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.R0.Insert(value, 0);
				Information="R0<-c(R0)-c(EA)\n";
			}
			else if(R==1) {
				int value=this.R1.OutputAsInt()-this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.R1.Insert(value, 0);
				Information="R1<-c(R1)-c(EA)\n";
			}
			else if(R==2) {
				int value=this.R2.OutputAsInt()-this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.R2.Insert(value, 0);
				Information="R2<-c(R2)-c(EA)\n";
			}
			else if(R==3) {
				int value=this.R3.OutputAsInt()-this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.R3.Insert(value, 0);
				Information="R3<-c(R3)-c(EA)\n";
			}
			else {
				Information="Instruction AMR fail.\n";
			}
			return Information;
		}
		
		public String AIR(int R,int IX,int I,int Address) {
			String Information;
			if (Address==0) {
				Information="Immed is 0\n";
			}
			else {
				if(R==0) {
					this.R0.Insert(this.R0.OutputAsInt()+Address, 0);
					Information="R0<-c(R0)+Immed\n";
				}
				else if(R==1) {
					this.R1.Insert(this.R1.OutputAsInt()+Address, 0);
					Information="R1<-c(R1)+Immed\n";
				}
				else if(R==2) {
					this.R2.Insert(this.R2.OutputAsInt()+Address, 0);
					Information="R2<-c(R2)+Immed\n";
				}
				else if(R==3) {
					this.R3.Insert(this.R3.OutputAsInt()+Address, 0);
					Information="R3<-c(R3)+Immed\n";
				}
				else {
					Information="Instruction AIR fail.\n";
				}
			}
			return Information;
		}
		
		public String SIR(int R,int IX,int I,int Address) {
			String Information;
			if (Address==0) {
				Information="Immed is 0\n";
			}
			else {
				if(R==0) {
					this.R0.Insert(this.R0.OutputAsInt()-Address, 0);
					Information="R0<-c(R0)-Immed\n";
				}
				else if(R==1) {
					this.R1.Insert(this.R1.OutputAsInt()-Address, 0);
					Information="R1<-c(R1)-Immed\n";
				}
				else if(R==2) {
					this.R2.Insert(this.R2.OutputAsInt()-Address, 0);
					Information="R2<-c(R2)-Immed\n";
				}
				else if(R==3) {
					this.R3.Insert(this.R3.OutputAsInt()-Address, 0);
					Information="R3<-c(R3)-Immed\n";
				}
				else {
					Information="Instruction AIR fail.\n";
				}
			}
			return Information;
		};
		
		public String MLT(int Rx, int Ry) {
			String Information;
			int crx = 0;
			int cry = 0;
			int [] res;
			if(!((Rx == 0 || Rx == 2)&& (Ry == 0 || Ry == 2))) {
				return "MLT fail! Rx must be 0 or 2, Ry must be 0 or 2\n";
			}
			
			switch (Rx){
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			switch (Ry){
			case 2:
				cry = this.R2.OutputAsInt();
				break;
			default:
				cry = this.R0.OutputAsInt();
				break;
			}
			
			res = Dec_to_binary(cry * crx, 32);
			int [] resHighOrder = {res[0], res[1], res[2], res[3], res[4], res[5], res[6], res[7], 
								res[8], res[9], res[10], res[11], res[12], res[13], res[14], res[15]};
			int [] resLowOrder = {res[16], res[17], res[18], res[19], res[20], res[21], res[22], res[23], 
					res[24], res[25], res[26], res[27], res[28], res[29], res[30], res[31]};
			

			switch (Rx){
			case 2:
				this.R2.Insert(resHighOrder, 0);
				this.R3.Insert(resLowOrder, 0);
				Information = "rx, rx+1 <- c(rx) * c(ry)\r\n";
				break;
			default:
				this.R0.Insert(resHighOrder, 0);
				this.R1.Insert(resLowOrder, 0);
				Information = "rx, rx+1 <- c(rx) * c(ry)\r\n";
				break;
			}
			return Information;
		}
		
		public String DVD(int Rx, int Ry) {
			String Information;
			int crx = 0;
			int cry = 0;
			if(!((Rx == 0 || Rx == 2)&& (Ry == 0 || Ry == 2))) {
				return "DVD fail! Rx must be 0 or 2, Ry must be 0 or 2\n";
			}
			
			switch (Rx){
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			switch (Ry){
			case 2:
				cry = this.R2.OutputAsInt();
				break;
			default:
				cry = this.R0.OutputAsInt();
				break;
			}
			
			if (cry == 0) {
				this.CC.Insert(1, 3);
				return "Error! devide by Zero";
			}
			int a = crx/cry;
			int b = crx%cry;
			int [] resHighOrder = Dec_to_binary(a, 16);
			int [] resLowOrder = Dec_to_binary(b, 16);

			switch (Rx){
			case 2:
				this.R2.Insert(resHighOrder, 0);
				this.R3.Insert(resLowOrder, 0);
				Information = "rx, rx+1 <- c(rx) / c(ry)\r\n";
				break;
			default:
				this.R0.Insert(resHighOrder, 0);
				this.R1.Insert(resLowOrder, 0);
				Information = "rx, rx+1 <- c(rx) / c(ry)\r\n";
				break;
			}
			return Information;
		}
		
		public String TRR(int Rx, int Ry) {
			String Information;
			int crx = 0;
			int cry = 0;
			
			switch (Rx){
			case 1:
				crx = this.R1.OutputAsInt();
				break;
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			case 3:
				crx = this.R3.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			switch (Ry){
			case 1: 
				cry = this.R1.OutputAsInt();
				break;
			case 2:
				cry = this.R2.OutputAsInt();
				break;
			case 3: 
				cry = this.R3.OutputAsInt();
				break;
			default:
				cry = this.R0.OutputAsInt();
				break;
			}
			if(crx == cry) {
				this.CC.Insert(1, 4);
				Information = "c(rx) = c(ry); cc(4) <- 1\n";
			}else {
				this.CC.Insert(0, 4);
				Information = "c(rx) != c(ry); cc(4) <- 0\n";
			}
			return Information;
		}
		
		public String AND(int Rx, int Ry) {
			String Information;
			int crx = 0;
			int cry = 0;
			int [] res;
			
			switch (Rx){
			case 1:
				crx = this.R1.OutputAsInt();
				break;
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			case 3:
				crx = this.R3.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			switch (Ry){
			case 1: 
				cry = this.R1.OutputAsInt();
				break;
			case 2:
				cry = this.R2.OutputAsInt();
				break;
			case 3: 
				cry = this.R3.OutputAsInt();
				break;
			default:
				cry = this.R0.OutputAsInt();
				break;
			}
			
			res = Dec_to_binary(crx & cry, 16);
			
			switch (Rx){
			case 1:
				crx = this.R1.Insert(res, 0);
				break;
			case 2:
				crx = this.R2.Insert(res, 0);
				break;
			case 3:
				crx = this.R3.Insert(res, 0);
				break;
			default:
				crx = this.R0.Insert(res, 0);
				break;
			}
			Information = "c(Rx) <- c(rx) & c(ry)\n";
			return Information;
		}
		
		public String ORR(int Rx, int Ry) {
			String Information;
			int crx = 0;
			int cry = 0;
			int [] res;
			
			switch (Rx){
			case 1:
				crx = this.R1.OutputAsInt();
				break;
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			case 3:
				crx = this.R3.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			switch (Ry){
			case 1: 
				cry = this.R1.OutputAsInt();
				break;
			case 2:
				cry = this.R2.OutputAsInt();
				break;
			case 3: 
				cry = this.R3.OutputAsInt();
				break;
			default:
				cry = this.R0.OutputAsInt();
				break;
			}
			
			res = Dec_to_binary(crx | cry, 16);
			
			switch (Rx){
			case 1:
				crx = this.R1.Insert(res, 0);
				break;
			case 2:
				crx = this.R2.Insert(res, 0);
				break;
			case 3:
				crx = this.R3.Insert(res, 0);
				break;
			default:
				crx = this.R0.Insert(res, 0);
				break;
			}
			Information = "c(Rx) <- c(rx) | c(ry)\n";
			return Information;
		}
		
		public String NOT(int Rx) {
			String Information;
			int crx = 0;
			int [] res;
			
			switch (Rx){
			case 1:
				crx = this.R1.OutputAsInt();
				break;
			case 2:
				crx = this.R2.OutputAsInt();
				break;
			case 3:
				crx = this.R3.OutputAsInt();
				break;
			default:
				crx = this.R0.OutputAsInt();
				break;
			}
			
			res = Dec_to_binary(~crx, 16);
			
			switch (Rx){
			case 1:
				crx = this.R1.Insert(res, 0);
				break;
			case 2:
				crx = this.R2.Insert(res, 0);
				break;
			case 3:
				crx = this.R3.Insert(res, 0);
				break;
			default:
				crx = this.R0.Insert(res, 0);
				break;
			}
			Information = "c(Rx) <- NOT c(rx)\n";
			return Information;
		}
		
		public String SRC(int R, int count, int LR, int AL) {
			int[] temp;			
			String Information;
			
			switch (R){
			case 1:
				temp = this.R1.Output(0);
				break;
			case 2:
				temp = this.R2.Output(0);
				break;
			case 3:
				temp = this.R3.Output(0);
				break;
			default:
				temp = this.R0.Output(0);
				break;
			}
			
			if(LR == 1) {//Shift Left
				for(int i = 0; i < 16; i++) {
					if(i+count > 15) {
						temp[i] = 0;
					}else {
						temp[i] = temp[i + count];
					}
				}
			}else {//Shift Right
				for(int i = 15; i >= 0; i--) {
					if(i-count < 0) {
						if(AL == 1) {//Logical shift
							temp[i] = 0;
						}else {
							temp[i] = temp[0];
						}
					}else {
						temp[i] = temp[i - count];
					}
				}
			}
			
			switch (R){
			case 1:
				this.R1.Insert(temp,0);
				break;
			case 2:
				this.R2.Insert(temp,0);
				break;
			case 3:
				this.R3.Insert(temp,0);
				break;
			default:
				this.R0.Insert(temp,0);
				break;
			}
			
			Information = "Shift operation succes \n";
			return Information;
		}
		
		public String RRC(int R, int count, int LR, int AL) {
			int[] temp;	
			int[] res = new int[16];
			String Information;
			
			switch (R){
			case 1:
				temp = this.R1.Output(0);
				break;
			case 2:
				temp = this.R2.Output(0);
				break;
			case 3:
				temp = this.R3.Output(0);
				break;
			default:
				temp = this.R0.Output(0);
				break;
			}
			
			if(LR == 1) {//Rotate Left
				for(int i = 0; i < 16; i++) {
					res[i] = temp[(i + count) % 16];
				}
			}else {//Rotate Right
				for(int i = 0; i < 16; i++) {
					res[i] = temp[(i - count) % 16];
				}
			}
			
			switch (R){
			case 1:
				this.R1.Insert(temp,0);
				break;
			case 2:
				this.R2.Insert(temp,0);
				break;
			case 3:
				this.R3.Insert(temp,0);
				break;
			default:
				this.R0.Insert(temp,0);
				break;
			}
			
			Information = "rotate operation succes \n";
			return Information;
		}
		
		public String IN(int R, int devId) {
			String Information;
			if(!(devId == 0 || devId==2)) {
				return "IN can only be called on keyboard or card reader";
			}
			if(devId == 0) {
				this.isWaitingForInput = false ;
				while(isWaitingForInput) {
					System.out.println("Waiting for submit to be entered...");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				System.out.println("Input Recieved");
				
				int chr = 0;
				chr = this.INPUT.Output();
				
				/*
				try {
					//System.out.print("Enter n" + this.X1.OutputAsInt() + " number: ");
					Scanner sc = new Scanner(System.in);
					chr = sc.nextInt();				
				} catch (Exception e) {
					System.out.print(e.getMessage());
					e.printStackTrace();
				}
				*/
				switch (R){
				case 1:
					this.R1.Insert(chr,0);
					break;
				case 2:
					this.R2.Insert(chr,0);
					break;
				case 3:
					this.R3.Insert(chr,0);
					break;
				default:
					this.R0.Insert(chr,0);
					break;
				}
				Information = "Read from keyboard success\n";
			}
			else{
				Information = "Read from cardReader Not implemented yet\n";
			}
			return Information;
		}
		
		public String OUT(int R, int devId) {
			String Information;
			String res="";
			if(!(devId == 1)) {
				return "IN can only be called on printer";
			}
			switch (R){
			case 1:
				res =res+this.R1.OutputAsInt();
				break;
			case 2:
				res =res+this.R1.OutputAsInt();
				break;
			case 3:
				res =res+this.R1.OutputAsInt();
			default:
				res =res+this.R0.OutputAsInt();
				break;
			}
			PRINTER.output += res+"\n";
			Information =res+"\n";
			return Information;
		}
		
		public String CHK(int R, int devId) {
			String Information;
			if(devId == 2)
			{
				switch (R){
				case 1:
					this.R1.Insert(0, 0);
					break;
				case 2:
					this.R2.Insert(0,0);
					break;
				case 3:
					this.R3.Insert(0,0);
					break;
				default:
					this.R0.Insert(0,0);
					break;
				}
				Information = "Card Reader not implemented yet";
			}
			switch (R){
			case 1:
				this.R1.Insert(1, 0);
				break;
			case 2:
				this.R2.Insert(1,0);
				break;
			case 3:
				this.R3.Insert(1,0);
				break;
			default:
				this.R0.Insert(1,0);
				break;
			}
			Information = "Devices are all on and connected by default\n";
			return Information;
		};
		
		public String FADD(int FR,int IX,int I,int Address) {
			String information;
			int EA=Get_EA(I,IX,Address);
			if(FR==0) {
				float F=this.FR0.OutPutAsFloat();
				float F2=this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.FR0.Insert(this.FR0.float_binary(F+F2),0);
				information="c(FR0)<-c(FR0)+c(EA)\n";
			}
			else if(FR==1) {
				float F=this.FR1.OutPutAsFloat();
				float F2=this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.FR1.Insert(this.FR0.float_binary(F+F2),0);
				information="c(FR1)<-c(FR1)+c(EA)\n";
			}
			else {
				information="FADD fail\n";
			}
			return information;
		}
		
		public String FSUB(int FR, int IX, int I, int Address) {
			String information;
			int EA=Get_EA(I,IX,Address);
			if(FR==0) {
				float F=this.FR0.OutPutAsFloat();
				float F2=this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.FR0.Insert(this.FR0.float_binary(F-F2), 0);
				information="c(FR0)<-c(FR0)-c(EA)\n";
			}
			else if(FR==1) {
				float F=this.FR1.OutPutAsFloat();
				float F2=this.Memory.Binary_to_dec(this.Memory.Output(EA));
				this.FR1.Insert(this.FR1.float_binary(F-F2), 0);
				information="c(FR1)<-c(FR1)-c(EA)\n";
			}
			else {
				information="FSUB fail\n";
			}
			return information;
		}
		
		public String LDFR(int FR, int IX, int I, int Address) {
			String information;
			int EA=Get_EA(I,IX,Address);
			if(FR==0) {
				this.FR0.Insert(this.Memory.Output(EA), 0);
				this.Memory.Insert(this.Memory.Binary_to_dec(this.Memory.Output(EA))+1, EA);//IM NOT SURE
				information="FR0<-c(EA),c(EA+1)\n";
			}
			else if(FR==1) {
				this.FR1.Insert(this.Memory.Output(EA), 0);
				this.Memory.Insert(this.Memory.Binary_to_dec(this.Memory.Output(EA))+1, EA);
				information="FR1<-c(EA),c(EA+1)\n";
			}
			else {
				information="LDFR fail\n";
			}
			return information;
		}
		
		
		
}
