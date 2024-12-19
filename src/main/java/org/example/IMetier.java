package org.example;

import java.util.List;

public interface IMetier<T> {
    void add(T o);

    void add(Produit o);

    List<T> getAll();
    T findById(long id);
    void delete(long id);
}
