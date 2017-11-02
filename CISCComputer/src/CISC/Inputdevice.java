package CISC;

public class Inputdevice {
	public int[] Data;
	public int point;
	public Inputdevice() {
		Data=new int[100];
		point=0;
	}
	
	public void filter(String InputData) {
		if(isInteger(InputData))
		{
			Data[0] = Integer.parseInt(InputData);
		}else {
			int length=InputData.length();
			int temp = 0;
			int j=0;
			for(int i=0;i<length;i++) {
				temp += InputData.charAt(i);
			}
			Data[0] = temp;
		}
	}

	public int Output() {
		int num=this.Data[this.point];
		//this.point++;
		return num;
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
