// Warehouse.java
package main.java.com.bhc.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Warehouse {
    private String name;
    private double maxCapacity; // in kgs
    private List<Line> lines;

    public Warehouse(String name, double maxCapacity) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.lines = new ArrayList<>();
    }

    // Abstract methods
    public abstract void loadPackage(LogisticsPackage pkg, Line line);

    public abstract void offloadPackage(LogisticsPackage pkg);

    public abstract void discardPackage(LogisticsPackage pkg);

    // Concrete methods
    public void addLine(Line line) {
        if (lines.size() < getMaxLines()) {
            lines.add(line);
        } else {
            throw new IllegalStateException("Maximum number of lines reached.");
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public String getName() {
        return name;
    }

    public double getMaxCapacity() {
        return maxCapacity;
    }

    protected abstract int getMaxLines();
}