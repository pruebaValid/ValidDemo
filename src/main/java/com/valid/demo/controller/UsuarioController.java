package com.valid.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valid.demo.business.IUsuarioBusiness;
import com.valid.demo.dto.UsuarioDTO;
import com.valid.demo.exceptions.UsuarioNoFoundException;

@RestController
@RequestMapping(value="/usuario")
@CrossOrigin("*")
public class UsuarioController {
	
	private IUsuarioBusiness usuarioBusiness;
	
	@Autowired
	public UsuarioController(IUsuarioBusiness usuarioBusiness) {
		super();
		this.usuarioBusiness = usuarioBusiness;
	}

	@GetMapping(value="/consultar")
	public ResponseEntity<List<UsuarioDTO>> findAll(){
		return new ResponseEntity<List<UsuarioDTO>>(usuarioBusiness.consultarUsuarios(),HttpStatus.OK);		 
	}

	@GetMapping(value="/buscar/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable("id") Long id) {
		return new ResponseEntity<UsuarioDTO>(usuarioBusiness.consultarUsuario(id), HttpStatus.OK);
	}
	
	@PostMapping(value="/guardar")
	public ResponseEntity<UsuarioDTO> saveUsuario(@RequestBody UsuarioDTO usuarioDTO) {
		return new ResponseEntity<UsuarioDTO>(usuarioBusiness.guardarUsuario(usuarioDTO), HttpStatus.OK);
	}
	
	@PostMapping(value="/guardar/usuarios")
	public ResponseEntity<List<UsuarioDTO>> saveUsuarios(@RequestBody List<UsuarioDTO> usuarioLst) {
		return new ResponseEntity<List<UsuarioDTO>>(usuarioBusiness.guardarUsuarios(usuarioLst), HttpStatus.OK);
	}

	@GetMapping(value="/borrar/{id}")
	public ResponseEntity<String> deleteById(@PathVariable("id") Long id) {
		String rta="";
		if(usuarioBusiness.borrarUsuario(id)) {
			rta="Borrado exitoso para el id: "+id;
		}else {
			rta="Error en el Borrado para el id: "+id;
		}
		return new ResponseEntity<String>(rta, HttpStatus.OK);
	}
	
}
