package com.example.demo.motorvogn.motorvogn8;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Motorvogn8Repository {

    @Autowired
    private JdbcTemplate db;

    private Logger logger = LoggerFactory.getLogger(Motorvogn8Repository.class);

    public boolean lagreMotorvogn(Motorvogn8 m) {
        String sql = "INSERT INTO Motorvogn8 (personnr,navn,adresse,kjennetegn,merke,type) VALUES(?,?,?,?,?,?)";
        try{
            db.update(sql,m.getPersonnr(),m.getNavn(),m.getAdresse(),m.getKjennetegn(),m.getMerke(),m.getType());
            return true;
        }
        catch(Exception e){
            logger.error("Feil i lagre motorvogn "+e);
            return false;
        }
    }

    public List<Motorvogn8> hentAlleMotorvogner() {
        String sql = "SELECT * FROM Motorvogn8";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Motorvogn8.class));
        }
        catch(Exception e){
            logger.error("Feil i hent alle motorvogner "+e);
            return null;
        }
     }

     public Motorvogn8 henteEnMotorvogn(int id){
         String sql = "SELECT * FROM Motorvogn8 WHERE id=?";
         try{
             List<Motorvogn8> enMotorvogn  = db.query(sql,new BeanPropertyRowMapper(Motorvogn8.class),id);
             return enMotorvogn.get(0);
         }
         catch(Exception e){
             logger.error("Feil i hent en motorvogn "+e);
             return null;
         }
     }

     public boolean endreMotorvogn(Motorvogn8 m){
         String sql = "UPDATE Motorvogn8 SET personnr=?, navn=?,adresse=?,kjennetegn=?,merke=?,type=? where id=?";
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
        String sql = "DELETE FROM Motorvogn8 WHERE personnr=?";
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
        String sql = "DELETE FROM Motorvogn8";
        try{
            db.update(sql);
            return true;
        }
        catch(Exception e){
            logger.error("Feil i slett alle motorvogner"+e);
            return false;
        }
    }

    public List<Bil8> hentAlleBiler(){
        String sql = "SELECT * FROM Bil8";
        try{
            return db.query(sql,new BeanPropertyRowMapper(Bil8.class));
        }
        catch(Exception e){
            return null;
        }
    }

    public boolean loggInn(String brukernavn,String passord){
        String sql = "SELECT count(*) FROM Bruker8 WHERE brukernavn = ? AND passord = ?";
        try{
            int funnetEnBruker  = db.queryForObject(sql,Integer.class,brukernavn,passord);
            if(funnetEnBruker>0){
                return true;
            }
            else{
                return false;
            }
        }
        catch(Exception e){
            return false;
        }
    }
}
