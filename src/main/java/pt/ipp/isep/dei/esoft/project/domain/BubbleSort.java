package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.List;

/**
 * The BubbleSort class provides methods for sorting arrays and lists using the bubble sort algorithm.
 */
public class BubbleSort implements Serializable {

    /**
     * Sorts the given array of doubles in descending order using the bubble sort algorithm.
     *
     * @param arr the array to be sorted
     */
    public void bubbleSortArray(double[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    /**
     * Sorts the given list of GreenSpaces in descending order of area using the bubble sort algorithm.
     *
     * @param gsList the list of GreenSpaces to be sorted
     */
    public void bubbleSortListGreenSpaces(List<GreenSpace> gsList) {
        int n = gsList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (gsList.get(j).getArea() < gsList.get(j + 1).getArea()) {
                    GreenSpace temp = gsList.get(j);
                    gsList.set(j, gsList.get(j + 1));
                    gsList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }
}
