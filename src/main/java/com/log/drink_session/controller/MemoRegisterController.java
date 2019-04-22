package com.log.drink_session.controller;

import com.log.drink_session.entity.Memo;
import com.log.drink_session.form.MemoRegisterForm;
import com.log.drink_session.service.MemoRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Memo Controller
 */
@Controller
@RequestMapping(value = "/memo/register")
public class MemoRegisterController {

    /**
     * Memo Register Service
     */
    private final MemoRegisterService service;

    @Autowired
    public MemoRegisterController(MemoRegisterService memoRegisterService) {
        this.service = memoRegisterService;
    }

    /**
     * Memo Register Entry view
     *
     * @param memoRegisterForm Memo Register Form
     * @return Path
     */
    @RequestMapping(value = "")
    public String registerInit(@ModelAttribute MemoRegisterForm memoRegisterForm) {
        return "memo/registerForm";
    }

    /**
     * Memo Register Confirm view
     *
     * @param memoRegisterForm Memo Register Form
     * @return Path
     */
    @RequestMapping(value = "/confirm", method = RequestMethod.POST)
    public String registerConfirm(@ModelAttribute @Validated MemoRegisterForm memoRegisterForm, BindingResult bindingResult, Model model) {
        // BeanValidation
        if (bindingResult.hasErrors()) {
            return "memo/registerForm";
        }
        return "memo/confirmForm";
    }

    /**
     * Memo Register Complete view
     *
     * @param memoRegisterForm Memo Register Form
     * @return Path
     */
    @RequestMapping(value = "/regist", params = "register", method = RequestMethod.POST)
    public String registerComplete(@ModelAttribute @Validated MemoRegisterForm memoRegisterForm, BindingResult bindingResult, Model model) {
        // BeanValidation
        if (bindingResult.hasErrors()) {
            return "memo/registerForm";
        }
        Memo memo = service.createMemo(memoRegisterForm);

        service.register(memo);
        model.addAttribute("completeMessage", "Complete Registration");
        return "memo/completeForm";
    }

    /**
     * Back to the register view
     *
     * @param memoRegisterForm Memo Register Form
     * @return Path
     */
    @RequestMapping(value = "/do", params = "registerBack", method = RequestMethod.POST)
    public String registerBack(@ModelAttribute MemoRegisterForm memoRegisterForm) {
        return "memo/registerForm";
    }
}
