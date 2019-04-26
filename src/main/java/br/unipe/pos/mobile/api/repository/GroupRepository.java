package br.unipe.pos.mobile.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.pos.mobile.api.model.Group;
import br.unipe.pos.mobile.api.model.User;

@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
	
	//List<Group> findByUsersIn(User user);
	

}
