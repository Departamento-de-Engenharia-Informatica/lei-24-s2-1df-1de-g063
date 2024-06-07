package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Serializable {

    public void mergeSortArray(double[] arr) {
        mergeSortArr(arr, 0, arr.length - 1);
    }

    public void mergeSortGreenSpaces(List<GreenSpace> gsList) {
        mergeSortList(gsList, 0, gsList.size() - 1);
    }

    private static void mergeSortArr(double[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // left half
            mergeSortArr(arr, left, middle);
            // right half
            mergeSortArr(arr, middle + 1, right);

            // merge left and right
            mergeArr(arr, left, middle, right);
        }
    }

    private static void mergeArr(double[] arr, int left, int middle, int right) {
        // sub-array lengths
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // temp arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // copy data to temp arrays
        System.arraycopy(arr, left, leftArray, 0, n1);
        System.arraycopy(arr, middle + 1, rightArray, 0, n2);

        // initial indexes for merging the sub-arrays
        int i = 0, j = 0, k = left;

        // merge the sub-arrays
        while (i < n1 && j < n2) {
            if (leftArray[i] >= rightArray[j]) {
                arr[k] = leftArray[i];
                i++;
            } else {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // copy the remaining elements from the left subarray, if any
        while (i < n1) {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        // copy the remaining elements from the right subarray, if any
        while (j < n2) {
            arr[k] = rightArray[j];
            j++;
            k++;
        }
    }

    private static void mergeSortList(List<GreenSpace> gsList, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            // left half
            mergeSortList(gsList, left, middle);
            // right half
            mergeSortList(gsList, middle + 1, right);

            // merge left and right
            mergeList(gsList, left, middle, right);
        }
    }

    private static void mergeList(List<GreenSpace> gsList, int left, int middle, int right) {
        // sub-list lengths
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // temporary lists
        List<GreenSpace> leftList = new ArrayList<>(gsList.subList(left, middle + 1));
        List<GreenSpace> rightList = new ArrayList<>(gsList.subList(middle + 1, right + 1));

        // initial indexes for merging the sub-lists
        int i = 0, j = 0, k = left;

        // merge the sub-lists
        while (i < n1 && j < n2) {
            if (leftList.get(i).getArea() >= rightList.get(j).getArea()) {
                gsList.set(k, leftList.get(i));
                i++;
            } else {
                gsList.set(k, rightList.get(j));
                j++;
            }
            k++;
        }

        // copy the remaining elements from the left sub-list, if any
        while (i < n1) {
            gsList.set(k, leftList.get(i));
            i++;
            k++;
        }

        // copy the remaining elements from the right sub-list, if any
        while (j < n2) {
            gsList.set(k, rightList.get(j));
            j++;
            k++;
        }
    }
}
