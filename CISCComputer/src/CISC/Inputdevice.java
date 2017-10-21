package CISC;

public class Inputdevice {
	public int[] Data;
	public String[] Sentence;
	public int point;
	public Inputdevice() {
		Data=new int[100];
		Sentence=new String[100];
		point=0;
	}
	
	public void filter(String InputData) {
		int length=InputData.length();
		String value="";
		int temp;
		int j=0;
		for(int i=0;i<length;i++) {
			if(!Character.isDigit(InputData.charAt(i))) {
				temp=Integer.valueOf(value);
				this.Data[j]=temp;
				j++;
			}
			else {
				value=value+InputData.charAt(i);
			}
		}
	}

	public int Output() {
		int num=this.Data[this.point];
		this.point++;
		return num;
	}
}
