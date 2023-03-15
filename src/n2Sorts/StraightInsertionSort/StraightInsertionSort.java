package n2Sorts.StraightInsertionSort;

import java.util.Scanner;

public class StraightInsertionSort { // Shuttle Sort

    // 단순 삽입 정렬
    static void StraightInsertionSort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            int j;
            int tmp = a[i];
            for (j = i; j > 0 && a[j - 1] > tmp; j--)
                a[j] = a[j - 1];
            a[j] = tmp; // 서로 떨어져 있는 요소들을 교환하지 않기 때문에 안정적
            // 정렬이 이미 되었거나 정렬된 상태에 가까우면 속도가 빠름
            // 그러나 삽입할 곳이 멀리 떨어지면, 이동하는 횟수가 많아져 느려짐
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("단순 삽입 정렬");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        StraightInsertionSort(x, nx);

        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]:" + x[i]);
    }
}
