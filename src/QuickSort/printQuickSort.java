package QuickSort;

import java.util.Scanner;

public class printQuickSort {
    static void swap(int[] a, int idx1, int idx2) { // 배열 요소의 a[idx1]과 a[idx2]를 교환
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬
    static void QuickSort(int[] a, int left, int right) {
        int pl = left; //왼쪽 포인터
        int pr = right; //오른쪽 포인터
        int x = a[(pl + pr) / 2]; // 피벗

        System.out.printf("a[%d]~a[%d]: {", left, right);
        for (int i = left; i < right; i ++)
            System.out.printf("%d , ", a[i]);
        System.out.printf("%d}\n", a[right]);

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) QuickSort(a, left, pr); // 재귀호출
        if (pl < right) QuickSort(a, pl, right);
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("퀵 정렬");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        QuickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]:" + x[i]);
    }
}
