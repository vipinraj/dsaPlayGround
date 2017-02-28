package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class BucketSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double A[] = { .78, .17, .39, .26, .72, .94, .21, .12, .23, .68 };

		LinkedList<Double>[] B = new LinkedList[10];

		for (int i = 0; i < A.length; i++) {

			if (B[(int) Math.floor(A[i])] == null) {
				B[(int) Math.floor(A[i])] = new LinkedList<>();
				B[(int) Math.floor(A[i])].add(A[i]);
			} else {
				B[(int) Math.floor(A[i])].add(A[i]);
			}
		}

		for (int i = 0; i < B.length; i++) {
			if (B[i] != null) {
				Collections.sort(B[i]);
			}

		}

		for (int i = 0; i < B.length; i++) {
			for (int j = 0; j < B[i].size(); j++) {
				System.out.print(B[i].get(j) + " ");
			}
		}

	}

}
