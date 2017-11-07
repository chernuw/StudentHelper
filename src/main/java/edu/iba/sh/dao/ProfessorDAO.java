package edu.iba.sh.dao;

import edu.iba.sh.bean.Professor;

import java.util.List;

public interface ProfessorDAO {

	List<Professor> getAllProfessors() throws DAOException;
	Professor getProfessorById(Integer id) throws DAOException;
	boolean updateProfessor(Integer id, Professor professor) throws DAOException;
	boolean deleteProfessorById(Integer id) throws DAOException;
	void addProfessor(Professor professor) throws DAOException;
}
