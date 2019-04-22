package com.log.drink_session.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Memo Repository
 */
public interface MemoRepository extends JpaRepository<Memo, Integer>, JpaSpecificationExecutor<Memo> {
}