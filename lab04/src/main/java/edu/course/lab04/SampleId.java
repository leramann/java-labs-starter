package edu.course.lab04;
import java.util.Objects;
public final class SampleId {
    private final String datasetName;
    private final int observationNumber;
    public SampleId(String datasetName, int observationNumber) {
        if (datasetName == null || datasetName.isBlank()) {
            throw new IllegalArgumentException("Название набора данных не может быть пустым или состоять только из пробелов");
        }

        this.datasetName = datasetName;
        this.observationNumber = observationNumber;
    }

    public String getDatasetName() {
        return datasetName;
    }

    public int getObservationNumber() {
        return observationNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof SampleId)) {
            return false;
        }

        SampleId other = (SampleId) obj;

        return observationNumber == other.observationNumber
                && datasetName.equals(other.datasetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetName, observationNumber);
    }
}