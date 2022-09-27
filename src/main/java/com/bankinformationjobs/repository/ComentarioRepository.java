package com.bankinformationjobs.repository;

import com.bankinformationjobs.domain.entity.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

    List<Comentario> findByProfesionalId(Integer postId);
}
