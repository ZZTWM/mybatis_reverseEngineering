package com.how2java.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.how2java.mapper.CategoryMapper;
import com.how2java.pojo.Category;
import com.how2java.pojo.CategoryExample;

/**
 * ���򹤳�
 * @author Administrator
 *
 */
public class TestMybatis01_ReverseEngineering {
	public static void main(String[] args) throws IOException {
		System.out.println("������TestMybatisGenerator����mapper,pojo,xml ���ļ���Ȼ��ȡ��import�ﱻע�͵ģ��Լ���������ע�ͣ���ִ�д���");
		
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session = sqlSessionFactory.openSession();
		
        CategoryExample example = new CategoryExample();
        example.createCriteria().andNameLike("%9%");
		CategoryMapper mapper = session.getMapper(CategoryMapper.class);
		List<Category> cs = mapper.selectByExample(example);
        
		for (Category category : cs) {
			System.out.println(category.getName());
		}
	}
}























