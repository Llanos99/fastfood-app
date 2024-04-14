package com.quff.model;

import com.quff.model.utils.MealInfo;
import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;

@Data
@Builder
@MongoEntity(collection = "orders")
public class Order {

    @BsonId
    private ObjectId id;

    private List<MealInfo> description;

    private float totalPrice;

    private Date createdAt;

}
