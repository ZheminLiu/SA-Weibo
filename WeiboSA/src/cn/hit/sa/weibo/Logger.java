package cn.hit.sa.weibo;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import com.mysql.jdbc.PreparedStatement;

import cn.hit.sa.util.DBUtil;

/**
 * 日志构件
 * 用于微博记录操作日志
 * 
 * @author Mandy
 * @version 0.0.1
 * 
 */
public class Logger implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		WeiboWrapper ws = (WeiboWrapper)o;
		WeiboChangeEvent event = (WeiboChangeEvent)arg;
		
		switch(event.getType())
		{
		case WeiboChangeEvent.ADD:
			System.out.println("Logger-添加微博");
			break;
		case WeiboChangeEvent.DELETE:
			System.out.println("Logger-删除微博");
			break;
		case WeiboChangeEvent.UPDATE:
			System.out.println("Logger-修改微博");
	    	Connection conn = DBUtil.getConn();
	    	int i = 0;  
	        String sql = "insert into log(type, time, user) values(?,?,?)";  
	        PreparedStatement pstmt;  
	        try {  
	            pstmt = (PreparedStatement) conn.prepareStatement(sql);  
	            pstmt.setString(1, WeiboChangeEvent.UPDATE+"");  
	            pstmt.setString(2, System.currentTimeMillis()+"");  
	            pstmt.setString(3, ws.getWeibos_().getAuthor()+"");  
	            i = pstmt.executeUpdate();  
	            System.out.println(i);
	            pstmt.close();  
	            conn.close();  
	        } catch (SQLException e) {  
	            e.printStackTrace();  
	        } 
			break;
		default:
			System.out.println("Logger-默认操作");
			break;
		}
		
	}
	

}
