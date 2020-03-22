package com.sunjian.test;

import com.sunjian.entity.Classes;
import com.sunjian.entity.Course;
import com.sunjian.entity.Student;
import com.sunjian.repository.ClassesRepository;
import com.sunjian.repository.CourseRepository;
import com.sunjian.repository.StudentRepository;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @author sunjian
 * @date 2020/3/22 14:40
 */
public class TestMoreTable {
    public static void main(String[] args) {
        InputStream inputStream = Student.class.getClassLoader().getResourceAsStream("config.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 一对一
        StudentRepository studentRepository = sqlSession.getMapper(StudentRepository.class);
        Student student = studentRepository.findStudentById(2);
        System.out.println(student);

        // 一对多
        ClassesRepository classesRepository = sqlSession.getMapper(ClassesRepository.class);
        Classes classes = classesRepository.findClassById(2);
        System.out.println(classes);

        // 多对多
        CourseRepository courseRepository = sqlSession.getMapper(CourseRepository.class);
        Course course = courseRepository.findCourseById(2);
        System.out.println(course);
    }
}
