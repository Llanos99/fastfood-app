package com.quff.controller;

import com.quff.model.Meal;
import com.quff.service.abs.MealService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/meal")
public class MealController {

    private final MealService mealService;

    @Inject
    public MealController(MealService mealService) {
        this.mealService = mealService;
    }

    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addMealToMenu(Meal meal) {
        if (meal != null) {
            return Response.ok(mealService.addMealToMenu(meal)).build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteMealFromMenu(@PathParam("id") String id) {
        if (id != null && !id.isBlank()) {
            return Response.ok(mealService.deleteMealFromMenu(id)).build();
        }
        return Response.noContent().build();
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listMeals() {
        return Response.ok(mealService.displayMenu()).build();
    }

}
