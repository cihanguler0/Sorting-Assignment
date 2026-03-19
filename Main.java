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

    public static void main(String[] args) {
    // 1. Karışık bir test dizisi oluştur (CSV'deki volume verilerini temsil eder)
    int[] testData = {31880, 8408, 15628, 8882, 10260, 6071, 7186, 9419};

    System.out.println("Sıralama Öncesi:");
    printArray(testData);

    // 2. Test etmek istediğin algoritmayı çağır
    // quickSort(testData, 0, testData.length - 1); // Quick Sort için bunu aç
    insertionSort(testData);                       // Insertion Sort için bunu aç

    System.out.println("\nSıralama Sonrası:");
    printArray(testData);
    
    // 3. Doğrulama Kontrolü
    if (isSorted(testData)) {
        System.out.println("\nTEBRİKLER: Dizi başarıyla sıralandı! ✅");
    } else {
        System.out.println("\nHATA: Dizi hala karışık! ❌");
    }
}

// Diziyi ekrana yazdıran yardımcı metod
public static void printArray(int[] A) {
    for (int value : A) {
        System.out.print(value + " ");
    }
    System.out.println();
}

// Dizinin gerçekten küçükten büyüğe olup olmadığını kontrol eden metod
public static boolean isSorted(int[] A) {
    for (int i = 0; i < A.length - 1; i++) {
        if (A[i] > A[i + 1]) return false;
    }
    return true;
}
}
