package CISC;

public class Cache {
	int[][][]	AM;//Associative Memory
	int[][][][]	HSM;//High Speed Memory
	int HSMHeight;
	private int ordern=1;
	public Cache(MainMemory Memory, int HSMHeight) {
		//[line,row,word,bits]
		//the row of high speed memory is less than memory
		this.HSM=new int[Memory.nline][HSMHeight][Memory.nword][Memory.Length+1];//16+1,the first one is record the order.
		
		//the row and line of Associative memory as same as Memory
		this.AM=new int[Memory.nline][Memory.nrow][2];
		for(int i=0;i<Memory.nline;i++) {
			for(int j=0;j<Memory.nrow;j++) {
				this.AM[i][j][0]=0;
			}
		}
	};
	
	public int[] Search(int line, int row, int word, MainMemory Memory) {
		int flag=0;//judge whether can find in the
		int HSMrow=0;
		for(int i=0;i<this.HSMHeight;i++) {
			if(this.AM[line][i][0]==1) {
				flag=1;
				HSMrow=this.AM[line][i][1];
				break;
			}
		}
		if(flag==1) {
			return this.HSM[line][HSMrow][word];
		}
		else {
			this.InsertAddress(Memory.Output(line*Memory.nline+row*Memory.nrow+word*Memory.nword), int line);
		}
	};
	
	private void InsertAddress(int[][] Instruction, int line) {
		int flag=0;
		for(int i=0;i<this.HSMHeight;i++) {
			if(this.HSM[line][i]!=null) {
				flag=1;
				for(int j=0;j<16;j++) {
					HSM[line][i][j+1]=Instruction[j];
				}
			}
		}
		if(flage==1) {
			
		}
		for(int i=0;i<16;i++) {
			this.AM
		}
	}
}
