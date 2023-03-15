package QuickSort;

import java.util.Scanner;

class Partition {
    static void swap(int[] a, int idx1, int idx2) { // 배열 요소의 a[idx1]과 a[idx2]를 교환
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    // 배열을 나눔
    static void partition(int[] a, int n) {
        int pl = 0; //왼쪽 포인터
        int pr = n - 1; //오른쪽 포인터
        int x = a[n / 2]; // 피벗

        do {
            while (a[pl] < x) pl++;
            while (a[pr] > x) pr--;
            if (pl <= pr)
                swap(a, pl++, pr--);
        } while (pl <= pr);

        System.out.println("피벗 값은 " + x + "입니다");

        System.out.println("피벗 이하의 그룹");
        for (int i = 0; i <= pl - 1; i++)
            System.out.println(a[i] + " "); // a[0] ~ a[pl -1]
        System.out.println();

        if (pl > pr + 1) {
            System.out.println("피벗과 같은 그룹");
            for (int i = pr + 1; i <= pl - 1; i++)
                System.out.println(a[i] + " "); // a[pr + 1] ~ a[pl -1]
            System.out.println();
        }

        System.out.println("피벗과 이상의 그룹");
        for (int i = pr + 1; i < n; i++)
            System.out.println(a[i] + " "); // a[pr + 1] ~ a[pl -1]
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("배열을 나눕니다");
        System.out.println("요솟수: ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.println("x[" + i + "]:");
            x[i] = stdIn.nextInt();
        }

        partition(x, nx);
    }
}
