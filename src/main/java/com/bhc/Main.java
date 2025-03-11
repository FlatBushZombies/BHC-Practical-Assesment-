package main.java.com.bhc;

import main.java.com.bhc.model.*;
import main.java.com.bhc.service.WarehouseService;

public class Main {
    public static void main(String[] args) {
        // Create a warehouse
        Warehouse warehouse = new Warehouse("Warehouse A", 1000.0) {
            @Override
            public void loadPackage(Package pkg, Line line) {
                // Delegate to WarehouseService
            }

            @Override
            public void offloadPackage(Package pkg) {
                // Delegate to WarehouseService
            }

            @Override
            public void discardPackage(Package pkg) {
                // Delegate to WarehouseService
            }

            @Override
            protected int getMaxLines() {
                return 10;
            }
        };

        // Create a WarehouseService instance
        WarehouseService warehouseService = new WarehouseService(warehouse);

        // Create a line
        Line line1 = new Line(1, PackageType.LOOSE, "HIGH", 500.0);
        warehouse.addLine(line1);

        // Create a package
        Package pkg1 = new Package("12345", PackageType.LOOSE, "HIGH", 10.0);

        // Load the package into the line
        warehouseService.loadPackage(pkg1, line1);

        // Generate a warehouse snapshot
        System.out.println(warehouseService.generateWarehouseSnapshot());

        // Search for a package
        Package foundPackage = warehouseService.searchPackage("12345");
        if (foundPackage != null) {
            System.out.println("Found package: " + foundPackage.getSerialNumber());
        } else {
            System.out.println("Package not found.");
        }
    }
}