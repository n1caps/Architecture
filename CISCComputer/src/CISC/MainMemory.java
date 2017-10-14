package CISC;

public class MainMemory extends Register{
	int nline;//how many in each line
	int nrow;
	int nword;
	int[][] Address_Table;
	Cache cache;
	
	public MainMemory(int bits, int height, int nline, int nrow, int nword) {
		super(bits, height);
		this.nline=nline;
		this.nrow=nrow;
		this.nword=nword;
		Initiate_table();
		this.cache=new Cache(this.Length,this.Address_Table,this.nline,this.nrow,this.nword,4);
		// TODO Auto-generated constructor stub
	}

	public void updatePoint() {//Pointer++
		if(this.Height>1) {
			if(this.Pointer<this.Height-1) {
				this.Pointer++;
			}
			else {
				this.Pointer=6;//!!!!memory start at 6 
			}
		}
	}
	//create the table, divide the table to line and row.
	public void Initiate_table() {
		this.Address_Table=new int[this.nline][this.nrow];
		int n=0;
		for(int i=0;i<this.nline;i++) {
			for(int j=0;j<this.nrow;j++) {
				this.Address_Table[i][j]=n;
				n=n+this.nword;
			}
		}
	}
	
	
	public int[] Output(int[] Address){//binary is address
		this.Output=new int[this.Length];
		int decAd;
		decAd=Binary_to_dec(Address);
		if(decAd < Height) {
			this.Output = this.Separate(decAd);
		}else {
			//Return error code
			return null;
		}
		return this.Output;
	}
	
	public int[] Output(int Address) {
		this.Output=new int[this.Length];
		if(Address < Height) {
			this.Output = this.Separate(Address);
		}else {
			//Return error code
			return null;
		}
		return this.Output;
	}
	
	public int[] Separate(int EA) {//
		int line;
		int row;
		int word;
		int[] error=new int[] {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};
		for(int i=0;i<this.nline;i++) {
			if(this.Address_Table[i][0]>EA) {
				line=i-1;
				i=i-1;
				for(int j=0;j<this.nrow;j++) {
					if(this.Address_Table[i][j]>EA) {
						row=j-1;
						j=j-1;
						word=EA-(line*this.nline*this.nrow*this.nword+row*this.nword);//!?
						return this.cache.Search(line, row, word, this.Memory);
					}
				}
			}
		}
		return error;
	}
}
