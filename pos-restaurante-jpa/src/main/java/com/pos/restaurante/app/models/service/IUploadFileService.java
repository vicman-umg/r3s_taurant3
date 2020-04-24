package com.pos.restaurante.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {

	// Visualizar foto
	public Resource load(String filename) throws MalformedURLException;

	// Guardar foto
	public String copy(MultipartFile file) throws IOException;

	public boolean delete(String filename);
	
	public void deleteAll();
	
	public void init() throws IOException;

}
