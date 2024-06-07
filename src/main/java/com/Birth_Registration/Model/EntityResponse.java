package com.Birth_Registration.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Data
public class EntityResponse<T> {
    private String message;
    private T entity;
    private Integer statusCode;
}
