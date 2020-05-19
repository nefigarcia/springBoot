package com.giftsIntercambio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.giftsIntercambio.model.*;

@Repository
public interface UsuRepository extends CrudRepository<UsuEntity, Long>{

}