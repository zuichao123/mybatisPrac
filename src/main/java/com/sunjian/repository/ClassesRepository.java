package com.sunjian.repository;

import com.sunjian.entity.Classes;
import com.sunjian.entity.Student;

import java.util.List;

/**
 * @author sunjian
 * @date 2020/3/22 15:07
 */
public interface ClassesRepository {
    public Classes findClassById(Integer id);
}
