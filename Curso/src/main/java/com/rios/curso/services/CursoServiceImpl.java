package com.rios.curso.services;

import org.springframework.stereotype.Service;

import com.rios.commons.service.CommonsService;
import com.rios.commons.service.CommonsServiceImpl;
import com.rios.commonservice.entities.Curso;
import com.rios.curso.repositories.*;

@Service
public class CursoServiceImpl extends CommonsServiceImpl<Curso,CursoRepository> implements CommonsService<Curso>{

}
