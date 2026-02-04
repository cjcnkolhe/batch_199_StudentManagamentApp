package edu.cjc.sma.app.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.cjc.sma.app.model.Student;
import edu.cjc.sma.app.repositary.StudentRepositary;
import edu.cjc.sma.app.servicei.StudentServiceI;

@Service
public class StudentServiceImpl implements StudentServiceI
{

	@Autowired
	StudentRepositary sr;
	
	@Override
	public void saveData(Student s) {
		sr.save(s);
		
	}

	@Override
	public List<Student> getAllStudents() {

		return sr.findAll();
	}

	@Override
	public void removeStudent(int studentId) {
		sr.deleteById(studentId);
		
	}

	@Override
	public List<Student> getStudentsByBatch(String batchNumber) {
		
		return sr.findAllByBatchNumber(batchNumber);
	}

}
