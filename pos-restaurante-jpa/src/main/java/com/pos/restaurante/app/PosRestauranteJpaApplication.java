package com.pos.restaurante.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pos.restaurante.app.models.service.IUploadFileService;

@SpringBootApplication
public class PosRestauranteJpaApplication implements CommandLineRunner{
	
	@Autowired
	private IUploadFileService UploadFileServiceImp;

	public static void main(String[] args) {
		SpringApplication.run(PosRestauranteJpaApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		UploadFileServiceImp.deleteAll();
		UploadFileServiceImp.init();
	}

}
