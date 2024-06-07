package pt.ipp.isep.dei.esoft.project.domain;

import java.util.List;

public class SelectionSort {
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
