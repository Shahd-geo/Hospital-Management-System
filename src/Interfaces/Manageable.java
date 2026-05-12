package Interfaces;

import Entity.Appointment;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<Appointment> getAll();
}
