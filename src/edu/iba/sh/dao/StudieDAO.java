package edu.iba.sh.dao;

import edu.iba.sh.bean.Studie;

import java.util.List;

public interface StudieDAO {

    List<Studie> getAllStudies() throws DAOException;

    Studie getStudieById(Integer id) throws DAOException;

    boolean updateStudie(Integer id, Studie studie) throws DAOException;

    boolean deleteStudieById(Integer id) throws DAOException;

    void addStudie(Studie studie) throws DAOException;
}
