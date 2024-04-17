import java.util.*;
class Solution {
	 public String solution(int a, int b) {
		 String day = "" ; 

		 Calendar cal = Calendar.getInstance(); 
		 cal.set(2016, a -1, b);
		 int dayNum = cal.get(Calendar.DAY_OF_WEEK); 
		 switch(dayNum){ 
		 	case 1 -> day = "SUN"; 
		 	case 2 -> day = "MON"; 		 	
		 	case 3 -> day = "TUE"; 		 	
		 	case 4 -> day = "WED"; 		 	
		 	case 5 -> day = "THU"; 		 	
		 	case 6 -> day = "FRI";		 	
		 	case 7 -> day = "SAT"; 
		 } 
		 return day ;
	 }
}