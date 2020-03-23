package com.sunjian.test;

import com.sunjian.entity.Order;
import com.sunjian.entity.User;
import com.sunjian.repository.OrderRepository;
import com.sunjian.repository.UserRepositoryDynamicSQL;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjian
 * @date 2020/3/22 10:20
 */
public class TestDynamicSQL {
    public static void main(String[] args) {

        // Mapper 代理实现自定义接口
        InputStream inputStream = User.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取接口的处理对象
        UserRepositoryDynamicSQL userRepositoryDynamicSQL = sqlSession.getMapper(UserRepositoryDynamicSQL.class);
        User user = new User();
        user.setAge(33);
        User user1 = userRepositoryDynamicSQL.findUserByUser(user);
        System.out.println(user1);

        User u = new User();
        u.setId(2);
        u.setUsername("张三三");
        u.setPassword("123");
        userRepositoryDynamicSQL.updateUser(u);
        sqlSession.commit();
        User user2 = userRepositoryDynamicSQL.findUserByUser(u);
        System.out.println(user2);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(6);
        User u2 = new User();
        u2.setIds(list);
        List<User> users = userRepositoryDynamicSQL.findAllByUser(u2);
        for(User us:users){
            System.out.println(us);
        }
    }

}
