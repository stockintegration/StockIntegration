package main.java.com.example.stock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class StockApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(StockApplication.class, args);
		com.example.stock.datagetter.PythonExecutor executor = new com.example.stock.datagetter.PythonExecutor();
		executor.excute("Stockmonth.py");
	}

}
