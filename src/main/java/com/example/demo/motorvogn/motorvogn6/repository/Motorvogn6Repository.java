package com.example.demo.motorvogn.motorvogn6.repository;

import com.example.demo.motorvogn.motorvogn6.model.Bil6;
import com.example.demo.motorvogn.motorvogn6.model.Motorvogn6;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Motorvogn6Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn6Repository.class);

    public boolean lagreMotorvogn(Motorvogn6 m) {
        String sql = "INSERT INTO Motorvogn6 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try{
            db.update(sql,m.getPersonnr(),m.getNavn(),m.getAdresse(),m.getKjennetegn(),m.getMerke(),m.getType());
            return true;
        }
        catch(Exception e){
            logger.error("Feil i lagre motorvogn "+e);
            return false;
        }
    }

    public List<Motorvogn6> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn6";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Motorvogn6.class));
        }
        catch(Exception e){
            logger.error("Feil i hent alle motorvogner "+e);
            return null;
        }
     }

     public Motorvogn6 henteEnMotorvogn(int id){
         String sql = "SELECT * FROM Motorvogn6 WHERE id=?";
         try{
             List<Motorvogn6> enMotorvogn  = db.query(sql,new BeanPropertyRowMapper(Motorvogn6.class),id);
             return enMotorvogn.get(0);
         }
         catch(Exception e){
             logger.error("Feil i hent en motorvogn "+e);
             return null;
         }
     }

     public boolean endreMotorvogn(Motorvogn6 m){
         String sql = "UPDATE Motorvogn6 SET personnr=?, navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
         try{
             db.update(sql,m.getPersonnr(),m.getNavn(),m.getAdresse(),m.getKjennetegn(),m.getMerke(),m.getType(),m.getId());
             return true;
         }
         catch(Exception e){
             logger.error("Feil i endre en motorvogn "+e);
             return false;
         }
     }

     public boolean slettEnMotorvogn(int personnr) {
        String sql = "DELETE FROM Motorvogn6 WHERE personnr=?";
        try{
            db.update(sql,personnr);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett en motorvogn"+e);
            return false;
        }
    }

    public boolean slettAlleMotorvogner () {
        String sql = "DELETE FROM Motorvogn6";
        try{
            db.update(sql);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett alle motorvogner"+e);
            return false;
        }
    }
}
