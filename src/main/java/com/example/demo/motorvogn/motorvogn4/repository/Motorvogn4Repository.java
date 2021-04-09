package com.example.demo.motorvogn.motorvogn4.repository;

import com.example.demo.motorvogn.motorvogn4.model.Motorvogn4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Motorvogn4Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn4Repository.class);

    public void lagreMotorvogn(Motorvogn4 motorvogn) {
        String sql = "INSERT INTO Motorvogn4 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        db.update(sql,motorvogn.getPersonnr(),motorvogn.getNavn(),motorvogn.getAdresse(),motorvogn.getKjennetegn(),
                motorvogn.getMerke(),motorvogn.getType());
    }

    public List<Motorvogn4> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn4";
        return db.query(sql,new BeanPropertyRowMapper(Motorvogn4.class));
     }

    public void slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn4 WHERE personnr=?";
        db.update(sql,personnr);
    }

    public void slettAlleMotorvogner () {
        String sql = "DELETE FROM Motorvogn4";
        db.update(sql);
    }
}
