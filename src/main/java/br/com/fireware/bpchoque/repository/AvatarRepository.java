package br.com.fireware.bpchoque.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import br.com.fireware.bpchoque.entity.Avatar;

public interface AvatarRepository extends CrudRepository<Avatar, Long>{

	
}
