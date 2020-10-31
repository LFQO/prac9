package ru.mirea.inbo_05_19.Kuznetsov;

public interface SortSearch<E> {
    E search(SortSearch[] element, String name) throws Exception;

    void sort(SortSearch[] element);
}