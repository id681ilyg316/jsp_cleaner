package com.four.Mybatis.Test;


import java.io.IOException;


import org.apache.ibatis.session.SqlSession;

import com.four.Mybatis.Bean.Order;
import com.four.Mybatis.Bean.User;
import com.four.Mybatis.Mapper.UserMapper;
import com.four.Mybatis.Util.GetSession;



class MybatisTest {
	/*
	 * 根据xml配置文件（全局配置文件）创建一个sqlSessionFactory对象
	 */
	public static void main(String[] args) throws IOException {
	
		SqlSession sqlsession = GetSession.getSession();
		try {  
			UserMapper up = sqlsession.getMapper(UserMapper.class);
			 Order orderByIDAndTime = up.getOrderByIDAndTime(1, "2019/01/15");
			System.out.println(orderByIDAndTime);
			sqlsession.commit();
		} 
		finally {  
			sqlsession.close(); 
		}
	}
		
}
