package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;

public class GreenSpace {
    private final String name;
    private final double area;
    private final Size size;
    private String email;

    public GreenSpace(String name, double area, Size size, String email) {
        this.name = name;
        this.area = area;
        this.size = size;
        this.email = email;
    }

    private void validateGreenSpaceName(String greenSpaceName) {
        if (greenSpaceName.isEmpty()) {
            throw new IllegalArgumentException("The Green Space Name must not be empty");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
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
                ", email='" + email + '\'' +
                '}';
    }
}
