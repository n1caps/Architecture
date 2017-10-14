package CISC;

public class Cache {
	//![line][row]
	int[][][]	AM;//Associative Memory  0 is whether in Cash, 1 is which line in the group
	int[][][][]	HSM;//High Speed Memory
	int HSMHeight;
	int[] HSMpointer;//[line] check the HSM whether full of instruction.
	int[][] HSMcheck;//check the HSM whether is empty, 1 is no, 0 is empty.
	int nline;
	int nrow;
	int nword;//how many words in a units.
	int[][] Table;
	int linen;
	int rown;
	int wordn;
	int Length;
	
	public Cache(int Length, int[][] Table, int nline, int nrow, int nword, int HSMHeight) {
		//[line,row,word,bits]
		//the row of high speed memory is less than memory
		this.HSM=new int[nline][HSMHeight][nword][Length];//16+1,the first one is record the order.
		//the row and line of Associative memory as same as Memory
		//nword
		this.Table=Table;
		this.nline=nline;
		this.nrow=nrow;
		this.nword=nword;
		this.Length=Length;
		this.HSMHeight=HSMHeight;
		
		this.linen=this.nline;
		this.rown=this.nrow;
		
		this.AM=new int[this.nline][this.nrow][2];
		
		//initiate the HSMpointer
		this.HSMpointer=new int[this.nline];
		for(int i=0;i<this.linen;i++) {
			this.HSMpointer[i]=1;//start from 1,is 0 means no data
		}
		
		//initiate the HSMcheck
		this.HSMcheck=new int[this.nline][HSMHeight];
	};
	

	
	public int[] Search(int line, int row, int word, int[][] Memory) {//search data from Memory
		int flag=0;//judge whether can find in the
		int HSMrow=0;//
		if(this.AM[line][row][0]==1) {//Memory in the Cashe
			flag=1;
			HSMrow=this.AM[line][row][1];
		}
		if(flag==1) {
			return this.HSM[line][HSMrow][word];//fetch data from HSM
		}
		else {
			HSMrow=this.InsertAddress(line,row,word,Memory);
			//insert a unit word into HSM
			return this.HSM[line][HSMrow][word];
		}
	};
	
	private int InsertAddress(int line, int row, int word,int[][] Memory) {
		int flag=0;
		int HSMrow=0;
		for(int i=0;i<this.HSMHeight;i++) {
			if(this.HSMcheck[line][i]==0) {
				flag=1;//can insert
				HSMrow=i;
				for(int j=0;j<this.nword;j++) {//insert a block in cashe
					int[] temp=Memory[this.nline*line*this.nrow+row*this.nword+j];
					this.HSM[line][i][j]=temp;	
				}
				this.HSMcheck[line][i]=HSMpointer[line];//insert into check
				this.HSMpointer[line]++;//set the pointer express the order
				this.AM[line][row][0]=1;//means have inserted in cashe
				this.AM[line][row][1]=i;
				break;
			}
		}
		if(flag==0) {//flag==0 means there no place to insert.
			for(int i=0;i<this.HSMHeight;i++) {
				if(this.HSMcheck[line][i]==1) {//the first one
					HSMrow=i;
					for(int j=0;j<this.nword;j++) {//insert
						int[] temp=Memory[this.nline*line*this.nrow*this.nword+this.nrow*row*this.nword+j];
						for(int n=0;n<this.Length;n++) {	
							this.HSM[line][i][j][n]=temp[n];
						}
					}
					this.HSMcheck[line][i]=HSMpointer[line];//insert into check
					//because no place to insert so we dont need to point++
					for(int n=0;n<HSMHeight;n++) {//all HSMcheck--
						this.HSMcheck[line][n]--;
					}
				}
			}
		}
		return HSMrow;
	}
}
