package edu.course.lab04;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;
class SampleRegistryTest {
    @Test
    void equalIdsShouldFindSameSample() {
        SampleRegistry registry = new SampleRegistry();

        SampleId firstId = new SampleId("Dataset A", 1);
        SampleId secondId = new SampleId("Dataset A", 1);

        DataSample sample = new DataSample(15.5);

        registry.add(firstId, sample);

        assertEquals(sample, registry.get(secondId));
        assertTrue(registry.contains(secondId));
    }

    @Test
    void addingEqualIdShouldReplaceSampleWithoutIncreasingSize() {
        SampleRegistry registry = new SampleRegistry();

        SampleId firstId = new SampleId("Dataset A", 1);
        SampleId secondId = new SampleId("Dataset A", 1);

        registry.add(firstId, new DataSample(10.0));
        registry.add(secondId, new DataSample(20.0));

        assertEquals(1, registry.size());
        assertEquals(20.0, registry.get(firstId).getValue());
    }

    @Test
    void differentIdsShouldBeStoredSeparately() {
        SampleRegistry registry = new SampleRegistry();

        SampleId firstId = new SampleId("Dataset A", 1);
        SampleId secondId = new SampleId("Dataset A", 2);

        registry.add(firstId, new DataSample(10.0));
        registry.add(secondId, new DataSample(20.0));

        assertEquals(2, registry.size());
        assertEquals(10.0, registry.get(firstId).getValue());
        assertEquals(20.0, registry.get(secondId).getValue());
    }

    @Test
    void removeShouldDeleteSample() {
        SampleRegistry registry = new SampleRegistry();

        SampleId id = new SampleId("Dataset A", 1);
        registry.add(id, new DataSample(10.0));

        DataSample removed = registry.remove(id);

        assertEquals(10.0, removed.getValue());
        assertFalse(registry.contains(id));
        assertEquals(0, registry.size());
    }
        @Test
    void differentIdsWithSameHashCodeShouldBeStoredSeparately() {
        SampleRegistry registry = new SampleRegistry();

        SampleId firstId = new SampleId("Aa", 1);
        SampleId secondId = new SampleId("BB", 1);

        assertNotEquals(firstId, secondId);
        assertEquals(firstId.hashCode(), secondId.hashCode());

        registry.add(firstId, new DataSample(10.0));
        registry.add(secondId, new DataSample(20.0));

        assertEquals(2, registry.size());
        assertEquals(10.0, registry.get(firstId).getValue());
        assertEquals(20.0, registry.get(secondId).getValue());
    }
        @Test
    void equalsShouldReturnFalseForNullAndDifferentObjectType() {
        SampleId id = new SampleId("Dataset A", 1);

        assertNotEquals(null, id);
        assertFalse(id.equals("Dataset A"));
    }
        @Test
    void changingMutableKeyCanBreakHashMapLookup() {
        Map<MutableSampleId, String> map = new HashMap<>();
        MutableSampleId id = new MutableSampleId("Dataset A");
        map.put(id, "Sample data");
        assertEquals("Sample data", map.get(id));
        id.setDatasetName("Dataset B");
        assertNull(map.get(id));
    }
}