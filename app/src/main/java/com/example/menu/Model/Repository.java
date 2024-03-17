package com.example.menu.Model;

import com.example.menu.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class Repository {
    private List<MenuItem> menu=new ArrayList<>();

    public Repository() {
        menu.add(new MenuItem("Coffee",  "Hot Drinks",12.2));
        menu.add(new MenuItem("Tea", "Hot Drinks",5.4));
        menu.add(new MenuItem("Ice Coffee",  "Cold Drinks",18));
        menu.add(new MenuItem("Sprite",  "Cold Drinks",10));
        menu.add(new MenuItem("Chicken Sandwich",  "Sandwiches",34));
        menu.add(new MenuItem("Cheeseburger",  "Burgers",45));
        menu.add(new MenuItem("Fish and Chips",  "Entrees",44));
        menu.add(new MenuItem("Mango Smoothie",  "Smoothies",30));
        menu.add(new MenuItem("Greek Salad",  "Salads",20));

    }

    public  List<MenuItem> getMenu() {
        return menu;
    }

    public  void setMenu(List<MenuItem> menu) {
        this.menu=menu;
    }

    public String[] getCats(){
        return new String[]{
                "Hot Drinks",
                "Cold Drinks",
                "Sandwiches",
                "Burgers",
                "Entrees",
                "Smoothies",
                "Salads"
        };
    }
    public List<MenuItem> getByCat(String cat){
        List<MenuItem> bycat=new ArrayList<>();
        for(int i=0;i<menu.size();i++){
            if (menu.get(i).getCategory().equals(cat)){
                bycat.add(menu.get(i));
            }
        }
        return bycat;
    }
}
