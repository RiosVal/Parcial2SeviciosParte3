package com.rios.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rios.commons.controller.CommonController;
import com.rios.commonservice.entities.Alumno;
import com.rios.commonservice.entities.Curso;
import com.rios.curso.services.CursoService; 


@RestController
public class CursoController extends CommonController<Curso,CursoService>{
	
	@GetMapping("/jjj")
	public ResponseEntity<?> editar(){
		return ResponseEntity.status(HttpStatus.CREATED).body("");
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable("id") Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Curso cursoBd = ob.get();
		cursoBd.setNombre(curso.getNombre());
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumnos, @PathVariable("id") Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Curso cursoBd = ob.get();
		alumnos.forEach(
				a ->{cursoBd.setAlumnos(a);
				});
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> eliminarAlumno(@RequestBody Alumno alumno, @PathVariable("id") Long id){
		Optional<Curso> ob = service.findById(id);
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		
		Curso cursoBd = ob.get();
		cursoBd.removeAlumnos(alumno);
		return ResponseEntity.status(HttpStatus.CREATED).body("deleted");
	}
	
}
