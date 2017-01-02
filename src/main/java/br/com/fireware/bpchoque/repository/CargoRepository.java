package br.com.fireware.bpchoque.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.fireware.bpchoque.entity.Cargo;

public interface CargoRepository extends CrudRepository<Cargo, Long>{

	public Cargo findByNome(String nome);
	
}
