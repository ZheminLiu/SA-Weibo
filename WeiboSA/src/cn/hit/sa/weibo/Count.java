package cn.hit.sa.weibo;

import java.sql.SQLException;
import java.util.Observable;
import java.util.Observer;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import cn.hit.sa.util.DBUtil;

/**
 * 记数构件
 * 用于记录微博点击次数
 * 
 * @author Mandy
 * @version 0.0.1
 *
 */
public class Count implements Observer{

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		WeiboWrapper weibo = (WeiboWrapper)arg0;
		WeiboChangeEvent event = (WeiboChangeEvent)arg1;
		
		switch(event.getType()){
		case WeiboChangeEvent.READ:
			//数据库中对应计数加1
			System.out.println("Count-查看微博");
			Connection conn = (Connection)DBUtil.getConn();   
		    String sql = "update weibo set count='" + (weibo.getWeibos_().getCount()+1) + "' where idweibo='" + weibo.getWeibos_().getIdweibo() + "'";  
		    PreparedStatement pstmt;  
		    try {  
		        pstmt = (PreparedStatement) conn.prepareStatement(sql);  
		        pstmt.executeUpdate();  
		        pstmt.close();  
		        conn.close();  
		    } catch (SQLException e) {  
		        e.printStackTrace();  
		    }   
			break;
		default:
			System.out.println("Count-默认操作");
			break;
		}
		
	}


}
