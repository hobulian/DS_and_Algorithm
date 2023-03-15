package ShellSort;

import java.util.Scanner;

public class ShellSort2 { // h값이 서로 배수가 되면, 요소끼리 충분히 섞이지 않아 비효율적임 O(n^1.25)의 복잡도

    static void ShellSort(int[] a, int n) {
        int h;
        for (h = 1; h < n; h = h * 3 + 1)  // 나누는 수는 1부터 시작해, 3을 곱한뒤 1을 더하는 수열
            ;
        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j;
                int tmp = a[i];
                for (j = i - h; j >= 0 && a[j] > tmp; j -= h)
                    a[j + h] = a[j];
                a[j + h] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("셸 정렬(v2)");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        ShellSort(x, nx);

        System.out.println("오름차순으로 정렬됨");
        for (int i = 0; i < nx; i++)
            System.out.println("x[" + i + "]:" + x[i]);
    }
}
