package com.sunjian.test;

import com.sunjian.entity.User;
import com.sunjian.repository.UserRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author sunjian
 * @date 2020/3/22 10:20
 */
public class TestOneTable {
    public static void main(String[] args) {
//        myBatisDefaultWay();

        // Mapper 代理实现自定义接口
        InputStream inputStream = User.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取接口的处理对象
        UserRepository userRepository = sqlSession.getMapper(UserRepository.class);

        // 增加
//        User u = new User();
//        u.setUsername("王五2");
//        u.setPassword("123456");
//        u.setAge(19);
//        userRepository.addUser(u);
//        sqlSession.commit();

        // 删除
//        userRepository.deleteUser(3);
//        sqlSession.commit();

        // 修改
//        User u2 = userRepository.findUserById(1);
//        if(u2 != null){
//            u2.setUsername("张三1");
//            u2.setPassword("1234567");
//            u2.setAge(88);
//            userRepository.updateUser(u2);
//            sqlSession.commit();
//        }

        // 根据id查
//        User user = userRepository.findUserById(2);
//        System.out.println(user);

        // 查所有
//        List<User> list = userRepository.findAll();        //        for(User u1: list){
//            System.out.println(u1);
//        }

        // 根据username查
        User u3 = userRepository.findUserByName("张三");
        System.out.println(u3);

        // 根据id和username查
        User u4 = userRepository.findUserByIdAndName(2, "张三");
        System.out.println(u4);

        // 根据User查
        User u5 = new User();
        u5.setId(2);
        u5.setUsername("张三");
        u5 = userRepository.findUserByUser(u5);
        System.out.println(u5);

        // 根据id查username
        String username = userRepository.findUsernameById(2);
        System.out.println(username);
    }

    /**
     * myBatis 提供的原生接口方式
     */
    private static void myBatisDefaultWay() {
        InputStream inputStream = TestOneTable.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        String statement = "com.sunjian.mapper.UserMapper.findById";
        User user = sqlSession.selectOne(statement, 1);
        System.out.println(user);
    }
}
