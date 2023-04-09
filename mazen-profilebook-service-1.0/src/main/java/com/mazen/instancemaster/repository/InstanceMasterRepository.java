package com.mazen.instancemaster.repository;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mazen.profilebook.model.instancemaster.AbstractInstanceMaster;


@Repository
@Document(collection = "instanceMaster")
public interface InstanceMasterRepository extends MongoRepository<AbstractInstanceMaster, String> {
	
	@Query("{businessName' : ?0 }")
	AbstractInstanceMaster findByBusinessName(String businessName);
	
	@Query("{'supportedType' : ?0}")
	public List<AbstractInstanceMaster> findByType(String type);

}
