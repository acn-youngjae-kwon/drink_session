package com.log.drink_session.service;

import com.log.drink_session.entity.Memo;
import com.log.drink_session.entity.MemoRepository;
import com.log.drink_session.form.MemoRegisterForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemoRegisterService {
    /**
     * Memo Repository
     */
    private final MemoRepository memoRepository;

    @Autowired
    public MemoRegisterService(MemoRepository memoRepository) {
        this.memoRepository = memoRepository;
    }

    /**
     * Registration
     *
     * @param memo Memo Entity
     */
    @Transactional
    public void register(Memo memo) {
        memoRepository.save(memo);
    }

    /**
     * Make memo entity by form data
     *
     * @param memoRegisterForm Memo Register Form
     * @return Memo Entity
     */
    public Memo createMemo(MemoRegisterForm memoRegisterForm) {
        Memo memo = new Memo();
        memo.setName(memoRegisterForm.getName());
        memo.setMemo(memoRegisterForm.getMemo());
        return memo;
    }
}
