package MergeSort;

import java.util.Scanner;

public class MergeSort { // 배열을 병합하는데 O(n)이 사용되고, 요소수 n개의 배열을 나누는 과정은 log n만큼 필요. 따라서 O(nlog n)
    static int[] buff; // 작업용 배열(버퍼)

    //a[left] ~ a[right]를 재귀적으로 병합 정렬
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
            int i;
            int center = (left + right) / 2;
            int p = 0;
            int j = 0;
            int k = left;

            __mergeSort(a, left, center); // 배열의 앞 부분 병합 정렬
            __mergeSort(a, center + 1, right); // 배열의 뒷 부분 병합 정렬

            for (i = left; i <= center; i++) // 배열 a의 앞 부분을 배열 buff에 복사
                buff[p++] = a[i];

            while (i <= right && j < p) // 배열 a의 뒷 부분과 배열 buff를 배열 a로 병합
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            while (j < p) // 배열 buff에 남은 요소를 배열 a로 복사
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n) {
        buff = new int[n]; // 작업용 배열 생성

        __mergeSort(a, 0, n-1);  // 배열을 병합 정렬

        buff = null; // 작업용 배열 해체
    }
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);

        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]:" + x[i]);
    }
}
