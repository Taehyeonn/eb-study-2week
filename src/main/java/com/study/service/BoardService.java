package com.study.service;

import com.study.mapper.BoardMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class BoardService {

    public String getWriterById(int boardId) {
        String resource = "mybatis-config.xml";
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            BoardMapper boardMapper = session.getMapper(BoardMapper.class);
            return boardMapper.selectWriterById(boardId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }



}