package com.pismo.transactions.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "OPERATIONS")
public record Operation(@Id Long id, String description,EvaluationType evaluationType) {

}
