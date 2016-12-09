package com.jg2b.web.auth.croe;

import java.io.IOException;

import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.core.NestedIOException;

public class JG2BBeanFactory extends SqlSessionFactoryBean {

	@Override
	protected SqlSessionFactory buildSqlSessionFactory() throws IOException{
		try {
			return super.buildSqlSessionFactory();
		} catch (NestedIOException e) {
			e.printStackTrace();
			throw new NestedIOException("加载mybatis配置文件出错："+e);
		} finally {
			ErrorContext.instance().reset();
		}
	}
	

}
