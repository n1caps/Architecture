package CISC;

public class Cache {
	int[][][]	AM;//Associative Memory
	int[][][][]	HSM;//High Speed Memory
	int HSMHeight;
	int[] HSMpointer;//[line] check the HSM whether full of instruction.
	int[][] HSMcheck;//check the HSM whether is empty, 1 is no, 0 is empty.
	int nword;//how many words in a units.
	public Cache(MainMemory Memory, int HSMHeight) {
		//[line,row,word,bits]
		//the row of high speed memory is less than memory
		this.HSM=new int[Memory.nline][HSMHeight][Memory.nword][Memory.Length+1];//16+1,the first one is record the order.
		//the row and line of Associative memory as same as Memory
		//nword
		this.nword=Memory.nword;
		this.AM=new int[Memory.nline][Memory.nrow][2];
		for(int i=0;i<Memory.nline;i++) {
			for(int j=0;j<Memory.nrow;j++) {
				this.AM[i][j][0]=0;
			}
		}
		
		//initiate the HSMpointer
		this.HSMpointer=new int[Memory.nline];
		for(int i=0;i<Memory.nline;i++) {
			this.HSMpointer[i]=1;//start from 1,is 0 means no data
		}
		
		//initiate the HSMcheck
		this.HSMcheck=new int[Memory.nline][HSMHeight];
		for(int i=0;i<Memory.nline;i++) {
			for(int j=0;j<HSMHeight;j++) {
				this.HSMcheck[i][j]=0;
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
			this.InsertAddress(line, row,Memory);
			//insert a unit word into HSM
			return this.Search(line, row, word, Memory);
		}
	};
	
	private void InsertAddress(int line, int row, MainMemory Memory) {
		int flag=0;
		for(int i=0;i<this.HSMHeight;i++) {
			if(this.HSMcheck[line][i]==0) {
				flag=1;
				for(int j=0;j<this.nword;j++) {
					for(int n=0;n<Memory.Length;n++) {
						int[] temp=Memory.Output(Memory.nline*line+Memory.nrow*row);
						this.HSM[line][i][j][n]=temp[n];
						this.HSMcheck[line][i]=HSMpointer[line];//insert into check
						this.HSMpointer[line]++;//set the pointer express the order
					}
				}
			}
		}
		if(flag==0) {//flag==0 means there no place to insert.
			for(int i=0;i<this.HSMHeight;i++) {
				if(this.HSMcheck[line][i]==1) {//the first one
					for(int j=0;j<this.nword;j++) {//insert
						for(int n=0;n<Memory.Length;n++) {
							int[] temp=Memory.Output(Memory.nline*line+Memory.nrow*row);
							this.HSM[line][i][j][n]=temp[n];
							this.HSMcheck[line][i]=HSMpointer[line];//insert into check
							//because no place to insert so we dont need to point++
						}
					}
					for(int n=0;n<HSMHeight;n++) {//all HSMcheck--
						this.HSMcheck[line][n]--;
					}
				}
			}
		}
	}
}
