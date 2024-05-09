package org.example.day11.Movie;


public class Movie implements Comparable<Movie> {
    private String title;
    private int year;
    private double grade;

    public Movie(String title, int year, double grade) {
        this.title = title;
        this.year = year;
        this.grade = grade;
    }

    public String getTitle() {
        return this.title;
    }

    public double getGrade() {
        return grade;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(Movie o) {
        return this.title.compareTo(o.getTitle());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", grade=" + grade +
                '}';
    }
}
