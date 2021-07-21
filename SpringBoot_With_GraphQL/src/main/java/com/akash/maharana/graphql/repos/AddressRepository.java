package com.akash.maharana.graphql.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akash.maharana.graphql.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

}
