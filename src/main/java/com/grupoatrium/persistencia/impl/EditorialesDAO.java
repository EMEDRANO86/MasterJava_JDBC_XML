package com.grupoatrium.persistencia.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Editorial;

/**
 * Clase DAO para Editoriales
 * @author elena
 *
 */
public class EditorialesDAO extends NamedParameterJdbcDaoSupport{
	
	private RowMapper<Editorial> mapeadorEditorial;
	
    public List<Editorial> mostrarTodos(){
        return getNamedParameterJdbcTemplate().query("select * from EDITORIAL",
                (Map<String,Object>)null, mapeadorEditorial);
    }

    public Editorial consultarEditorial(String nombre){
        String sql = "select * from EDITORIAL where NOMBRE = :codigo";
        Map<String,Object> parametros = new HashMap<String, Object>();
        parametros.put("codigo", nombre);

        return getNamedParameterJdbcTemplate().queryForObject(sql, parametros, mapeadorEditorial);
    }
    
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void altaEditorial(Editorial l) {
		String sql = "insert into Editorial values (:nombre,:direccion,:nif)";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("nombre", l.getNombre());
		parametros.put("direccion", l.getDireccion());
		parametros.put("nif", l.getNif());
		getNamedParameterJdbcTemplate().update(sql, parametros);

		System.out.println("Alta de Editorial realizada correctamente");
	}
	
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void updateDireccion(String nombre,String direccion) {
		String sql = "UPDATE Editorial SET direccion = :direccion WHERE nombre = :nombre";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("direccion",direccion);
		parametros.put("nombre",nombre);
		getNamedParameterJdbcTemplate().update(sql, parametros);
		
		System.out.println("Registro actualizado");
	}
	
	
	public void deleteEditorial(String nombre) {
		String sql = "DELETE FROM Editorial WHERE nombre = :codigo";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo",nombre);
		getNamedParameterJdbcTemplate().update(sql,parametros);
		
		System.out.println("Registro borrado");
	}

	/**
	 * @return the mapeadorEditorial
	 */
	public RowMapper<Editorial> getMapeadorEditorial() {
		return mapeadorEditorial;
	}

	/**
	 * @param mapeadorEditorial the mapeadorEditorial to set
	 */
	public void setMapeadorEditorial(RowMapper<Editorial> mapeadorEditorial) {
		this.mapeadorEditorial = mapeadorEditorial;
	}
    
    
	
	

}
