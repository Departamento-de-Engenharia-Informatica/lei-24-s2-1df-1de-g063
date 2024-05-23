package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class GreenSpace {
    private final String name;
    private final double area;
    private final Size size;

    public enum Size {
        Garden, Medium_Size, Large_Size
    }

    public GreenSpace(String name, double area, Size size) {
        validateGreenSpaceName(name);
        this.name = name;
        this.area = area;
        this.size = size;
    }

    private void validateGreenSpaceName(String greenSpaceName) {
        if (greenSpaceName.isEmpty()) {
            throw new IllegalArgumentException("The Green Space Name must not be empty");
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GreenSpace that = (GreenSpace) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public String toString() {
        return "GreenSpace{" +
                "name='" + name + '\'' +
                ", area=" + area +
                ", size=" + size +
                '}';
    }
}
