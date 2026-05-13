package Interfaces;

import Entity.Patient;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<List<Patient>> getAll();
}
