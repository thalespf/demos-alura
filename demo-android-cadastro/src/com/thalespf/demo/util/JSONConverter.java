/**
 * 
 */
package com.thalespf.demo.util;

import java.util.List;

import org.json.JSONException;
import org.json.JSONStringer;

import com.thalespf.demo.domain.Student;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class JSONConverter {

	public String toJSON(List<Student> students) {
		try {
			JSONStringer js = new JSONStringer();
			js.object().key("list").array();
			
			js.object().key("aluno").array();
			
			for (Student student : students) {
				js.object();
				js.key("name").value(student.getNome());
				js.key("nota").value(student.getNota());
				js.endObject();
			}
			
			js.endArray().endObject();
			
			js.endArray().endObject();
			
			return js.toString();
		} catch (JSONException e) {
			throw new RuntimeException(e);
		}
	}

}
