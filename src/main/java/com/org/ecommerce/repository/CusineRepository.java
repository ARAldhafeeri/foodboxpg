package com.org.ecommerce.repository;

import com.org.ecommerce.modal.Cusine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface CusineRepository extends JpaRepository<Cusine, Integer> {
	
    @Query("SELECT c FROM Cusine c WHERE c.id =:id")
    Cusine getCusineById(@Param("id") long id);
    
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query("DELETE FROM Cusine c WHERE c.id = :id")
	int deleteCusine(@Param("id") long id);
    
    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Transactional
    @Query(value="UPDATE Cusine c SET c.name = :name WHERE c.id = :id", nativeQuery = true)
    int updCusine(@Param("id") long id, @Param("name") String name);
}

