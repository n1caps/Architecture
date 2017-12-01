package CISC;

public class BPrediction {
	public int[][] Record;
	public int pointer=0;
	public BPrediction() {//first is position, second is state;
		Record=new int[100][2];
	}
	
	public void ChangeState(int position, int tag) {
		int index=this.FindState(position);
		if(tag==1) {
			if(this.Record[index][1]==0) {
				this.Record[index][1]=1;
			}
			else if(this.Record[index][1]==1) {
				this.Record[index][1]=2;
			}
			else if(this.Record[index][1]==2) {
				this.Record[index][1]=3;
			}
			else {
				
			}
		}
		else if(tag==0) {
			if(this.Record[index][1]==3) {
				this.Record[index][1]=2;
			}
			else if(this.Record[index][1]==2) {
				this.Record[index][1]=1;
			}
			else if(this.Record[index][1]==1) {
				this.Record[index][1]=0;
			}
			else {
				
			}
		}
	}
	
	public int FindState(int position) {
		for(int i=0;i<100;i++) {
			if(position==this.Record[i][0]) {
				return this.Record[i][1];
			}
		}
		this.Record[this.pointer][0]=position;
		this.Record[this.pointer][1]=2;
		this.pointer++;
		return 2;
	}
}
