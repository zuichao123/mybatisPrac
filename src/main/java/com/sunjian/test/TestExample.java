package com.sunjian.test;

import com.sunjian.entity.Account;
import com.sunjian.entity.AccountExample;

import java.util.List;

/**
 * @author sunjian
 * @date 2020/3/22 23:43
 */
public class TestExample {
    public static void main(String[] args) {
        AccountExample accountExample = new AccountExample();
        accountExample.setOrderByClause("username desc");
        accountExample.setDistinct(false);
        AccountExample.Criteria criteria = accountExample.createCriteria();
        criteria.andUsernameEqualTo("张三");
//        List<Account> accounts = accountExample.selectByExample(accountExample);
    }
}
