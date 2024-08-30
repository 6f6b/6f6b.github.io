package com.example.mybatis.mybatisdemo;

import com.example.mybatis.mybatisdemo.entity.Author;
import com.example.mybatis.mybatisdemo.entity.Blog;
import com.example.mybatis.mybatisdemo.mapper.AuthorMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

@SpringBootTest
class MybatisDemoApplicationTests {
    private Logger logger = LoggerFactory.getLogger(MybatisDemoApplicationTests.class);

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

            //
            AuthorMapper authorMapper = sqlSession.getMapper(AuthorMapper.class);
            HashMap<String,Object> author = authorMapper.selectAuthor(1);
            logger.info(author.toString());

            List<Author> authors = authorMapper.selectAuthors();

            sqlSession.close();
        }catch (Exception e){
            LoggerFactory.getLogger(this.getClass()).error(e.toString());
        }finally {
        }
    }

}
