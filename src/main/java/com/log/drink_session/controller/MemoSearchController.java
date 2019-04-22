package com.log.drink_session.controller;

import com.log.drink_session.entity.Memo;
import com.log.drink_session.form.MemoSearchForm;
import com.log.drink_session.service.MemoSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

/**
 * Memo Controller
 */
@Controller
@RequestMapping(value = "/memo/search")
public class MemoSearchController {
    /** Memo Search Service */
    private final MemoSearchService memoSearchService;

    /**
     * Constructor
     */
    @Autowired
    public MemoSearchController(MemoSearchService memoSearchService) {
        this.memoSearchService = memoSearchService;
    }

    /**
     * 初期表示。
     */
    @RequestMapping(value = "")
    public String init(@ModelAttribute MemoSearchForm memoSearchForm, Model model) {
        return "memo/searchForm";
    }

    /**
     * Run search
     */
    @RequestMapping(value = "/result")
    public String search(@ModelAttribute @Validated MemoSearchForm memoSearchForm, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "memo/searchForm";
        }

        List<Memo> memos = this.memoSearchService.searchMemos(memoSearchForm);
        if (memos.isEmpty()) model.addAttribute("errorMessage", "No memos.");
        model.addAttribute("memos", memos);

        return "memo/searchForm";
    }

    /**
     * Specification
     */
    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public String showDetail(@RequestParam("id") int id, Model model) {
        Memo memo = this.memoSearchService.getById(id);
        if (Objects.isNull(memo)) return "redirect:/memo/search";

        model.addAttribute("memo", memo);

        return "memo/searchDetail";
    }
}
