public class FactMain {
  public static void main(String args[]) {
    for (int counter = 0; counter <= 10; counter++) {
      System.out.printf("%d! = %d\n", counter, factorial(counter));
    }
  }

  // recursive declaration of method factorial
  public static long factorial(long number) {
    if (number <= 1) { // test for base case
      return 1;
    } // base cases: 0! = 1 and 1! = 1
    else {
      // recursion step
      return number * factorial(number - 1);
    }
  }
  public void removeBracket() {
		if (brackets > 0) {
			brackets--;
		}else {
			count -= lastcount;
		}
	}
  public int getTotalCi() {
		int total = 0;

		for (int i = 0; i < ci_units.size(); i++) {
			total += ci_units.get(i);
		}

		return total;
	}
}