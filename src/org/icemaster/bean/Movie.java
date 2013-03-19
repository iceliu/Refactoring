package org.icemaster.bean;

public class Movie {

    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    public Movie(String title, int priceCode){
        this.title = title;
        this.priceCode = priceCode;
    }
    
    private String title;
    private int priceCode;      

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    public void setPriceCode(int priceCode) {
        this.priceCode = priceCode;
    }

}
