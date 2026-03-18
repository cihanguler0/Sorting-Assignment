public class Main {

    public static void quickSort ( int A[], int low, int high) {

        int stackSize = high - low + 1;
        int[] stack = new int[stackSize];
        int top = -1;
        stack[++top] = low;
        stack[++top] = high;

        while (top>=0) {

            high = stack[top--];
            low = stack[top--];
            int pivot = partition(A, low, high);

            if (pivot - 1 > low) {

                stack[++top] = low;
                stack[++top] = pivot - 1;

            }

            if (pivot + 1 < high) {

                stack[++top] = pivot + 1;
                stack[++top] = high;

            }
        }
    }

    public static int partition( int A[], int low, int high) {

        int pivot = A[high];
        int i = low -1;

        for (int j = low; j <= high - 1; j++) {

            if (A[j] < pivot) {

                i = i+1;
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;

            }
        }

        int temp = A[i+1];
        A[i+1] = A[high];
        A[high] = temp;

        return i+1;

    }
}
