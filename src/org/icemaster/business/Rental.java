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

    public double getCharge() {
        double result = 0;
        switch (getMovie().getPriceCode()) {
        case Movie.REGULAR:
            result += 2;
            if (getDeysRented() > 2) {
                result += (getDeysRented() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            result += getDeysRented() * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (getDeysRented() > 3) {
                result += (getDeysRented() - 3) * 1.5;
            }
            break;
        }
        return result;
    }
}
