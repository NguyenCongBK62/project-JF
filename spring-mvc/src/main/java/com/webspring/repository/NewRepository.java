package com.webspring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webspring.entity.NewEntity;

public interface NewRepository extends JpaRepository<NewEntity, Long> {
	
}
