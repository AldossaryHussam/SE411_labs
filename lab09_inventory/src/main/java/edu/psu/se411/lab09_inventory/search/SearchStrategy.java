package edu.psu.se411.lab09_inventory.search;

public interface SearchStrategy<T> {
    boolean matches(T item);
}
