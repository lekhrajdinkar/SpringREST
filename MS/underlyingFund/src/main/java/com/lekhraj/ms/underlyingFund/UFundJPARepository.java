package com.lekhraj.ms.underlyingFund;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UFundJPARepository extends JpaRepository<UFund, Integer>{

	public UFund findByName(String name);
}
