package com.rios.usuarios.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rios.commons.controller.CommonController;
import com.rios.commonservice.entities.Alumno;
import com.rios.usuarios.services.AlumnoService;

@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

	@Autowired
	AlumnoService alumnoService;
	
	@Value("${config.balanceador.test}")
	private String balanceadorTest;
	
	@GetMapping(path = "/balanceador-test")
	public ResponseEntity<?> balanceadorTest(){
		
		Map<String,Object> response = new HashMap<String, Object>();
		response.put("balanceador", balanceadorTest);
		response.put("alumno", alumnoService.findAll());
		
		return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Alumno alumno, @PathVariable("id") Long id){
		Optional<Alumno> ob = alumnoService.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Alumno alumnoBd = ob.get();
		alumnoBd.setNombre(alumno.getNombre());
		alumnoBd.setApellido(alumno.getApellido());
		alumnoBd.setEmail(alumno.getEmail());
		return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoBd));
	}
	
	
	
	
}
