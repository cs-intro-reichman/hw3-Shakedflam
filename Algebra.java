public class Algebra {
	public static void main(String args[]) {
	    System.out.println(plus(-1,-3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,-7));  // 2 - 7
 		System.out.println(times(3,-4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(-3,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(-12,3));   // 12 / 3    
   		System.out.println(div(5,-5));    // 5 / 5  
   		System.out.println(div(-25,-7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	public static int plus(int x1, int x2) {
		int sum=x1;
		if(x2<0){
			for (int j=0;j>x2;j--){
				sum--;
			}
			return sum;
		}
		  for (int i=0;i<x2;i++){
		  	sum++;
		}
		return sum;
	}

	public static int minus(int x1, int x2) {
		int reduction=x1;
		if (x2<0){
			for(int j=0;j>x2;j--){
				reduction++;
			}
			return reduction;
		}
		for(int i=0;i<x2;i++){
			reduction--;
		}
		return reduction;
	}

	public static int times(int x1, int x2) {
		if (x1==0 || x2==0){
			return 0;
		}
		int timesResult=0;
		if (x1>0 && x2>0){
        for (int i=0;i<x2;i++){
			timesResult=plus(timesResult, x1);
		}
		return timesResult;
		} else if (x1<0 && x2<0){
			for (int p=0;p>x2;p--){
				timesResult=minus(timesResult, x1);
		}
		return timesResult;
	    }   
	        if (x1<0) {
		    	for (int j=0;j<x2;j++){
				   timesResult=plus(timesResult, x1);
			    }
			    return timesResult;
	    	}else {
			   for (int k=0;k>x2;k--){
				  timesResult=minus(timesResult, x1);
			    }
			     return timesResult;
		    }
	}

	public static int pow(int x, int n) {
		int powResult=x;
		if (x<0){
			powResult=times(x, -1);
		}
		if (n==0){
			return 1;
		}
			for (int i=1;i<n;i++){
				powResult=times(powResult, x);
			}
			if (x<0 && mod(n, 2)!=0){
			return times(powResult, -1);
			}
			return powResult;
	}

	public static int div(int x1, int x2) {
	 int repitation=0;
	 int firstNum=x1;
	 int secondNum=x2;
      if(firstNum==secondNum){
		return 1;
	  }
	  if (firstNum<0){
		firstNum=times(firstNum, -1);
	  }
	  if (secondNum<0){
		secondNum=times(secondNum, -1);
	  }
	   if( firstNum < secondNum){
		return 0;
	  }else{ 
		while (firstNum >= secondNum){
			firstNum=minus(firstNum, secondNum);
			repitation++;
		}
	  }
	  if (( firstNum>0 && secondNum>0 ) || ( firstNum<0 && secondNum<0)){
		return repitation;
	  }
	  return times(repitation, -1);
	}

	public static int mod(int x1, int x2) {
        int divideResult=div(x1,x2);
		divideResult*=x2;
		x1-=divideResult;
		return x1;
	}	

	public static int sqrt(int x) {
		if (x<0){
			return -1;
		}
		if (x==0){
			return 0;
		}
		int result=1;
		while (times(result, result)<=x){
			result++;
		}
		return minus(result, 1);
	}	  	  
}