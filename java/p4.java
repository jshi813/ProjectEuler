class P4 {
	public static void main(String args[]) {
		int product;
		int largestP = 0;
		for (int i = 999; i >= 100; i--) {
			for (int j = 999; j >= 100; j--) {
				product = i * j;
				// System.out.println(product);
				if (isPalindronme(product)) {
					largestP = largestP < product ? product : largestP;
				}
			}
		}
		System.out.println(largestP);
	}

	static boolean isPalindronme(int n) {
		String s = String.valueOf(n);
		// System.out.println(s);
		char[] charArr = s.toCharArray();
		int i = 0;
		int j = charArr.length-1;

		while (i <= j) {
			if (charArr[i] != charArr[j]) {
				return false;
			}
			i++;
			j--;
		}

		return true;
	}
}