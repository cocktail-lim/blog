package com.finn;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/*
 * @description: mybatis工具类
 * @author: Finn
 * @create: 2022-01-11-20-40
 */
public class MyBatisUtil {

    private static SqlSessionFactory factory = null;

    static {

        String config = "mybatis.xml";
        try(InputStream is = Resources.getResourceAsStream(config)){
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 获取SqlSession对象
    public static SqlSession getSqlSession() {
        SqlSession session = null;
        if(factory != null) {
            session = factory.openSession();
        }
        return session;
    }

    // 获取SqlSession对象，手动/自动提交事务
    public static SqlSession getSqlSession(boolean b) {
        SqlSession session = null;
        if(factory != null) {
            session = factory.openSession(b);
        }
        return session;
    }

}
