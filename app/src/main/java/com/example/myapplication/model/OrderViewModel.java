package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class OrderViewModel extends ViewModel {
    private MutableLiveData<Integer> quantity = new MutableLiveData<>(0);
    private MutableLiveData<String> flavour = new MutableLiveData<>("");
    private MutableLiveData<Double> price = new MutableLiveData<>(0.0);

    public static final double PRICE_PER_CUPCAKE = 100.00;

    public LiveData<Integer> getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity.setValue(quantity);
        update_price();
    }

    public void update_price() {
        double calc = this.quantity.getValue() * PRICE_PER_CUPCAKE;
        this.price.setValue(calc);
    }

    public LiveData<String> getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour.setValue(flavour);
    }

    public LiveData<Double> getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price.setValue(price);
    }
}
