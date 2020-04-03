package com.valid.demo.service;

import java.util.List;

import com.valid.demo.model.UsuarioModel;

public interface IUsuarioService {
	
	public List<UsuarioModel> findAll();
	public UsuarioModel findById(Long id);
	public UsuarioModel save(UsuarioModel entity);
	public Boolean deleteById(Long id);
	
}
