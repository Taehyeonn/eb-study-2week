package com.study.service;

import com.study.connection.MyBatisConnectionFactory;
import com.study.dto.BoardDto;
import com.study.dto.CommentDto;
import com.study.mapper.BoardMapper;
import com.study.mapper.CommentMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class CommentService {

    public List<CommentDto> getCommentsByBoardId(String id) {
        SqlSession sqlSession = null;

        try {
            SqlSessionFactory sqlSessionFactory = MyBatisConnectionFactory.getSqlSessionFactory();
            sqlSession = sqlSessionFactory.openSession();
            CommentMapper commentMapper = sqlSession.getMapper(CommentMapper.class);
            return commentMapper.getCommentsByBoardId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
