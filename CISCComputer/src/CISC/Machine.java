package CISC;
import java.lang.Thread;

public class Machine {
	public Register_Set RegisterSet2;
	public Thread progThread;
	
	public Machine(Register_Set Registers) {//initial
		RegisterSet2= Registers;
	}
	
	public void Run(int[] value, int State) {
		//this.Get_Instruction();
		/*
		value[0]==8||value[0]==9||value[0]==10||value[0]==11||value[0]==14||value[0]==15
				decR,decIX,I,decAddress
				int decOpcode=Binary_to_dec(Opcode);
			value[0]=decOpcode;
			int decR=Binary_to_dec(R);
			value[1]=decR;
			int decIX=Binary_to_dec(IX);
			value[2]=decIX;
			int decAddress=Binary_to_dec(Address);
			value[3]=decAddress;
			int decRx=Binary_to_dec(Rx);
			value[4]=decRx;
			int decRy=Binary_to_dec(Ry);
			value[5]=decRy;
			int decCount=Binary_to_dec(Count);
			value[6]=decCount;
			int decDevId=Binary_to_dec(DevId);
			value[7]=decDevId;
		*/
		String Information;
		if(value[0]==8) {
			Information=this.RegisterSet2.JZ(value[1], value[2], value[9], value[3],State);
		}
		else if(value[0]==9) {
			Information=this.RegisterSet2.JNE(value[1], value[2], value[9], value[3],State);
		}
		else if(value[0]==10) {
			Information=this.RegisterSet2.JCC(State, value[2], value[9], value[3]);
		}
		else if(value[0]==14) {
			Information=this.RegisterSet2.SOB(value[1], value[2], value[9], value[3],State);
		}
		else if(value[0]==15) {
			Information=this.RegisterSet2.JGE(value[1], value[2], value[9], value[3],State);
		}
		else {
			
		}
		this.RegisterSet2.isRunning=true;
			while(this.RegisterSet2.isRunning)
				{
					this.doSingleStep2();
				}
	}
	
 	public void doSingleStep2() {
 		String Information;
 		//I capsulate the action of MAR,MBR,IR into decoder, because I set the Output Method with remove the data in memory.
 		Information=this.RegisterSet2.decoder(Get_Instruction());//maybe return some String.
 	}
 	
 	public int[] Get_Instruction() {//Get the Instruction to decoder.
		//Because I think will fetch data from memory repeatedly, I make it a individual function. 
		//MAR<-PC
		this.RegisterSet2.MAR.Insert(this.RegisterSet2.PC.OutputAsInt(),0);
		//textArea.append("MAR<-PC.\n");
		this.RegisterSet2.MBR.Insert(this.RegisterSet2.Memory.Output(this.RegisterSet2.MAR.Output), 0);

		//update the PC++
		int tPC=this.RegisterSet2.PC.OutputAsInt();
		if(tPC>this.RegisterSet2.Memory.Height) {
			tPC=6;//start at 6 in memory
		}
		else {
			tPC=tPC+1;
		}
		this.RegisterSet2.PC.Insert(tPC, 0);
		//textArea.append("PC++.\n");
		//IR<-MBR
		this.RegisterSet2.IR.Insert(this.RegisterSet2.MBR.Output(0), 0);
		//textArea.append("IR<-MBR.\n");
		return this.RegisterSet2.IR.Output(0);
		
	}
}
