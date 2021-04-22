package com.example.demo.motorvogn.motorvogn6.repository;

import com.example.demo.motorvogn.motorvogn6.model.Bil6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Bil6Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn6Repository.class);

    public List<Bil6> hentAlleBiler(){
        String sql = "SELECT * FROM Bil6";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Bil6.class));
        }
        catch(Exception e){
            return null;
        }
    }

}
