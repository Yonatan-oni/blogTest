package com.yonileulseged.einc;

import com.yonileulseged.einc.controller.BlogController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;

@SpringBootApplication
@ComponentScan({"com.yonileulseged.einc", "controller"})
public class EincApplication {
	public static void main(String[] args) {
		new File(BlogController.uploadDirectory).mkdir();
		SpringApplication.run(EincApplication.class, args);
	}

}
