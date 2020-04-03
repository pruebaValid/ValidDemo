package com.valid.demo.business.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.valid.demo.business.IUsuarioBusiness;
import com.valid.demo.business.facade.UsuarioFacade;
import com.valid.demo.dto.UsuarioDTO;
import com.valid.demo.exceptions.UsuarioNoFoundException;
import com.valid.demo.model.UsuarioModel;
import com.valid.demo.service.IUsuarioService;

@Service
public class UsuarioBusiness implements IUsuarioBusiness{

	private IUsuarioService usuarioService;
	
	@Autowired
	public UsuarioBusiness(IUsuarioService usuarioService) {
		super();
		this.usuarioService = usuarioService;		
	}
	
	@Override
	public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO) {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		UsuarioModel usuarioModel = usuarioFacade.obtenerUsuarioModel(usuarioDTO); 
		
		return usuarioFacade.obtenerUsuarioDTO(usuarioService.save(usuarioModel));
	}

	@Override
	public List<UsuarioDTO> consultarUsuarios() throws UsuarioNoFoundException{
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		List<UsuarioDTO> usuariosLts =  usuarioFacade.obtenerUsuarioDtoList(usuarioService.findAll());
		
		if(Objects.isNull(usuariosLts) || usuariosLts.size() == 0) {
			throw new UsuarioNoFoundException(HttpStatus.NOT_FOUND, "Registros no encontrados");
		}
		
		return usuariosLts;
	}

	@Override
	public UsuarioDTO consultarUsuario(Long id) {
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		UsuarioModel usuario = usuarioService.findById(id);
		if(Objects.isNull(usuario)) {
			throw new UsuarioNoFoundException(HttpStatus.NOT_FOUND, "Registros no encontrados");
		}
		UsuarioDTO usuarioDTO = usuarioFacade.obtenerUsuarioDTO(usuario);
		
		
		
		return usuarioDTO;
	}

	@Override
	public Boolean borrarUsuario(Long id) {
		return usuarioService.deleteById(id);
	}

	@Override
	public List<UsuarioDTO> guardarUsuarios(List<UsuarioDTO> usuarioDTOLst) {
		
		List<UsuarioDTO> UsuarioLst = new ArrayList<>(); 
		UsuarioFacade usuarioFacade = new UsuarioFacade();
		usuarioDTOLst.stream().forEach(a -> {
			UsuarioModel usuarioModel = usuarioFacade.obtenerUsuarioModel(a); 
			UsuarioLst.add(usuarioFacade.obtenerUsuarioDTO(usuarioService.save(usuarioModel)));
		});
		
		
		return UsuarioLst;
	}

}
