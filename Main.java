import java.util.*;

public class Main {

    public static void main(String[] args) {

        int[] data = SortingAlgorithms.readVolumes("data.csv");
        
        List<int[]> subsets = SortingAlgorithms.createSubsets(data);
        
        System.out.println("Random Data:\n");
        testing(subsets, "random");
        
        System.out.println("\nAlready Sorted Data:\n");
        testing(subsets, "sorted");
        
        System.out.println("\nReverse Sorted Data:n");
        testing(subsets, "reverse");
        
    }
    
    private static void testing(List<int[]> subsets, String testType) {
        
        for (int[] subset : subsets) {
            
            int[] test1 = organiseSubset(subset.clone(), testType);
            SortingAlgorithms.quickSort(test1, 0, test1.length - 1);
            System.out.println("QuickSort (" + test1.length + ") Sorting completed");
            
            int[] test2 = organiseSubset(subset.clone(), testType);
            SortingAlgorithms.insertionSort(test2);
            System.out.println("InsertionSort (" + test2.length + ") Sorting completed");
            
            int[] test3 = organiseSubset(subset.clone(), testType);
            SortingAlgorithms.mergeSort(test3);
            System.out.println("MergeSort (" + test3.length + ") Sorting completed");
            
            int[] test4 = organiseSubset(subset.clone(), testType);
            SortingAlgorithms.shellSort(test4);
            System.out.println("ShellSort (" + test4.length + ") Sorting completed");
            
            int[] test5 = organiseSubset(subset.clone(), testType);
            SortingAlgorithms.radixSort(test5, 10);
            System.out.println("RadixSort (" + test5.length + ") Sorting completed");
            
            System.out.println();
        }
    }
    
    private static int[] organiseSubset(int[] array, String type) {
        
        if (type.equals("random")) {
            shuffle(array);
        } else if (type.equals("reverse")) {
            reverseArray(array);
        }
     
        return array;
    }
    
    private static void shuffle(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    
    private static void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
    }
}
