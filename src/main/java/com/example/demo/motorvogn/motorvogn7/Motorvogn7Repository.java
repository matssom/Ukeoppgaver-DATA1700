package com.example.demo.motorvogn.motorvogn7;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Motorvogn7Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn7Repository.class);

    public boolean lagreMotorvogn(Motorvogn7 m) {
        String sql = "INSERT INTO Motorvogn7 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try{
            db.update(sql,m.getPersonnr(),m.getNavn(),m.getAdresse(),m.getKjennetegn(),m.getMerke(),m.getType());
            return true;
        }
        catch(Exception e){
            logger.error("Feil i lagre motorvogn "+e);
            return false;
        }
    }

    public List<Motorvogn7> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn7";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Motorvogn7.class));
        }
        catch(Exception e){
            logger.error("Feil i hent alle motorvogner "+e);
            return null;
        }
     }

     public Motorvogn7 henteEnMotorvogn(int id){
         String sql = "SELECT * FROM Motorvogn7 WHERE id=?";
         try{
             List<Motorvogn7> enMotorvogn  = db.query(sql,new BeanPropertyRowMapper(Motorvogn7.class),id);
             return enMotorvogn.get(0);
         }
         catch(Exception e){
             logger.error("Feil i hent en motorvogn "+e);
             return null;
         }
     }

     public boolean endreMotorvogn(Motorvogn7 m){
         String sql = "UPDATE Motorvogn7 SET personnr=?, navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
         try{
             db.update(sql,m.getPersonnr(),m.getNavn(),m.getAdresse(),m.getKjennetegn(),m.getMerke(),m.getType(),m.getId());
             return true;
         }
         catch(Exception e){
             logger.error("Feil i endre en motorvogn "+e);
             return false;
         }
     }

     public boolean slettEnMotorvogn(String personnr) {
        String sql = "DELETE FROM Motorvogn7 WHERE personnr=?";
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
        String sql = "DELETE FROM Motorvogn7";
        try{
            db.update(sql);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett alle motorvogner"+e);
            return false;
        }
    }

    public List<Bil7> hentAlleBiler(){
        String sql = "SELECT * FROM Bil7";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Bil7.class));
        }
        catch(Exception e){
            return null;
        }
    }
}
