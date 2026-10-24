package edu.course.lab02;
public class DataSample {
    private final String id;
    private final String label;
    private SampleStatus status;
    private final double[] features;
    public DataSample(String id, String label, SampleStatus status, double[] features) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID не может быть нулевым или пустым");
        }
        if (label == null || label.isBlank()) {
            throw new IllegalArgumentException("Метка не нулевой или пустой");
        }
        if (status == null) {
            throw new IllegalArgumentException("Статус не может быть нулевым");
        }
        if (features == null || features.length == 0) {
            throw new IllegalArgumentException("Функции не могут быть нулевыми или пустыми");
        }
        for (double feature : features) {
            if (!Double.isFinite(feature)) {
                throw new IllegalArgumentException("Функции должны быть конечным числом");
            }
        }
        this.id = id;
        this.label = label;
        this.status = status;
        this.features = features.clone();
    }
    public String getId() {
        return id;
    }
    public String getLabel() {
        return label;
    }
    public SampleStatus getStatus() {
        return status;
    }
    public double[] getFeatures() {
        return features.clone();
    }
    public void changeStatus(SampleStatus newStatus) {
        if (newStatus == null) {
            throw new IllegalArgumentException("Статус не может быть нулевым");
        }
        this.status = newStatus;
    }
    public boolean isReady() {
        return status == SampleStatus.READY;
    }
    public double calculateAverage() {
        double sum = 0;
        for (double feature : features) {
            sum += feature;
        }
        return sum / features.length;
    }
    public DataSample normalize() {
        double min = features[0];
        double max = features[0];
        for (double feature : features) {
            min = Math.min(min, feature);
            max = Math.max(max, feature);
        }
        double[] normalized = new double[features.length];
        if (max == min) {
            return new DataSample(id, label, status, normalized);
        }
        for (int i = 0; i < features.length; i++) {
            normalized[i] = (features[i] - min) / (max - min);
        }
        return new DataSample(id, label, status, normalized);
    }
}