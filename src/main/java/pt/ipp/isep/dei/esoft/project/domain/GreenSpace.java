package pt.ipp.isep.dei.esoft.project.domain;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public class GreenSpace {
    private final String name;
    private final double area;
    private Tamanho tamanho;
    public static enum Tamanho {
        Garden, Medium_Size, Large_Size
    }
    public GreenSpace(String name, double area, Tamanho tamanho) {
        this.name = name;
        this.area = area;
        this.tamanho = tamanho;
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
                ", tamanho=" + tamanho +
                '}';
    }
}
