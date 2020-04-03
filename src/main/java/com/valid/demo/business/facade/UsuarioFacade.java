package com.valid.demo.business.facade;

import java.util.ArrayList;
import java.util.List;

import com.valid.demo.dto.UsuarioDTO;
import com.valid.demo.model.UsuarioModel;

public class UsuarioFacade {
	
	
	public UsuarioModel obtenerUsuarioModel(UsuarioDTO usuarioDTO) {

		UsuarioModel usuarioModel = new UsuarioModel();
		usuarioModel.setId(usuarioDTO.getId());
		usuarioModel.setNombre(usuarioDTO.getNombre());
		usuarioModel.setApellido(usuarioDTO.getApellido());
		usuarioModel.setProcesado(usuarioDTO.getProcesado());
		
		return usuarioModel;
	}
	
	
	public UsuarioDTO obtenerUsuarioDTO(UsuarioModel usuarioModel) {

		UsuarioDTO usuarioDTO = new UsuarioDTO();
		usuarioDTO.setId(usuarioModel.getId());
		usuarioDTO.setNombre(usuarioModel.getNombre());
		usuarioDTO.setApellido(usuarioModel.getApellido());
		usuarioDTO.setProcesado(usuarioModel.getProcesado());
		
		return usuarioDTO;
	}
	
	public List<UsuarioDTO> obtenerUsuarioDtoList(List<UsuarioModel> usuarioModelLst) {

		List<UsuarioDTO> lstUsuarioDTO = new ArrayList<>();
		usuarioModelLst.stream().forEach(a -> {
			UsuarioDTO usuarioDTO = new UsuarioDTO();
			usuarioDTO.setId(a.getId());
			usuarioDTO.setNombre(a.getNombre());
			usuarioDTO.setApellido(a.getApellido());
			usuarioDTO.setProcesado(a.getProcesado());
			lstUsuarioDTO.add(usuarioDTO);
		}); 
		
		return lstUsuarioDTO;
	}
	
	
}
