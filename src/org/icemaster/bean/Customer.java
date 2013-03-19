package org.icemaster.bean;

import java.util.Enumeration;
import java.util.Vector;

import org.icemaster.business.Rental;

public class Customer {

    public Customer(String name) {
        this.name = name;
    }

    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public void addRentals(Rental rental) {
        rentals.add(rental);
    }

    public String statement() {
        double totalAmount = 0;
        int frequentRentePoints = 0;
        Enumeration<Rental> enu_rentals = rentals.elements();
        String result = "Rental Record for " + this.getName() + "\n";
        while (enu_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = enu_rentals.nextElement();

            thisAmount = amountFor(each);

            frequentRentePoints++;

            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDeysRented() > 1) {
                frequentRentePoints++;
            }

            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n ";

            totalAmount += thisAmount;

        }
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRentePoints) + " frequent renter points";
        return result;
    }

    private double amountFor(Rental aRental) {
        double result = 0;
        switch (aRental.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            result += 2;
            if (aRental.getDeysRented() > 2) {
                result += (aRental.getDeysRented() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            result += aRental.getDeysRented() * 3;
            break;
        case Movie.CHILDRENS:
            result += 1.5;
            if (aRental.getDeysRented() > 3) {
                result += (aRental.getDeysRented() - 3) * 1.5;
            }
            break;
        }
        return result;
    }

    public String getName() {
        return name;
    }

}
