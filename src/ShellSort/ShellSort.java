package ShellSort;

import java.util.Scanner;

public class ShellSort { // 단순 삽입 정렬의 단점(삽입할 곳이 멀리 떨어지면, 이동하는 횟수가 많아져 느려짐)을 보완 O(n^2)의 복잡도

    static void ShellSort(int[] a, int n) {
        for (int h = n / 2; h > 0; h /= 2) { // 배열을 2배수씩 쪼개서 정렬 h값은 마지막에 1이됨
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

        System.out.println("셸 정렬(v1)");
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
