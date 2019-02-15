package com.ias.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ias.model.Ave;


@Repository
public interface AveRepository extends JpaRepository<Ave, String>{
		
	@Query(value = "SELECT ta.CDAVE, ta.DSNOMBRE_COMUN, ta.DSNOMBRE_CIENTIFICO FROM tont_aves ta INNER JOIN tont_aves_pais tap ON (tap.CDAVE = ta.CDAVE) INNER JOIN tont_paises tp ON (tp.CDPAIS = tap.CDPAIS) INNER JOIN tont_zonas  tz ON (tz.CDZONA = tp.CDZONA) WHERE tz.CDZONA = ?1 AND (ta.DSNOMBRE_COMUN LIKE %?2% OR ta.DSNOMBRE_CIENTIFICO LIKE %?2%) ", nativeQuery = true)
	List<Ave> findAvesZonaAndName(@Param("cdzona") String cdzona, @Param("nombre_ave") String nombre_ave );
	
	@Query(value="select * from tont_aves where DSNOMBRE_COMUN = ?1 OR DSNOMBRE_CIENTIFICO = ?1 ", nativeQuery= true)
	List<Ave> returnAvesByNombre(String nombre );
	
	@Query(value = "SELECT ta.CDAVE, ta.DSNOMBRE_COMUN, ta.DSNOMBRE_CIENTIFICO FROM tont_aves ta INNER JOIN tont_aves_pais tap ON (tap.CDAVE = ta.CDAVE) INNER JOIN tont_paises tp ON (tp.CDPAIS = tap.CDPAIS) INNER JOIN tont_zonas  tz ON (tz.CDZONA = tp.CDZONA) WHERE tz.CDZONA = ?1  ", nativeQuery = true)
	List<Ave> returnAvesByZona(String zona );
	
	@Modifying
	@Transactional
	@Query(value = "DELETE FROM tont_aves_pais WHERE CDAVE = ?1  ", nativeQuery = true)
	void deleteAveZona(String aveZona );
}
