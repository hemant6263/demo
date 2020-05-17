package com.abc.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.abc.demo.entities.AbstractEntity;

@NoRepositoryBean
public interface AbstractJpaRepository<T extends AbstractEntity, ID extends Serializable> extends JpaRepository<T, ID> {


}