package edu.course.lab04;
import java.util.HashMap;
import java.util.Map;
public class SampleRegistry {
    private final Map<SampleId, DataSample> samples = new HashMap<>();

    // Добавление нового наблюдения или замена существующего
    public void add(SampleId id, DataSample sample) {
        if (id == null || sample == null) {
            throw new IllegalArgumentException("Id и образец не могут быть равны нулю");
        }

        samples.put(id, sample);
    }

    // Получение наблюдения по идентификатору
    public DataSample get(SampleId id) {
        return samples.get(id);
    }

    // Удаление наблюдения
    public DataSample remove(SampleId id) {
        return samples.remove(id);
    }

    // Проверка наличия идентификатора
    public boolean contains(SampleId id) {
        return samples.containsKey(id);
    }

    // Количество сохранённых наблюдений
    public int size() {
        return samples.size();
    }
}