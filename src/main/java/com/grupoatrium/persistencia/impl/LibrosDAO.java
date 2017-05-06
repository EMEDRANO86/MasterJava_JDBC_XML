package com.grupoatrium.persistencia.impl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.grupoatrium.modelo.Libro;

/**
 * Clase DAO para Libros
 * 
 * @author Elena
 *
 */
public class LibrosDAO {

	private NamedParameterJdbcTemplate plantilla;
	private RowMapper<Libro> mapeadorLibro;

	public List<Libro> mostrarTodos() {
		return plantilla.query("select * from LIBRO", (Map<String, Object>) null, mapeadorLibro);
	}

	public Libro consultarLibro(String isbn) {
		String sql = "select * from LIBRO where ISBN = :codigo";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo", isbn);

		return plantilla.queryForObject(sql, parametros, mapeadorLibro);
	}

	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void altaLibro(Libro l) {
		String sql = "insert into LIBRO values (:isbn,:titulo,:autor,:editorial,:publicacion,:precio,:descripcion)";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("isbn", l.getIsbn());
		parametros.put("titulo", l.getTitulo());
		parametros.put("autor", l.getAutores());
		parametros.put("editorial", l.getEditorial());
		parametros.put("publicacion", l.getPublicacion());
		parametros.put("precio", l.getPrecio());
		parametros.put("descripcion", l.getDescripcion());
		plantilla.update(sql, parametros);

		System.out.println("Alta de libro realizada correctamente");
	}
	
	@Transactional(rollbackFor = SQLException.class, isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRED)
	public void updateTitulo(String isbn,String titulo) {
		String sql = "UPDATE LIBRO SET TITULO = :titulo WHERE ISBN = :isbn";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("titulo",titulo);
		parametros.put("isbn",isbn);
		plantilla.update(sql, parametros);
		
		System.out.println("Registro actualizado");
	}
	
	
	public void deleteLibro(String isbn) {
		String sql = "DELETE FROM LIBRO WHERE ISBN = :codigo";
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put("codigo",isbn);
		plantilla.update(sql,parametros);
		
		System.out.println("Registro borrado");
	}

	/**
	 * @return the mapeadorLibro
	 */
	public RowMapper<Libro> getMapeadorLibro() {
		return mapeadorLibro;
	}

	/**
	 * @param mapeadorLibro
	 *            the mapeadorLibro to set
	 */
	public void setMapeadorLibro(RowMapper<Libro> mapeadorLibro) {
		this.mapeadorLibro = mapeadorLibro;
	}

	/**
	 * @return the plantilla
	 */
	public NamedParameterJdbcTemplate getPlantilla() {
		return plantilla;
	}

	/**
	 * @param plantilla the plantilla to set
	 */
	public void setPlantilla(NamedParameterJdbcTemplate plantilla) {
		this.plantilla = plantilla;
	}
	
	

}
