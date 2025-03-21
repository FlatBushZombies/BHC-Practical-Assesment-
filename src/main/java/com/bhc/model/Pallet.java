// Pallet.java
package main.java.com.bhc.model;

import java.util.ArrayList;
import java.util.List;

public class Pallet {
    private String serialNumber;
    private String qualityMark; // Quality mark as a String
    private List<LogisticsPackage> packages;
    private int maxCapacity;

    public Pallet(String serialNumber, String qualityMark, int maxCapacity) {
        this.serialNumber = serialNumber;
        this.qualityMark = qualityMark;
        this.maxCapacity = maxCapacity;
        this.packages = new ArrayList<>();
    }

    public boolean addPackage(LogisticsPackage pkg) {
        if (packages.size() < maxCapacity && pkg.getQualityMark().equals(qualityMark)) {
            packages.add(pkg);
            return true;
        }
        return false;
    }

    public List<LogisticsPackage> getPackages() {
        return packages;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getQualityMark() {
        return qualityMark;
    }
}