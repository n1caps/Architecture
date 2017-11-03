package CISC;

public class Inputdevice {
	public int[] Data;
	public int point;
	public int point_2;
	public Inputdevice() {
		Data=new int[100];
		point=0;
		point_2=0;
	}
	
	public void filter(String InputData) {//all the input save as ASCII
		int L=InputData.length();
		for(int i=0;i<InputData.length();i++) {
			this.Data[this.point]=(int)InputData.charAt(i);
			this.point++;
		}
		/*
		if(isInteger(InputData))
		{
			Data[0] = Integer.parseInt(InputData);
		}else {
			int length=InputData.length();
			int temp = 0;
			for(int i=0;i<length;i++) {
				temp += InputData.charAt(i);
			}
			Data[0] = temp;
		}
		*/
	}

	public int Output() {
		int num=this.Data[this.point_2];
		this.point_2++;
		return num;
	}
	
	public void Clear() {
		this.point_2=0;
	}
	
	public static boolean isInteger(String s) {
	    try { 
	        Integer.parseInt(s); 
	    } catch(NumberFormatException e) { 
	        return false; 
	    } catch(NullPointerException e) {
	        return false;
	    }
	    // only got here if we didn't return false
	    return true;
	}
}
