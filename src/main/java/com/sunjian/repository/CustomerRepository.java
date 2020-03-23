package com.sunjian.repository;

import com.sunjian.entity.Customer;
import com.sunjian.entity.Order;

/**
 * @author sunjian
 * @date 2020/3/23 14:41
 */
public interface CustomerRepository {
    public Customer findCustomerById(Long id);
}
