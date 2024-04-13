package com.quff.model;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Builder;
import lombok.Data;
import org.bson.codecs.pojo.annotations.BsonId;

@MongoEntity
@Builder
@Data
public class Meal {

    @BsonId
    private String id;

    private String description;

    private String type;

}
