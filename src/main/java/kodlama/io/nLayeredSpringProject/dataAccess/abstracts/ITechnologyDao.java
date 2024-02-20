package kodlama.io.nLayeredSpringProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.nLayeredSpringProject.entities.concretes.Technology;

public interface ITechnologyDao extends  JpaRepository<Technology,Integer> {

}
