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

    public static void insertionSort(int A[]){

        for (int j = 1; j < A.length; j++) {

            int key = A[j];
            int i = j-1;

            while (i >= 0 && A[i] > key) {

                A[i+1] = A[i];
                i = i-1;
            
            }
            
            A[i+1] = key;

        }    
    }

    public static void mergeSort(int A[]){

        int n = A.length;
        int[] temp = new int [n];
        int currSize = 1;
        while (currSize < n){

            int leftStart = 0;

            while (leftStart < n-1){

                int mid = Math.min(leftStart + currSize - 1, n-1);
                int rightEnd = Math.min(leftStart + 2*currSize-1, n-1);
                merge(A, temp, leftStart, mid, rightEnd);
                leftStart = leftStart + currSize*2;

            }

            currSize = currSize*2;

        }
    }

    public static void merge(int A[], int temp[], int left, int mid, int right){

        int i = left;
        int j = mid + 1;
        int k = left;

        while (i <= mid && j <= right){

            if (A[i] <= A[j]){

                temp[k] = A[i];
                i = i+1;

            } else{

                temp[k] = A[j];
                j = j+1;

            }

            k = k+1;

        }

        while (i <= mid){

            temp[k] = A[i];
            i = i+1;
            k = k+1;

        }

        while (j <= right){

            temp[k] = A[j];
            j = j+1;
            k = k+1;

        }

        for (i = left; i <= right; i++){

            A[i] = temp[i];

        }
    }

    public static void shellSort(int A[]){

        int n = A.length;
        int h = 1;

        while (h < (n/3)){

            h = 3*h + 1;

        }

        while (h >= 1){

            for (int i = h; i <= n-1; i++){

                int j = i;

                while (j >=h && A[j] < A[j-h]){

                    int temp = A[j];
                    A[j] = A[j-h];
                    A[j-h] = temp;
                    j = j-h;

                }
            }

            h = h/3;
            
        }
    }
}
