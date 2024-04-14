package com.quff.service.abs;

import com.quff.model.Meal;

import java.util.List;

public interface MealService {

    boolean addMealToMenu(Meal meal);

    boolean deleteMealFromMenu(String id);

    List<Meal> displayMenu();

}
