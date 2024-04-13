package com.quff.repository;

import com.quff.model.Meal;
import io.quarkus.mongodb.panache.PanacheMongoRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MealRepository implements PanacheMongoRepository<Meal> {
}
