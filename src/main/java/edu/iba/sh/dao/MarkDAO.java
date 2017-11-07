package edu.iba.sh.dao;

import edu.iba.sh.bean.Mark;

import java.util.List;

public interface MarkDAO {

	List<Mark> getAllMarks() throws DAOException;
	Mark getMarkById(Integer id) throws DAOException;
	boolean updateMark(Integer id, Mark mark) throws DAOException;
	boolean deleteMarkById(Integer id) throws DAOException;
	void addMark(Mark mark) throws DAOException;
}
