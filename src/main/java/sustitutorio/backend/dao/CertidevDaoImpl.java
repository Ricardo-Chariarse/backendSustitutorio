package sustitutorio.backend.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import sustitutorio.backend.dto.Alternativas;
import sustitutorio.backend.dto.Examen;
import sustitutorio.backend.dto.Pregunta;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CertidevDaoImpl implements CertidevDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public Examen BuscarPreguntas() {
        String SQL = "SELECT * from preguntas";
        String SQL2 = "select * from alternativa where codigo_pregunta = ?";
        Examen examen = new Examen();
        examen.setPreguntas(new ArrayList<Pregunta>());
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                List<Alternativas> alternativas = new ArrayList<Alternativas>();
                Pregunta pregunta = new Pregunta();
                pregunta.setAlternativas(new ArrayList<Alternativas>());
                pregunta.setEnunciado(rs.getString("enunciado"));
                pregunta.setCodPregunta(rs.getInt("codigo_pregunta"));
                PreparedStatement ps2 = con.prepareStatement(SQL2);
                ps2.setInt(1, pregunta.getCodPregunta());
                ResultSet rs2 = ps2.executeQuery();
                while(rs2.next()){
                    Alternativas alternativas1 = new Alternativas();
                    alternativas1.setEnunciado(rs2.getString("enunciado"));
                    alternativas.add(alternativas1);
                }
                rs2.close();
                ps2.close();
                pregunta.setAlternativas(alternativas);
                examen.getPreguntas().add(pregunta);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return examen;
    }
    public Examen BuscarRespuestas(){
        String SQL = "SELECT p.codigo_pregunta, p.enunciado p_enunciado, " +
                " a.cod_alternativa, a.enunciado a_enunciado, a.correcto " +
                "FROM pregunta p " +
                "JOIN alternativa a " +
                "ON (p.cod_pregunta = a.cod_pregunta) " +
                "WHERE a.correcto='1' ";
        Examen examen = new Examen();
        examen.setPreguntas(new ArrayList<Pregunta>());
        try {
            Connection con = jdbcTemplate.getDataSource().getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(SQL);
            while(rs.next()){
                Pregunta pregunta = new Pregunta();
                pregunta.setEnunciado(rs.getString("p_enunciado"));
                List<Alternativas> alternativas = new ArrayList<Alternativas>();
                Alternativas alternativas1 = new Alternativas();
                alternativas1.setEnunciado(rs.getString("a_enunciado"));
                alternativas.add(alternativas1);
                pregunta.setAlternativas(alternativas);
                examen.getPreguntas().add(pregunta);
            }
            rs.close();
            st.close();
            con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return examen;

    }

}
