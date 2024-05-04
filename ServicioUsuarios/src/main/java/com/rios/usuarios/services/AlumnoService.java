package com.rios.usuarios.services;


import com.rios.commons.service.CommonsService;
import com.rios.commonservice.entities.Alumno;

public interface AlumnoService extends CommonsService<Alumno>{

	public Alumno save(Alumno alumno);
	public void deleteById(Long Id);
}
