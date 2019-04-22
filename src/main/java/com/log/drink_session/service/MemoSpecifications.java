package com.log.drink_session.service;

import com.log.drink_session.entity.Memo;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * Memo searching specification
 */
class MemoSpecifications {

    /**
     * Name like
     */
    static Specification<Memo> nameContains(String name) {
        return StringUtils.isEmpty(name) ? null : new Specification<Memo>() {
            @Override
            public Predicate toPredicate(Root<Memo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.like(root.get("name"), "%" + name + "%");
            }
        };
    }

    /**
     * Content like
     */
    static Specification<Memo> memoContains(String memo) {
        return StringUtils.isEmpty(memo) ? null : new Specification<Memo>() {
            @Override
            public Predicate toPredicate(Root<Memo> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
                return cb.like(root.get("memo"), "%" + memo + "%");
            }
        };
    }
}
