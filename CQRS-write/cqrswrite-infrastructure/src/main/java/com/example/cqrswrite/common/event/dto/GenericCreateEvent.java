package com.example.cqrswrite.common.event.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.core.ResolvableType;
import org.springframework.core.ResolvableTypeProvider;

@Getter
@AllArgsConstructor
public class GenericCreateEvent<T> implements ResolvableTypeProvider {

    private final T entity;

    @Override
    public ResolvableType getResolvableType() {
        return ResolvableType.forClassWithGenerics(
                getClass(), ResolvableType.forInstance(getEntity())
        );
    }
}
