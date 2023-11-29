package com.four.Mybatis.Util;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.four.Mybatis.Bean.Cloth;

/** 
* @author four_WW: 
* @version 创建时间：2019年1月10日 下午3:50:36 
* @function:获取sqlsession实例
*/
public class GetSession {
	public static SqlSession getSession() throws IOException {
		String resource = "mybatis-config.xml"; 
		InputStream inputStream = Resources.getResourceAsStream(resource); 
		SqlSessionFactory sqlSessionFactory =  new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession(); 
		return session;
	}

}
