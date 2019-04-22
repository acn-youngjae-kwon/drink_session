package com.log.drink_session.service;

import com.log.drink_session.entity.Memo;
import com.log.drink_session.entity.MemoRepository;
import com.log.drink_session.form.MemoSearchForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.log.drink_session.service.MemoSpecifications.memoContains;
import static com.log.drink_session.service.MemoSpecifications.nameContains;

@Service
public class MemoSearchService {

    /**
     * Memo Repository
     */
    private final MemoRepository memoRepository;

    /**
     * Constructor
     */
    @Autowired
    public MemoSearchService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /**
     * Search memo list
     *
     * @param memoSearchForm Memo Search Form
     * @return Memo List
     */
    @Transactional
    public List<Memo> searchMemos(MemoSearchForm memoSearchForm) {
        return this.memoRepository.findAll(
                Specification
                        .where(nameContains(memoSearchForm.getName()))
                        .and(memoContains(memoSearchForm.getMemo()))
        );
    }

    /**
     * Get memo by id (For detail) : Just sample
     *
     * @param id ID
     * @return Entity
     */
    public Memo getById(int id) {
        return (this.memoRepository.findById(id).isPresent())
                ? this.memoRepository.findById(id).get()
                : null;
    }
}
