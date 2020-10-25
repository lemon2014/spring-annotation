package org.lemon.spring.transaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Transactional
    public void insertUser(){
        paymentDao.insert();
        System.out.println("插入完成");
        int a = 10/0;
    }
}
