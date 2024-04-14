package com.quff.service.impl;

import com.quff.model.Meal;
import com.quff.repository.MealRepository;
import com.quff.service.abs.MealService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.bson.types.ObjectId;

import java.util.List;

@ApplicationScoped
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    @Inject
    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public boolean addMealToMenu(Meal meal) {
        if (meal != null) {
            mealRepository.persist(meal);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteMealFromMenu(String id) {
        if (id != null){
            mealRepository.deleteById(new ObjectId(id));
            return true;
        }
        return false;
    }

    @Override
    public List<Meal> displayMenu() {
        return mealRepository.findAll().stream().toList();
    }
}
