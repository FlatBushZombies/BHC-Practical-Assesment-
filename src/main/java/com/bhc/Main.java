// Main.java
package main.java.com.bhc;

import main.java.com.bhc.model.*;

public class Main {
    public static void main(String[] args) {
        // Create a warehouse
        Warehouse warehouse = new Warehouse("Warehouse A", 1000.0) {
            @Override
            public void loadPackage(Package pkg, Line line) {
                if (line.addPackage(pkg)) {
                    System.out.println("Package loaded into line " + line.getNumber());
                } else {
                    System.out.println("Failed to load package.");
                }
            }

            @Override
            public void offloadPackage(Package pkg) {
                // Implement offloading logic
            }

            @Override
            public void discardPackage(Package pkg) {
                // Implement discard logic
            }

            @Override
            protected int getMaxLines() {
                return 10; // Example max lines
            }
        };

        // Create a line
        Line line1 = new Line(1, PackageType.LOOSE, QualityMark.HIGH, 500.0);
        warehouse.addLine(line1);

        // Create a package
        Package pkg1 = new Package("12345", PackageType.LOOSE, QualityMark.HIGH, 10.0);

        // Load the package into the line
        warehouse.loadPackage(pkg1, line1);
    }
}