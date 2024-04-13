package com.quff.service.abs;

import com.quff.model.Meal;

public interface MealService {

    boolean addMealToMenu(Meal meal);

    boolean deleteMealFromMenu(String id);

}
