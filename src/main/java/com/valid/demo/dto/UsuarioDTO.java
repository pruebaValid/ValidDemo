package com.valid.demo.dto;

public class UsuarioDTO {
	
	private Long id;
	private String nombre;
	private String apellido;
	private boolean procesado;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public boolean getProcesado() {
		return procesado;
	}
	public void setProcesado(boolean procesado) {
		this.procesado = procesado;
	}
	
	
	
}
