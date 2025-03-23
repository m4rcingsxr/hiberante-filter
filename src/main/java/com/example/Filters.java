package com.example;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;

@FilterDef(
        name = "stringEquals",
        parameters = {@ParamDef(name = "field", type = String.class), @ParamDef(name = "value", type = String.class)},
        defaultCondition = ":field = :value"
)
@MappedSuperclass
public abstract class Filters {

    @Id
    Long id;

}
