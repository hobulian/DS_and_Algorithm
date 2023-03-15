package QuickSort;

public class IntStack {
    private int[] stk; // 스택용 배열
    private int capacity; // 스택 용량
    private int ptr; // 포인터

    //예외 : 스택 비어있음
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException() {
        }
    }

    //예외 : 스택 가득참
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException() {
        }
    }

    public IntStack(int maxlen) {
        ptr = 0;
        capacity = maxlen;
        try {
            stk = new int[capacity]; // 스택 본체용 배열 생성
        } catch (OutOfMemoryError e) { // 생성불가
            capacity = 0;
        }
    }

    public int push(int x) throws OverflowIntStackException {
        if (ptr > capacity) // 스택이 가득 참
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    public int pop() throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 비어 있음
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    public int peek(int x) throws EmptyIntStackException {
        if (ptr <= 0) // 스택이 비어 있음
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    public void clear() {
        ptr = 0;
    }

    // 스택에서 x를 찾아 인덱스를 반환, 없으면 -1
    public int indexOf(int x) {
        for (int i = ptr - 1; i >= 0; i--) // 꼭대기 부터 선형 검색
            if (stk[i] == x)
                return i;
        return -1;
    }

    public int getCapacity() {
        return capacity;
    }

    public int size() {
        return ptr;
    }

    public boolean isEmpty() {
        return ptr <= 0;
    }

    public boolean isFull() {
        return ptr >= capacity;
    }

    public void dump() {
        if (ptr <= 0)
            System.out.println("스택이 비어 있습니다.");
        else {
            for (int i = 0; i < ptr; i++)
                System.out.println(stk[i] + " ");
            System.out.println();
        }
    }

}
