package com.example.demo.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.CommentCommunity;
import com.example.demo.model.Incidence;

public interface IncidenceRepo extends JpaRepository<Incidence, Long>{

	/**
	 * Query que devuelve una lista de todos las incidencias de la base de datos
	 * @return
	 */
	@Query(value="SELECT * FROM incidence", nativeQuery = true)
	List<Incidence>getAllIncidences();
	
	/**
	 * Elimina una incidencia asociada a un comentario
	 * @param idComment
	 */
	@Modifying 
	@Transactional
	@Query(value="DELETE FROM incidence WHERE comment_id = ?1", nativeQuery = true)
	void deleteIncidence(Long idComment);
}
