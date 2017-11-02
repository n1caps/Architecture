package CISC;

public class PrinterDevice {
	public String output;
	
	PrinterDevice(){
		output = "";
	}
	
	public void filter(String InputData) {
		/*
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
		}*/
	}

	public String Output() {
		return output;
	}

}
