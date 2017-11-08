package edu.iba.sh.dao;

import edu.iba.sh.bean.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> getAllStudents() throws DAOException;

    Student getStudentById(Integer id) throws DAOException;

    boolean updateStudent(Integer id, Student student) throws DAOException;

    boolean deleteStudentById(Integer id) throws DAOException;

    void addStudent(Student student) throws DAOException;
}
