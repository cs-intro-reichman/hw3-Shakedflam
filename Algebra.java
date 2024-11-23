// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations
	    System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));      // 5^3
   		System.out.println(pow(3,5));      // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) {
		int sum=x1;
		for (int i=0;i<x2;i++){
			sum++;
		}
		return sum;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) {
		int reduction=x1;
		for(int i=0;i<x2;i++){
			reduction--;
		}
		return reduction;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) {
		int timesResult=0;
        for (int i=0;i<x2;i++){
			timesResult=plus(timesResult, x1);
		}
		return timesResult;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) {
		int powResult=x;
		if (n==0){
			return 1;
		}else {
			for (int i=1;i<n;i++){
				powResult=times(powResult, x);
			}
			return powResult;
		}
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) {
      if(x1==x2){
		return 1;
	  }else if(x1<x2){
		return 0;
	  }else{
		int repitation=0; 
		while (x1>=x2){
			x1=minus(x1, x2);
			repitation++;
		}
		return repitation;
	  }
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) {
        int divideResult=div(x1,x2);
		divideResult*=x2;
		x1-=divideResult;
		return x1;
	}	

	// Returns the integer part of sqrt(x) //76123
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