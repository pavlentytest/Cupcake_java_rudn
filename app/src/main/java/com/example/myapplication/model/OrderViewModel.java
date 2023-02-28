package com.example.myapplication.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

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


    private MutableLiveData<String> date = new MutableLiveData<>("");

    public void setDate(String date) {
        this.date.setValue(date);
    }

    public LiveData<String> getDate() {
        return date;
    }

    public List<String> dateOptions = getPickupOptions();

    public List<String> getPickupOptions()  {
        ArrayList<String> options = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("E, MMM d", Locale.getDefault());
        Calendar calendar = new GregorianCalendar();
        for(int i=0;i<4;i++) {
            options.add(formatter.format(calendar.getTime()));
            calendar.add(Calendar.DATE, 1); // добавляем по 1 дню
        }
        return options;
    }
}
