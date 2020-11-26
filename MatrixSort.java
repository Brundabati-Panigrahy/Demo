package matrix;

import java.util.Scanner;

public class MatrixSort {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the diomension of array");
		int size = sc.nextInt();
		System.out.println("Insert the values to the matrix");
		int[][] matrix = insertElement(size);
		System.out.println("The original array:");
		display(matrix);

		sortLeft(matrix);
		System.out.println("After left diagonal sort");
		display(matrix);

		sortRight(matrix);
		System.out.println("After right diagonal sort");
		display(matrix);
		int[] array = convert(matrix);
		System.out.println("The matrix in 1D is");
		display(array);
		sortArray(array);
		System.out.println("After sorting 1D:");
		display(array);
		System.out.println("Enter the element to search in matrix");
		int key = sc.nextInt();
		int index = searchElement(array, key);
		if (index == -1)
			System.out.println("Element not found");
		else
			System.out.println("The position is:" + index);

	}

	private static void sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array.length - i - 1; j++) {
				if (array[j + 1] < array[j]) {
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
			}
		}

	}

	private static void display(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
	}

	private static int searchElement(int[] array, int key) {
		int start = 0;
		int end = array.length - 1;
		int mid;
		while (start <= end) {
			mid = (start + end) / 2;
			if (array[mid] == key)
				return (mid + 1);
			else if (array[mid] < key)
				start = mid + 1;
			else
				end = mid - 1;
		}
		return -1;
	}

	private static int[] convert(int[][] matrix) {
		int[] array = new int[matrix.length * matrix.length];
		int k = 0;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				array[k] = matrix[i][j];
				k++;
			}
		}
		return array;
	}

	private static void display(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
		}

	}

	private static void sortRight(int[][] matrix) {
		for (int i = 1; i < matrix.length; i++) {
			int key = matrix[i][matrix.length - i - 1];
			int j = i - 1;
			while (j >= 0 && matrix[j][matrix.length - 1 - j] > key) {
				matrix[j + 1][matrix.length - j - 2] = matrix[j][matrix.length - 1 - j];
				j--;
			}
			matrix[j + 1][matrix.length - 2 - j] = key;
		}

	}

	/*private static void sortLeft(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 1; j < matrix.length - i; j++) {
				if (matrix[j - 1][j - 1] > matrix[j][j]) {
					int temp = matrix[j - 1][j - 1];
					matrix[j - 1][j - 1] = matrix[j][j];
					matrix[j][j] = temp;
				}
			}
		}

	}*/
	 

	private static void sortLeft(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length - i - 1; j++) {
				if (matrix[j + 1][j + 1] < matrix[j][j]) {
					int temp = matrix[j + 1][j + 1];
					matrix[j + 1][j + 1] = matrix[j][j];
					matrix[j][j] = temp;
				}
			}
		}

	}

	private static int[][] insertElement(int size) {
		int[][] matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = sc.nextInt();
			}

		}
		return matrix;
	}
}

