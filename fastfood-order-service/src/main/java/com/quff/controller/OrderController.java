package com.quff.controller;

import com.quff.model.Order;
import com.quff.service.abs.OrderService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    @Inject
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createOrder(Order order) {
        if (order != null) {
            return Response.ok(orderService.createOrder(order)).build();
        }
        return Response.noContent().build();
    }

    @DELETE
    @Path("/delete/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteOrder(@PathParam("id") String id) {
        if (id != null) {
            return Response.ok(orderService.deleteOrder(id)).build();
        }
        return Response.noContent().build();
    }

}
