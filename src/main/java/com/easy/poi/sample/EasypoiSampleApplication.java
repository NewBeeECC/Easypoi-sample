package com.easy.poi.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.afterturn.easypoi","com.easy.poi.sample"})
public class EasypoiSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasypoiSampleApplication.class, args);
	}
}
