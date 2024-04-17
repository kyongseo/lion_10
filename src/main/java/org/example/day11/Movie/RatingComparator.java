package org.example.day11.Movie;


import java.util.Comparator;

//Comparator 인터페이스 구현
// class RatingComparator implements Comparator<Movie> {
//    @Override
//    public int compare(Movie movie1, Movie movie2) {
//        if (movie1.getDuration() < movie2.getDuration()) {
//            return 1;
//        } else if (movie1.getDuration() > movie2.getDuration()) {
//            return -1;
//        } else {
//            return 0;
//        }
//    }
//}
class RatingComparator implements Comparator<Movie> {
    @Override
    public int compare(Movie o1, Movie o2) {
        return o1.getGrade() - o2.getGrade() > 0 ? 1 : o1.getGrade() - o2.getGrade() < 0 ? -1 : 0;
    }
}