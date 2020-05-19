package com.itheima.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.Extension.Parameter;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.itheima.domain.Book;
import com.itheima.util.C3P0Util;

public class BookDaoImpl {
	/**
	 * 查找所有图书
	 * @return
	 * @throws SQLException
	 */
	public List<Book> findAllBooks() throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book", new BeanListHandler<Book>(Book.class));
		
	}
	
	/**
	 * 添加图书信息
	 * @param book
	 * @throws SQLException
	 */
	
	public void addBook(Book book) throws SQLException{
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("INSERT INTO book VALUES(?,?,?,?,?,?)", book.getId(),book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription());
	}
	/**
	 * @return 
	 * @throws SQLException 
	 * 
	 */

	public Book findBookById(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book where id =?", new BeanHandler<Book>(Book.class),id);
		
	}
	/**
	 * 修改图书信息
	 * @param book
	 * @throws SQLException
	 */

	public void updateBook(Book book) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("update book set name=?,price=?,pnum=?,category=?,description=? where id=?",
				book.getName(),book.getPrice(),book.getPnum(),book.getCategory(),book.getDescription(),book.getId());
	
		
	}
	/**
	 * 根据ID删除图书
	 * @param id
	 * @throws SQLException
	 */

	public void delBook(String id) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		qr.update("delete from book where id=?",id);
		
	}
	/**
	 * 批量删除
	 * @param ids
	 * @throws SQLException 
	 */

	public void delAllBooks(String[] ids) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		//二维数组是个表格，Object后面第一个[]里面是行，第二个[]里面是列;
		Object[][] params=new Object[ids.length][];
		for (int i = 0; i < params.length; i++) {
			params[i]=new Object[] {ids[i]};//循环给每个一维元素中的数组赋值，值是id
		}
		qr.batch("delete from book where id=?",params);
		
	}
	/**
	 * 多条件查询图书
	 * @param id
	 * @param category
	 * @param name
	 * @param minprice
	 * @param maxprice
	 * @return
	 * @throws SQLException 
	 */

	public List<Book> searchBooks(String id, String category, String name, String minprice, String maxprice) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		String sql="select * from book where 1=1";
		
		List list=new ArrayList();
		
		if(!"".equals(id.trim())) {
			sql+=" and id like ?";//,不能在这写% ,否则效果为： %'1002'%
			list.add("%"+id.trim()+"%");//and id like'%1002%'
		}
		
		if(!"".equals(category.trim())) {
			sql+=" and category=?";
			list.add(category.trim());
		}
		
		if(!"".equals(name.trim())) {
			sql+=" and name like ?";
			list.add("%"+name.trim()+"%");
		}
		
		if(!"".equals(minprice.trim())) {
			sql+=" and price>?";
			list.add(minprice.trim());
		}
		
		if(!"".equals(maxprice.trim())) {
			sql+=" and price<?";
			list.add(maxprice.trim());
		}
		
		return qr.query(sql, new BeanListHandler<Book>(Book.class),list.toArray());
	}
	
	/**
	 * 得到总记录数
	 * @return
	 * @throws SQLException
	 */

	public int count() throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		//ScalarHandler的作用是将数据库中某一个字段的数据封装成一个Object对象,括号里是数字1
		long l=(long) qr.query("select count(*) from book", new ScalarHandler(1));
		return (int)l;
	}
	
	/**
	 * 查找分页数据
	 * @param currentPage
	 * @param pageSize
	 * @return
	 * @throws SQLException 
	 */

	public List<Book> findBooks(int currentPage, int pageSize) throws SQLException {
		QueryRunner qr=new QueryRunner(C3P0Util.getDataSource());
		return qr.query("select * from book limit ?,?", new BeanListHandler<Book>(Book.class),(currentPage-1)*pageSize,pageSize);
		
	
	}

}
