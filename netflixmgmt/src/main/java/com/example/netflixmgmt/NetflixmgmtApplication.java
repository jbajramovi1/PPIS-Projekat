package com.example.netflixmgmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class NetflixmgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixmgmtApplication.class, args);
	}
}
