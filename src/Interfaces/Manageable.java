package Interfaces;

import Entity.MedicalRecord;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<MedicalRecord> getAll();
}
