package com.example.project5;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import RUPizza.*;

public class SelectPizzaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PizzaAdapter pizzaAdapter;
    private List<PizzaObject> pizzaObjectList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview_pizza_row);

        //set up the toolbar (for back button to home menu)
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Select Pizza");
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //initialize RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //initialize pizzaList (for our pizzaObjects (diff from pizza object itself (check PizzaObject class) and adapter
        pizzaObjectList = new ArrayList<>();
        populatePizzaList();
        pizzaAdapter = new PizzaAdapter(this, pizzaObjectList);

        recyclerView.setAdapter(pizzaAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void populatePizzaList() {
        PizzaFactory ChicagoPizzaFactory = new ChicagoPizza();
        PizzaFactory NYPizzaFactory = new NYPizza();
        //BBQ Chicken pizzas
        Pizza BBQChicagoPizza = ChicagoPizzaFactory.createBBQChicken(Size.SMALL);
        Pizza BBQNYPizza = NYPizzaFactory.createBBQChicken(Size.SMALL);
        pizzaObjectList.add(new PizzaObject("Chicago Style BBQ Pizza", BBQChicagoPizza, R.drawable.bbq_pizza));
        pizzaObjectList.add(new PizzaObject("NY Style BBQ Pizza",BBQNYPizza, R.drawable.ny_bbq));
        //Deluxe pizzas
        Pizza DeluxeChicagoPizza = ChicagoPizzaFactory.createDeluxe(Size.SMALL);
        Pizza DeluxeNYPizza = NYPizzaFactory.createDeluxe(Size.SMALL);
        pizzaObjectList.add(new PizzaObject("Chicago Style Deluxe Pizza",DeluxeChicagoPizza, R.drawable.deluxe_pizza));
        pizzaObjectList.add(new PizzaObject("NY Style Deluxe Pizza",DeluxeNYPizza, R.drawable.ny_deluxe));
        //Meatzza pizzas
        Pizza MeatzzaChicagoPizza = ChicagoPizzaFactory.createMeatzza(Size.SMALL);
        Pizza MeatzzaNYPizza = NYPizzaFactory.createMeatzza(Size.SMALL);
        pizzaObjectList.add(new PizzaObject("Chicago Style Meatzza Pizza",MeatzzaChicagoPizza, R.drawable.meatzza));
        pizzaObjectList.add(new PizzaObject("NY Style Meatzza Pizza",MeatzzaNYPizza, R.drawable.ny_meatzza));
        //Build Your Own pizzas
        Pizza BYOChicagoPizza = ChicagoPizzaFactory.createBuildYourOwn(Size.SMALL);
        Pizza BYONYPizza = NYPizzaFactory.createBuildYourOwn(Size.SMALL);
        pizzaObjectList.add(new PizzaObject("Chicago Style Build Your Own Pizza",BYOChicagoPizza, R.drawable.build_pizza));
        pizzaObjectList.add(new PizzaObject("NY Style Build Your Own Pizza",BYONYPizza, R.drawable.ny_build));
    }
}
