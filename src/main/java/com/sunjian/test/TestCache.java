package com.sunjian.test;

import com.sunjian.entity.Classes;
import com.sunjian.entity.Order;
import com.sunjian.entity.User;
import com.sunjian.repository.ClassesRepository;
import com.sunjian.repository.OrderRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import sun.reflect.generics.repository.ClassRepository;

import java.io.InputStream;

/**
 * @author sunjian
 * @date 2020/3/22 10:20
 */
public class TestCache {
    public static void main(String[] args) {

        // Mapper 代理实现自定义接口
        InputStream inputStream = User.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 获取接口的处理对象
        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes = classesRepository.findClassById(2);
        System.out.println(classes);
        sqlSession.close();

        sqlSession = sqlSessionFactory.openSession();
        // 获取接口的处理对象
        classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes1 = classesRepository.findClassById(2);
        System.out.println(classes1);
    }

}
