// 15822108 情報テクノロジー学科 堀田大智
package task12_3;

public class NonLinearSolver {
	private int maxIter;
	static final double EPS = 1e-10;
	
	public NonLinearSolver(int maxIter) {
		this.maxIter = maxIter;
	}
	
	public NonLinearSolver() {
		maxIter = 30;
	}
	
	double solveNewton(double init_x) {
		int n = 0;
		double d;
		
		do {
			d = -f(init_x) / df(init_x);
			init_x = init_x + d;
			n++;
		}while(Math.abs(d) > EPS && n < maxIter);
		
		if(Double.isNaN(init_x)) {
			throw new ArithmeticException("Newton's method didn't converge after " + maxIter + " iterations.");
		}else {
			return init_x;
		}

	}
	
	double f(double x) {
		return Math.exp(x) - Math.sin(Math.PI * x / 3.0);
	}
	
	double df(double x) {
		return Math.exp(x) - (Math.PI / 3.0) * Math.cos(Math.PI * x / 3.0);
	}

	public static void main(String[] args) {
		if(args.length == 0) {
			System.err.println("Usage: (init_x1) (init_x2) ...");
			System.exit(1);
		}
		
//		for(int i = 0; i < args.length; i++) {
//			String s = args[i];
//			NonLinearSolver solver = new NonLinearSolver();
//			double init_x = Double.parseDouble(s);
//			
//			try {
//				double root = solver.solveNewton(init_x);
//				System.out.printf("searching x from %.1f, solution is %f.\n", init_x, root);
//			}catch(ArithmeticException e) {
//				System.out.printf("searching x from %.1f: ", init_x);
//				System.err.print(e);
//				System.out.println(e.getMessage());
//			}
//		}
	}

}
