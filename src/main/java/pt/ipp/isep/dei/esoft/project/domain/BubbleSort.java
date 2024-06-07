package pt.ipp.isep.dei.esoft.project.domain;

import java.io.Serializable;
import java.util.List;

public class BubbleSort implements Serializable {
    public void bubbleSortArray(double[] arr) {
        int n = arr.length;
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] < arr[j + 1]) {  // Change the comparison for descending order
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

    public void bubbleSortListGreenSpaces(List<GreenSpace> gsList) {
        int n = gsList.size();
        boolean swapped;
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (gsList.get(j).getArea() < gsList.get(j + 1).getArea()) {  // Change the comparison for descending order
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
