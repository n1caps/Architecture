package CISC;

public class MainMemory extends Register{
	int nline;
	int nrow;
	int nword;
	int[][] Address_Table;
	public MainMemory(int bits, int height, int nline, int nrow, int nword) {
		super(bits, height);
		this.nline=nline;
		this.nrow=nrow;
		this.nword=nword;
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
		this.Address_Table[0][0]=0;
		for(int i=1;i<this.nline;i++) {
			this.Address_Table[i][0]=this.Address_Table[i-1][0]+this.nrow;
		}
		for(int i=0;i<this.nline;i++) {
			for(int j=1;j<this.nrow;j++) {
				this.Address_Table[i][j]=this.Address_Table[i][j-1]+this.nword;
			}
		}
	}

}
