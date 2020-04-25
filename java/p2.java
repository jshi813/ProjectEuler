import java.util.ArrayList;
import java.util.List;
import java.lang.Integer;

class P2 {
	public static void main(String args[]) 
    { 
    	List<Integer> fibs = new ArrayList();
    	
    	fibs.add(1);
    	fibs.add(2);

    	int num = 0;
    	int index = 2;

    	while (true) {
    		if (num > 4000000) {
    			break;
    		} else {
    			num = fibs.get(index-2) + fibs.get(index-1);
    			fibs.add(num);
    			index++;
    		}
    	}

    	num = 0;

    	for (int i = 0; i < index; i++) {
    		int fib = fibs.get(i);
    		if (fib % 2 == 0) {
    			num += fib;
    		}
    	}

        System.out.println(num);
    }
}