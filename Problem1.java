/* This code utilizes partitioning on an array so that all elements 
 are smaller than or equal to the desired integer. Furthermore, larger numbers appear after the desired integer. 
 */
public class Problem1 {

    /*
     Here, the code partitions the array based on first integer. 
     After partitioning, all integers less than or equal to A[0] will be on the left of it,
     while integers greater than A[0] will be on its right.
     */

    public static void MyPartition(int[] A) {
        // Stores value of partitioned integer
        int partitionElement = A[0];
        
        // Creates a temporary copy of the original array so it can save the original order
        int[] temporaryArray = new int[A.length];
        System.arraycopy(A, 0, temporaryArray, 0, A.length);

        // Calculates where number should be following partitioning integer
        int partitionIndex = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] <= partitionElement) {
                partitionIndex++;
            }
        }

        // Places new integer
        A[partitionIndex] = partitionElement;

		// Populates the original array from the temporary array with new set of integers that are based on partitioned integer
    
        int leftIndex = 0;
        int rightIndex = partitionIndex + 1;

        for (int i = 0; i < temporaryArray.length; i++) {
            if (temporaryArray[i] < partitionElement) {
                A[leftIndex] = temporaryArray[i];
                leftIndex++;
            } else if (temporaryArray[i] > partitionElement) {
                A[rightIndex] = temporaryArray[i];
                rightIndex++;
            }
        }
    }

   //How functionality performs
    public static void main(String[] args) {
        int[] A = {4,3,9,2,7,6,5};

        // Displays array before partitioning
        System.out.println("Before partition:");
        for (int value : A) {
            System.out.print(value + " ");
        }

        // Calls the partitioning method
        MyPartition(A);

        // Displays the array after partitioning
        System.out.println("\nAfter partition:");
        
        for (int value : A) {
            System.out.print(value + " ");
        }
    }
}