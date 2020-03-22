package com.sunjian.repository;

import com.sunjian.entity.Student;

/**
 * @author sunjian
 * @date 2020/3/22 14:33
 */
public interface StudentRepository {
    public Student findStudentById(Integer id);
}
