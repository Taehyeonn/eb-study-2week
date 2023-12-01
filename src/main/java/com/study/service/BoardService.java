package com.study.service;

import com.study.connection.MyBatisConnectionFactory;
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

    public List<CategoryDto> getCategoryList() {
        SqlSession sqlSession = null;

        try {
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            return boardMapper.getCategoryList();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public int getTotalCount() {
        SqlSession sqlSession = null;

        try {
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            return boardMapper.getTotalCount();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public List<BoardDto> getBoardList(Map<String, Object> bindingParams) {
        SqlSession sqlSession = null;

        try {
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            return boardMapper.getBoardList(bindingParams);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public BoardDto getBoardById(String id) {
        SqlSession sqlSession = null;

        try {
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            BoardMapper boardMapper = sqlSession.getMapper(BoardMapper.class);
            return boardMapper.getBoardById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void increaseViewCount(String id) {
        SqlSession sqlSession = null;

        try {
            // MyBatis의 SqlSessionFactory를 이용하여 SqlSession을 생성
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.getMapper(BoardMapper.class).increaseViewCount(id);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void writeBoard(Map<String, Object> bindingParams) {
        SqlSession sqlSession = null;

        try {
            // MyBatis의 SqlSessionFactory를 이용하여 SqlSession을 생성
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.getMapper(BoardMapper.class).writeBoard(bindingParams);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public void modifyBoard(Map<String, Object> bindingParams) {
        SqlSession sqlSession = null;

        try {
            // MyBatis의 SqlSessionFactory를 이용하여 SqlSession을 생성
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            sqlSession.getMapper(BoardMapper.class).modifyBoard(bindingParams);
            sqlSession.commit();
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    public int passwordCheck(Map<String, Object> bindingParams) {
        SqlSession sqlSession = null;

        int result = 0;
        try {
            // MyBatis의 SqlSessionFactory를 이용하여 SqlSession을 생성
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            result = sqlSession.getMapper(BoardMapper.class).passwordCheck(bindingParams);
            sqlSession.commit();
            return result;
        } catch (Exception e) {
            if (sqlSession != null) {
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return result;
    }

}