package com.lhl.service.Impl;

import com.lhl.Dao.AccountDao;
import com.lhl.service.AccountService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import javax.annotation.Resource;


@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=true)
@Component("AccountServiceImpl")
public class AccountServiceImpl implements AccountService {
    @Resource(name = "accountDao")
    private AccountDao ad ;
    @Resource(name = "transactionTemplate")
    private TransactionTemplate tt;

    @Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
    public void transfer(final Integer from,final Integer to,final Double money) {
        //ºı«Æ
        ad.decreaseMoney(from, money);
//        int i = 1/0;
        //º”«Æ
        ad.increaseMoney(to, money);
    }

    /*
        public void transfer(final Integer from,final Integer to,final Double money) {

            tt.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus arg0) {
                    //ºı«Æ
                    ad.decreaseMoney(from, money);
                    int i = 1/0;
                    //º”«Æ
                    ad.increaseMoney(to, money);
                }
            });


        }
    */
    public void setAd(AccountDao ad) {
        this.ad = ad;
    }

    public void setTt(TransactionTemplate tt) {
        this.tt = tt;
    }

}

