package com.pismo.transactions;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Transaction Routine Service"))
public class PismoTransactionsRoutineApplication {

	public static void main(String[] args) {
		SpringApplication.run(PismoTransactionsRoutineApplication.class, args);
	}

}
