import java.lang.Math;
import java.util.stream.Collectors;
import java.lang.Integer;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.FileReader;
import java.io.BufferedReader;

class P81 {
	public static void main(String args[]) throws FileNotFoundException, IOException {
		List<int[]> listTable = new ArrayList();
		BufferedReader csvReader = new BufferedReader(new FileReader("./p081_matrix.txt"));
		String line = null;

		while ((line = csvReader.readLine()) != null) {
			String[] data = line.split(",");
			int[] ints = new int[data.length];
			for (int i = 0; i < data.length; i++) {
				ints[i] = Integer.parseInt(data[i]);
			}
			
			listTable.add(ints);
		}

		// int[][] table = (int[][]) listTable.toArray();
		int[][] table = new int[listTable.size()][];
		table = listTable.toArray(table);

		// initialize path sum table
		int[][] sumTable = new int[table.length][table[0].length];


		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[0].length; j++) {
				sumTable[i][j] = 0;
			}
		}

		sumTable[0][0] = table[0][0];

		// populate first row and first column
		for (int i = 1; i < 80; i++) {
			sumTable[0][i] = sumTable[0][i-1] + table[0][i];
		}

		for (int i = 1; i < 80; i++) {
			sumTable[i][0] = sumTable[i-1][0] + table[i][0];
		}

		for (int row = 1; row < 80; row++) {
			for (int col = 1; col < 80; col++) {
				sumTable[row][col] = table[row][col] + Math.min(sumTable[row-1][col], sumTable[row][col-1]);
			}
		}

		System.out.println(sumTable[79][79]);
	}
}