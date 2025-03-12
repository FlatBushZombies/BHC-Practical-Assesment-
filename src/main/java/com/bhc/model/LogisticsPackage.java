// Package.java
package main.java.com.bhc.model;

public class LogisticsPackage {
    private String serialNumber;
    private PackageType type;
    private String qualityMark; // Quality mark as a String
    private double mass; // in kgs

    public LogisticsPackage(String serialNumber, PackageType type, String qualityMark, double mass) {
        this.serialNumber = serialNumber;
        this.type = type;
        this.qualityMark = qualityMark;
        this.mass = mass;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public PackageType getType() {
        return type;
    }

    public String getQualityMark() {
        return qualityMark;
    }

    public double getMass() {
        return mass;
    }
}