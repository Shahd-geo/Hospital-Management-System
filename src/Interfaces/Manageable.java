package Interfaces;

import Entity.Department;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<Department> getAll();
}
