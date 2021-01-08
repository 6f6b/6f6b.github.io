package com.example.mybatis.mybatisdemo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;

@SpringBootTest
class MybatisDemoApplicationTests {

    @Test
    void contextLoads() {

    }

    @Test
    public void test() throws IOException {
        String resource = "mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            //直接调用statement的Id
//            UserInfo userInfo = sqlSession.selectOne("com.example.mybatis.mybatisdemo.UserInfoMapper.selectUser",1);
            Blog blog = sqlSession.selectOne("com.example.mybatis.mybatisdemo.BlogMapper.selectBlog",1);

            System.out.println(blog.toString());
            sqlSession.close();
        }catch (Exception e){
            LoggerFactory.getLogger(this.getClass()).error(e.toString());
        }finally {
        }
    }

}
