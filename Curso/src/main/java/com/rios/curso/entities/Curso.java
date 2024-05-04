package com.rios.curso.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rios.commonservice.entities.Alumno;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;

@Entity
@Table(name="cursos")
public class Curso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	
	private String nombre;
	
	@Column(name="create_at")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
	@PrePersist
	private void prePersiste() {
		this.createAt = new Date();
	}
	@OneToMany(fetch=FetchType.LAZY)
	private List<Alumno> listaAlumno;
	

	public Curso() {
		this.listaAlumno = new ArrayList<>();
	}
	
	public List<Alumno>getListaAlumno(){
		return listaAlumno;
	}
	
	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}
	
	public void setAlumnos(Alumno alumno) {
		this.listaAlumno.add(alumno);
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	
	public void removeAlumnos(Alumno alumno) {
		this.listaAlumno.remove(alumno);
	}
}
