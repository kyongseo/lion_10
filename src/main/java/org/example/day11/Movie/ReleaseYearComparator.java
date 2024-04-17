package org.example.day11.Movie;

import java.util.Comparator;

class ReleaseYearComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getYear() - o2.getYear();
    }
}

