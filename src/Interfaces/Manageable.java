package Interfaces;

import Entity.Doctor;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<Doctor> getAll();
}
