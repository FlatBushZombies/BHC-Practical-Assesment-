// Line.java
package main.java.com.bhc.model;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private int number;
    private PackageType type;
    private String qualityMark;
    private double maxCapacity; // in kgs or number of cartons
    private List<Package> packages;
    private List<Pallet> pallets;

    public Line(int number, PackageType type, String qualityMark, double maxCapacity) {
        this.number = number;
        this.type = type;
        this.qualityMark = qualityMark;
        this.maxCapacity = maxCapacity;
        this.packages = new ArrayList<>();
        this.pallets = new ArrayList<>();
    }

    public boolean addPackage(Package pkg) {
        if (pkg.getType() == type && pkg.getQualityMark() == qualityMark) {
            packages.add(pkg);
            return true;
        }
        return false;
    }

    public boolean addPallet(Pallet pallet) {
        if (type == PackageType.LOOSE && pallet.getQualityMark() == qualityMark) {
            pallets.add(pallet);
            return true;
        }
        return false;
    }

    public List<Package> getPackages() {
        return packages;
    }

    public List<Pallet> getPallets() {
        return pallets;
    }
}