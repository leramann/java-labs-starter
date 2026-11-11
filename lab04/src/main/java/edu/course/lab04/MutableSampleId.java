package edu.course.lab04;
import java.util.Objects;
class MutableSampleId {
    private String datasetName;
    public MutableSampleId(String datasetName) {
        this.datasetName = datasetName;
    }

    public void setDatasetName(String datasetName) {
        this.datasetName = datasetName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof MutableSampleId)) {
            return false;
        }

        MutableSampleId other = (MutableSampleId) obj;
        return Objects.equals(datasetName, other.datasetName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(datasetName);
    }
}