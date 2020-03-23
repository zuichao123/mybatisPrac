package com.sunjian.test;

import com.sunjian.entity.Customer;
import com.sunjian.entity.Order;
import com.sunjian.entity.User;
import com.sunjian.repository.CustomerRepository;
import com.sunjian.repository.OrderRepository;
import com.sunjian.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author sunjian
 * @date 2020/3/22 10:20
 */
public class Test {
    public static void main(String[] args) {

        // Mapper 代理实现自定义接口
        InputStream inputStream = Order.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取接口的处理对象
        OrderRepository orderRepository = sqlSession.getMapper(OrderRepository.class);
        Order order = orderRepository.findOrderById(1L);
        System.out.println(order.getName());

//        CustomerRepository customerRepository = sqlSession.getMapper(CustomerRepository.class);
//        Customer customer = customerRepository.findCustomerById(1L);
//        System.out.println(customer);

    }

}
