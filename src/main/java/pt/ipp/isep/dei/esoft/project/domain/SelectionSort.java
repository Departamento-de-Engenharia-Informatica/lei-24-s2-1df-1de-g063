package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.List;

/**
 * Implements selection sort algorithms for arrays and lists of GreenSpace objects.
 */
public class SelectionSort implements Serializable {

    /**
     * Sorts a double array using the selection sort algorithm.
     *
     * @param array The array to be sorted.
     */
    public void selectionSortArray(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] > array[maxIndex]) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                double temp = array[i];
                array[i] = array[maxIndex];
                array[maxIndex] = temp;
            }
        }
    }

    /**
     * Sorts a list of GreenSpace objects based on their area using the selection sort algorithm.
     *
     * @param gsList The list of GreenSpace objects to be sorted.
     */
    public void selectionSortListGreenSpaces(List<GreenSpace> gsList) {
        for (int i = 0; i < gsList.size() - 1; i++) {
            int maxIndex = i;
            for (int j = i + 1; j < gsList.size(); j++) {
                if (gsList.get(j).getArea() > gsList.get(maxIndex).getArea()) {
                    maxIndex = j;
                }
            }
            if (maxIndex != i) {
                GreenSpace temp = gsList.get(i);
                gsList.set(i, gsList.get(maxIndex));
                gsList.set(maxIndex, temp);
            }
        }
    }
}
