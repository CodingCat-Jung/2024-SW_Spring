package edu.sch.dwitterserver.repository;

import edu.sch.dwitterserver.domain.Dwitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataJpaDwitterRepository extends JpaRepository<Dwitter, Long> {
    //JpaRepository: save, findAll, delete (CRUD Repository)
}

