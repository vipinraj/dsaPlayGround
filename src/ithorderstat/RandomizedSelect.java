package ithorderstat;

import java.util.Random;

public class RandomizedSelect {

	public static void main(String[] args) {
		
		Integer A[] = {1,2,10,4,5,6,62,8,9};
		
		RandomizedSelect rs = new RandomizedSelect();
		
		System.out.println(rs.randomSelect(A, 0, A.length-1, 3));
		

	}

	public Integer randomSelect(Integer A[], int p, int r, int i) {

		if (p == r) {
			return A[p];
		}

		int q = randomizedPartition(A, p, r);

		int k = q - p + 1;

		if (i == k) {
			return A[q];
		} else if (i < k) {
			return randomSelect(A, p, q - 1, i);
		} else {
			return randomSelect(A, q + 1, r, i - k);
		}
	}

	public int randomizedPartition(Integer[] A, int p, int r) {

		Random rn = new Random();
		int i = rn.nextInt(r - p + 1) + p;

		int piv = A[i];
		int low = p;
		int high = r;

		while (true) {

			while (A[high] > piv) {
				high = high - 1;
			}

			while (A[low] < piv) {
				low++;
			}

			if (low < high) {
				int temp = A[low];
				A[low] = A[high];
				A[high] = temp;
			} else {
				return high;
			}
		}
	}
}
