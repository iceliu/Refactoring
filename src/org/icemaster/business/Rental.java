package org.icemaster.business;

import org.icemaster.bean.Movie;

public class Rental {
    
    private Movie movie;
    private int deysRented;

    public Rental(Movie movie, int deysRented) {
        this.movie = movie;
        this.deysRented = deysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDeysRented() {
        return deysRented;
    }
}
