// Computes the periodical payment necessary to pay a given loan.
public class LoanCalc {
	
	static double epsilon = 0.001;  // Approximation accuracy
	static int iterationCounter;    // Number of iterations 
	
	// Gets the loan data and computes the periodical payment.
    // Expects to get three command-line arguments: loan amount (double),
    // interest rate (double, as a percentage), and number of payments (int).  
	public static void main(String[] args) {		
		// Gets the loan data
		double loan = Double.parseDouble(args[0]);
		double rate = Double.parseDouble(args[1]);
		int n = Integer.parseInt(args[2]);
		System.out.println("Loan = " + loan + ", interest rate = " + rate + "%, periods = " + n);

		// Computes the periodical payment using brute force search
		System.out.print("\nPeriodical payment, using brute force: ");
		System.out.println((int) bruteForceSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);

		// Computes the periodical payment using bisection search
		System.out.print("\nPeriodical payment, using bi-section search: ");
		System.out.println((int) bisectionSolver(loan, rate, n, epsilon));
		System.out.println("number of iterations: " + iterationCounter);
	}

	// Computes the ending balance of a loan, given the loan amount, the periodical
	// interest rate (as a percentage), the number of periods (n), and the periodical payment.
	private static double endBalance(double loan, double rate, int n, double payment) {	
		double loanAmount=loan;
		double interestRate=(rate/100)+1;;
		double periodPayment=payment;
		for (int i=0;i<n;i++){
			loanAmount=(loanAmount-periodPayment)*interestRate;
		}
		
		
		return loanAmount;
	}
	
	// Uses sequential search to compute an approximation of the periodical payment
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bruteForceSolver(double loan, double rate, int n, double epsilon) {
		iterationCounter=-1;
		double loanAmount=loan;
		double interestRate=(rate/100)+1;
		double payingPeriods=n;
		double periodPayment=loanAmount/payingPeriods;
		while (loanAmount>epsilon){
			iterationCounter++;
			loanAmount=loan;
			for (int i=0; i<n;i++){
				loanAmount-=periodPayment;
				loanAmount*=interestRate;
			}
			if (loanAmount>epsilon){
				periodPayment+=epsilon;
			}else{
				return periodPayment;
			}
			if (periodPayment>loan){
			break;
			}
		}
		return periodPayment;
    }
    
    // Uses bisection search to compute an approximation of the periodical payment 
	// that will bring the ending balance of a loan close to 0.
	// Given: the sum of the loan, the periodical interest rate (as a percentage),
	// the number of periods (n), and epsilon, the approximation's accuracy
	// Side effect: modifies the class variable iterationCounter.
    public static double bisectionSolver(double loan, double rate, int n, double epsilon) {  
		iterationCounter=0;
		double highAmount=loan;
		double lowAmount=loan/n;
		double periodPayment=(highAmount+lowAmount)/(double)2.0;
		while ((highAmount-lowAmount)>epsilon){
			iterationCounter++;
			double balance=endBalance(loan, rate, n, periodPayment);
			if (balance>0){
				lowAmount=periodPayment;
			}else{
				highAmount=periodPayment;
			}
			periodPayment=(highAmount+lowAmount)/2.0;
			if (highAmount==lowAmount) {
				break;
			}
			
        }
		return periodPayment;
    }
}