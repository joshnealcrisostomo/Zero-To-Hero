package Sorting_Algorithms;

public class SortingAlgorithms {
    private long insertionSteps, selectionSteps, mergeSteps, bubbleSteps;

    public void insertionSort(Record[] arr, int n) {
        insertionSteps = 0;
        int i, j;
        Record temp;

        for(i = 1; i < n; i++) { // Starts at index 1.
            temp = arr[i]; // Store the current element in a temp variable.
            j = i - 1; // Examines the element to the left of index i.

            /* 
                Any elements of index j that are larger than the 
                value in temp will be shifted one index to the right.

                The process will only stop if the current element of index j
                is less than the current value in temp OR until there are no
                elements left to compare.
            */
            while(j >= 0 && arr[j].getIdNumber() > temp.getIdNumber()) {
                insertionSteps++;
                arr[j + 1] = arr[j];
                insertionSteps++;
                j--;
            }

            /* 
                Inserts back the current value in temp to the position one index 
                after from the index where the process stopped.
            */
            arr[j + 1] = temp; 
            insertionSteps++;
        }
    }

    public void selectionSort(Record[] arr, int n) {
        selectionSteps = 0;
        int i, j, min;
        Record temp;

        // Loops through the array data from the beginning (0) to the second to the last value (n-1)
        for(i = 0; i < n - 1; i++) {
            // For every iteration, the min will always be initialized as the next index.
            min = i; // Keeps track of the current index i.

            for(j = i + 1; j < n; j++) {
                selectionSteps++;
                /*
                    Checks if the current minimum value is larger than
                    the current value in index j.

                    If it is larger, then assign index j as the new minimum index.
                */
                if(arr[min].getIdNumber() > arr[j].getIdNumber()) {
                    min = j;
                }
            }

            /*
                Swap the element at index i with the element at index min, if i is not equal to min.
            */
            if(i != min) {
                temp = arr[i];
                arr[i] = arr[min];
                arr[min] = temp;
                selectionSteps += 3;
            }
        }
    }

    public void mergeSort(Record[] arr, int p, int r) {
        int mid;
        mergeSteps = 0;

        /*
            Checks if there are at least 2 values within the array.

            If there are at least two values, then calculate the midpoint
            or middle value of the array by adding p (index 0) and r (last index)
            and divide the sum by 2.

            Use recursion to sort the left and right side of the array.

            After sorting the left and right side, merge both sides again.
        */
        if(p < r) {
            mid = (p + r) / 2;
            mergeSort(arr, p, mid); // Left side
            mergeSort(arr, mid + 1, r); // Right side
            merge(arr, p, mid, r); // Merge both sides
            mergeSteps++;
        }
    }

    private void merge(Record[] arr, int p, int mid, int r) {
        int leftSize, rightSize;
        int i, j, k;

        // Calculates the size of both the left and right sides
        leftSize = mid - p + 1;
        rightSize = r - mid; 

        // Declares temp arrays for the left and right side with their respective sizes.
        Record[] leftArr = new Record[leftSize];
        Record[] rightArr = new Record[rightSize];

        for(i = 0; i < leftSize; i++) {
            // Copies the elements from the original array to the left temp array.
            leftArr[i] = arr[p + i];
            mergeSteps++;
        }

        for(j = 0; j < rightSize; j++) {
            // Copies the elements from the original array to the right temp array.
            rightArr[j] = arr[mid + 1 + j];
            mergeSteps++;
        }

        // Resets the values of i and j.
        i = 0;
        j = 0;

        // k is initialized with p (index 0).
        k = p;

        /*
            Compares the elements of the left and right sub arrays.

            Merges the two sides together into the original array.
        */
        while(i < leftSize && j < rightSize) {
            mergeSteps++;
            /*
                If the element in the left array is less then or equal to
                the element in the right array, then put the left array element
                to the original array and increment its index.

                Otherwise, put the right array element to the original array
                and increment its index.

                Increment k to move to the next index of the original array after adding
                an element.
            */
            if(leftArr[i].getIdNumber() <= rightArr[j].getIdNumber()) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            mergeSteps++;
            k++;
        }


        /*
            If there are any remaining elements in both sides, then they are copied
            to the original array.
        */
        while(i < leftSize) {
            arr[k] = leftArr[i];
            i++;
            k++;
            mergeSteps++;
        }

        while(j < rightSize) {
            arr[k] = rightArr[j];
            j++;
            k++;
            mergeSteps++;
        }
    }

    public void bubbleSort(Record[] arr, int n) {
        int i, j;
        Record temp;
        bubbleSteps = 0;

        // Loops through the array data from the beginning (0) to the second to the last value (n-1)
        for(i = 0; i < n - 1; i++) {
            for(j = 0; j < n - i - 1; j++) {
                bubbleSteps++;
                /*
                    Compares adjacent elements

                    If the current value at index j is greater than the next value,
                    then swap the values.
                */
                if(arr[j].getIdNumber() > arr[j + 1].getIdNumber()) {
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    bubbleSteps += 3;
                }
            }
        }
    }

    public void printInsertionSteps() {
        System.out.println("INSERTION STEPS: " + insertionSteps + "\n");
    }

    public void printSelectionSteps() {
        System.out.println("SELECTION STEPS: " + selectionSteps + "\n");
    }

    public void printMergeSteps() {
        System.out.println("MERGE STEPS: " + mergeSteps + "\n");
    }

    public void printBubbleSteps() {
        System.out.println("BUBBLE STEPS: " + bubbleSteps + "\n");
    }
}