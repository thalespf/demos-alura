/**
 * 
 */
package com.thalespf.demo.android.presentation.ui.helper;

import com.thalespf.demo.android.presentation.ui.exception.ValidationError;
import com.thalespf.demo.domain.Student;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Validater {

	public void valid(Student student) throws ValidationError {
		if(student.getNome() == null || 
				(student.getNome() != null && student.getNome().length() == 0)) {
			throw new ValidationError("informe o nome");
		}
		if(student.getTelefone() == null || 
				(student.getTelefone() != null && student.getTelefone().length() == 0)) {
			throw new ValidationError("informe o telefone");
		}
	}

}
