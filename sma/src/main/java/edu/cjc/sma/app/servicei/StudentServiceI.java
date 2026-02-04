package edu.cjc.sma.app.servicei;

import java.util.List;

import edu.cjc.sma.app.model.Student;

public interface StudentServiceI {

	public void saveData(Student s);
	public List<Student> getAllStudents();
	public void removeStudent(int studentId);
	public List<Student> getStudentsByBatch(String batchNumber);

}
