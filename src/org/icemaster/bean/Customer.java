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

    private double amountFor(Rental each) {
        double thisAmount = 0;
        switch (each.getMovie().getPriceCode()) {
        case Movie.REGULAR:
            thisAmount += 2;
            if (each.getDeysRented() > 2) {
                thisAmount += (each.getDeysRented() - 2) * 1.5;
            }
            break;
        case Movie.NEW_RELEASE:
            thisAmount += each.getDeysRented() * 3;
            break;
        case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (each.getDeysRented() > 3) {
                thisAmount += (each.getDeysRented() - 3) * 1.5;
            }
            break;
        }
        return thisAmount;
    }

    public String getName() {
        return name;
    }

}
