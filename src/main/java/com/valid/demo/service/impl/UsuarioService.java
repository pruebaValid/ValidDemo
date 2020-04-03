package com.valid.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.valid.demo.model.UsuarioModel;
import com.valid.demo.repository.UsuarioRepository;
import com.valid.demo.service.IUsuarioService;

@Component
public class UsuarioService implements IUsuarioService{

	private UsuarioRepository repository;	
	
	@Autowired
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<UsuarioModel> findAll() {
		return (List<UsuarioModel>) repository.findAll();
	}

	@Override
	public UsuarioModel findById(Long id) {
		
		UsuarioModel usuario = null;
		if(repository.findById(id).isPresent()) {
			usuario = repository.findById(id).get(); 
		} 
		
		return usuario;
	}

	@Override
	public UsuarioModel save(UsuarioModel entity) {
		return repository.save(entity);
	}

	@Override
	public Boolean deleteById(Long id) {
		Boolean rta=true;
		try {
			repository.deleteById(id);
		}catch(Exception e) {
			e.getMessage();
			rta=false;
		}
		return rta;
	}

}
