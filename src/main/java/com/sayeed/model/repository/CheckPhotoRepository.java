package com.sayeed.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sayeed.model.entity.CheckPhoto;

public interface CheckPhotoRepository extends JpaRepository<CheckPhoto, Long> {

	List<CheckPhoto> findByProductTitle(String productTitle);

	

}
