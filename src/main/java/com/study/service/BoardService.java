package com.study.service;

import com.study.dto.BoardDto;
import com.study.dto.CategoryDto;
import com.study.mapper.BoardMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

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

    public List<CategoryDto> getCategoryList() {
        String resource = "mybatis-config.xml";
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            BoardMapper boardMapper = session.getMapper(BoardMapper.class);
            return boardMapper.getCategoryList();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public int getTotalCount() {
        String resource = "mybatis-config.xml";
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            BoardMapper boardMapper = session.getMapper(BoardMapper.class);
            return boardMapper.getTotalCount();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<BoardDto> getBoardList(Map<String, Object> bindingParams) {
        String resource = "mybatis-config.xml";
        SqlSession session = null;

        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            BoardMapper boardMapper = session.getMapper(BoardMapper.class);
            return boardMapper.getBoardList(bindingParams);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }



}