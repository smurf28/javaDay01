package com.lhl.service.Impl;

import com.lhl.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class AccountServiceImplTest {
    @Resource(name="AccountServiceImpl")
    private AccountService as;
    @Test
    public void transfer() throws Exception {
        as.transfer(1, 2, 100d);
    }

}