package main.java.com.bhc.service;

import main.java.com.bhc.model.*;

import java.util.List;

public class WarehouseService {
    private Warehouse warehouse;

    public WarehouseService(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    /**
     * Load a package into a specific line in the warehouse.
     *
     * @param pkg  The package to load.
     * @param line The line where the package will be loaded.
     */
    public void loadPackage(LogisticsPackage pkg, Line line) {
        if (line.addPackage(pkg)) {
            System.out.println("Package " + pkg.getSerialNumber() + " loaded into line " + line.getNumber());
        } else {
            System.out.println("Failed to load package " + pkg.getSerialNumber() + " into line " + line.getNumber());
        }
    }

    /**
     * Offload a package from the warehouse.
     *
     * @param pkg The package to offload.
     */
    public void offloadPackage(LogisticsPackage pkg) {
        for (Line line : warehouse.getLines()) {
            if (line.getPackages().contains(pkg)) {
                line.getPackages().remove(pkg);
                System.out.println("Package " + pkg.getSerialNumber() + " offloaded from line " + line.getNumber());
                return;
            }
            for (Pallet pallet : line.getPallets()) {
                if (pallet.getPackages().contains(pkg)) {
                    pallet.getPackages().remove(pkg);
                    System.out.println(
                            "Package " + pkg.getSerialNumber() + " offloaded from pallet in line " + line.getNumber());
                    return;
                }
            }
        }
        System.out.println("Package " + pkg.getSerialNumber() + " not found in any line or pallet.");
    }

    /**
     * Discard a package from the warehouse.
     *
     * @param pkg The package to discard.
     */
    public void discardPackage(LogisticsPackage pkg) {
        for (Line line : warehouse.getLines()) {
            if (line.getPackages().contains(pkg)) {
                line.getPackages().remove(pkg);
                System.out.println("Package " + pkg.getSerialNumber() + " discarded from line " + line.getNumber());
                return;
            }
            for (Pallet pallet : line.getPallets()) {
                if (pallet.getPackages().contains(pkg)) {
                    pallet.getPackages().remove(pkg);
                    System.out.println(
                            "Package " + pkg.getSerialNumber() + " discarded from pallet in line " + line.getNumber());
                    return;
                }
            }
        }
        System.out.println("Package " + pkg.getSerialNumber() + " not found in any line or pallet.");
    }

    /**
     * Search for a package by its serial number.
     *
     * @param serialNumber The serial number of the package.
     * @return The package if found, otherwise null.
     */
    public LogisticsPackage searchPackage(String serialNumber) {
        for (Line line : warehouse.getLines()) {
            for (LogisticsPackage pkg : line.getPackages()) {
                if (pkg.getSerialNumber().equals(serialNumber)) {
                    return pkg;
                }
            }
            for (Pallet pallet : line.getPallets()) {
                for (LogisticsPackage pkg : pallet.getPackages()) {
                    if (pkg.getSerialNumber().equals(serialNumber)) {
                        return pkg;
                    }
                }
            }
        }
        return null;
    }

    /**
     * Generate a snapshot of the warehouse.
     *
     * @return A string representation of the warehouse's current state.
     */
    public String generateWarehouseSnapshot() {
        StringBuilder snapshot = new StringBuilder();
        snapshot.append("Warehouse: ").append(warehouse.getName()).append("\n");
        snapshot.append("Max Capacity: ").append(warehouse.getMaxCapacity()).append(" kg\n");
        snapshot.append("Lines:\n");

        for (Line line : warehouse.getLines()) {
            snapshot.append("  Line ").append(line.getNumber()).append(":\n");
            snapshot.append("    Packages: ").append(line.getPackages().size()).append("\n");
            snapshot.append("    Pallets: ").append(line.getPallets().size()).append("\n");
        }

        return snapshot.toString();
    }
}