/**
 * 
 */
package com.thalespf.demo.service;

import java.util.List;

import com.thalespf.demo.dao.StudentDAO;
import com.thalespf.demo.domain.Student;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class StudentService {
	
	private StudentDAO alunoDAO;

	public StudentService(StudentDAO alunoDAO) {
		this.alunoDAO = alunoDAO;
	}

	public Student save(Student student) {
		return alunoDAO.save(student);
	}

	public List<Student> findAll() {
		return alunoDAO.findAll();
	}

}
