package Interfaces;

import java.util.List;

public interface Manageable {
    void add(Object entity);

    void remove(String id);

    List<Object> getAll();
}
