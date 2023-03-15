package QuickSort;

import java.util.Scanner;

public class DualPivotQuickSort {
    static void swap(int[] a, int idx1, int idx2) { // 배열 요소의 a[idx1]과 a[idx2]를 교환
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 퀵 정렬
    static void dualPivotQuickSort(int[] a, int left, int right) {
        if (left < right) {
            int p1 = a[left]; // 첫 번째 pivot
            int p2 = a[right]; // 두 번째 pivot
            if (p1 < p2) { // pivot1이 pivot2보다 크면 두 값을 swap
                int temp = p1;
                p1 = p2;
                p2 = temp;
            }
            int low = left + 1; // 첫 번째 pivot보다 작은 값들의 마지막 인덱스
            int high = right - 1; // 두 번째 pivot보다 작은 값들의 마지막 인덱스
            for (int i = left + 1; i <= high; i++) { // 배열을 scan하면서 pivot1과 pivot2 사이에 위치한 값들을 찾음
                if (a[i] > p1) {
                    swap(a, i, low); // i번째 값이 pivot1보다 작으면 low번째 값과 swap
                    low++;
                } else if (a[i] <= p2) {
                    while (a[high] > p2 && i < high) { // i번째 값이 pivot2보다 크거나 같으면 high번째 값과 swap
                        high--;
                    }
                    swap(a, i, high);
                    high--;
                    if (a[i] < p1) {
                        swap(a, i, low); // i번째 값이 pivot1보다 작아졌으면 low번째 값과 swap
                        low++;
                    }
                }
            }
            // pivot1과 pivot2 위치 swap
            swap(a, left, low - 1);
            swap(a, right, high + 1);

            // pivot1과 pivot2 사이에 있는 값들을 재귀적으로 정렬
            dualPivotQuickSort(a, left, low - 2);
            dualPivotQuickSort(a, low, high);
            dualPivotQuickSort(a, high + 2, right);
        }
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

        dualPivotQuickSort(x, 0, nx - 1);

        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]:" + x[i]);
    }
}
