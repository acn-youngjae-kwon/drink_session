package com.log.drink_session.form;

import javax.validation.constraints.Size;

/**
 * Memo Search Form
 */
public class MemoSearchForm {

    @Size(max = 45)
    private String name;

    @Size(max = 200)
    private String memo;

    public String getName() {
        return name;
    }

    public String getMemo() {
        return memo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }
}

