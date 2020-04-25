import java.util.ArrayList;
import java.lang.Long;
import java.util.List;

class P3 {
	public static void main(String args[]) {
		long largestPrime = 1;
		long num = 600851475143L;
		List<Long> primes = new ArrayList();

		long i = 2L;

		while (i <= num) {
			if (isPrime(i)) {
				while (isDivisible(num, i)) {
					largestPrime = i;
					num = num/i;
				}
			}
			i++;
		}

		System.out.println(largestPrime);
	}

	static boolean isDivisible(long n, long divider) {
		if (n % divider == 0) {
			return true;
		} else {
			return false;
		}
	}

	static boolean isPrime(long n) {
		for (long i = 2; i < n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}