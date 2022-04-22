package main.graph;

import java.util.Objects;

public class Node {
    String color;
    Integer label;

    public Node(Integer label) {
        this.label = label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public Integer getLabel() {
        return label;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return label.equals(node.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
