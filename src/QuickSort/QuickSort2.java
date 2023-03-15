package QuickSort;

import java.util.Scanner;

public class QuickSort2 { // median - of - three
    static void swap(int[] a, int idx1, int idx2) { // 배열 요소의 a[idx1]과 a[idx2]를 교환
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //x[a], x[b], x[c]를 정렬하고, 가운데 값의 인덱스를 반환
    static int sort3elem(int[] x, int a, int b, int c) {
        if (x[b] < x[a]) swap(x, b, a);
        if (x[c] < x[b]) swap(x, c, b);
        if (x[b] < x[a]) swap(x, b, a);
        return b;
    }

    // 퀵 정렬
    static void QuickSort(int[] a, int left, int right) {
        int pl = left; //왼쪽 포인터
        int pr = right; //오른쪽 포인터
        int m = sort3elem(a, pl, (pl+pr)/2, pr); // 처음, 가운데와 끝요소 정렬
        int x = a[m]; // 피벗

        swap(a, m, right - 1); // 가운데 요소와 끝에서 두 번째 요소를 교환(이미 정렬된 요소기 때문에 불필요한 정렬 막기 위해)
        pl++; // 왼쪽 커서를 오른쪽으로 1 이동
        pr -= 2; // 오른쪽 커서를 왼쪽으로 2만큼 이동

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

        System.out.println("퀵 정렬(v2)");
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
