package com.example.demo.motorvogn4.repository;

import com.example.demo.motorvogn4.model.Bil4;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Bil4Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn4Repository.class);

    public List<Bil4> hentAlleBiler(){
        String sql = "SELECT * FROM Bil4";
        return db.query(sql,new BeanPropertyRowMapper(Bil4.class));
    }
}
