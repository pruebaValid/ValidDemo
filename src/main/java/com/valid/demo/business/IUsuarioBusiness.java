package com.valid.demo.business;

import java.util.List;

import com.valid.demo.dto.UsuarioDTO;

public interface IUsuarioBusiness {
	
	public UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO);
	
	public List<UsuarioDTO> guardarUsuarios(List<UsuarioDTO> usuarioDTOLst);
	
	public List<UsuarioDTO> consultarUsuarios();
	
	public UsuarioDTO consultarUsuario(Long id);	
	
	public Boolean borrarUsuario(Long id);	
	
}
