package com.newer.service;

import com.newer.domain.TeaOder;
import com.newer.mapper.TeaOderMapper;
import com.newer.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;

public class TeaOderService {
    private TeaOderMapper teaOderMapper;
    private SqlSession sqlSession;

    public TeaOderService(){
        sqlSession= SqlSessionUtil.getSqlSession();
        teaOderMapper=((SqlSession) sqlSession).getMapper(TeaOderMapper.class);
    }
    public  int addOder(TeaOder teaOder){
        int rows=teaOderMapper.addOder(teaOder);
        sqlSession.commit();
        return rows;
    }

    public void close(){
        if (sqlSession!=null){
            SqlSessionUtil.closeSqlSession(sqlSession);
        }
    }




}

