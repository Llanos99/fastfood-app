package com.quff.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;
import org.bson.types.ObjectId;

@Data
@MongoEntity(collection = "meals")
public class Meal {

    @BsonId
    private ObjectId id;

    private String description;

    private String type;

}
