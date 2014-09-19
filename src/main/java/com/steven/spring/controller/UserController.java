package com.steven.spring.controller;

import com.steven.annotation.Name;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author gaochuanjun
 * @since 14-9-19
 */
@Controller
@RequestMapping(value = "executor_mgmt")
public class UserController {

    @RequestMapping(value = "enable", method = RequestMethod.GET)
    @Name(originate = "允许", community = "test")
    public String enable() {

        return null;
    }
}
