package cn.hit.sa.weibo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

import cn.hit.sa.util.DBUtil;

public class Weibo {
	private int idweibo;
	private String content;
	private long pubtime;
	private int author;
	private int count;
	
	public void addWeibo(Weibo weibo){
		//加入数据库
		System.out.println("-**-添加微博-**-");
    	Connection conn = DBUtil.getConn();
    	int i = 0;  
        String sql = "insert into weibo(content,pubtime,author) values(?,?,?)";  
        PreparedStatement pstmt;  
        try {  
            pstmt = (PreparedStatement) conn.prepareStatement(sql);  
            pstmt.setString(1, weibo.getContent());  
            pstmt.setString(2, weibo.getPubtime()+"");  
            pstmt.setString(3, weibo.getAuthor()+"");  
            i = pstmt.executeUpdate();  
            System.out.println(i);
            pstmt.close();  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        } 
	}
	
	public Weibo readWeibo(String weiboID){
		//查询指定ID的微博
		System.out.println("-**-查看微博-**-");
		Connection conn = DBUtil.getConn();  
        String sql = "select * from weibo where idweibo = '"+weiboID+"'";  
        PreparedStatement pstmt;  
        try {  
            pstmt = (PreparedStatement)conn.prepareStatement(sql);  
            ResultSet rs = pstmt.executeQuery(); 
            while(rs.next()){
                Weibo wb = new Weibo();
                wb.setIdweibo(rs.getInt(1));
                wb.setContent(rs.getString(2));
                wb.setPubtime(rs.getLong(3));
                wb.setAuthor(rs.getInt(4));
                wb.setCount(rs.getInt(5));
                return wb;	
            }
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
        return null;  
	}
	
	public void deleteWeibo(String weiboID){
		//删除指定ID的微博
		System.out.println("-**-删除微博-**-");
		Connection conn = DBUtil.getConn();  
        String sql = "delete from weibo where idweibo='" + weiboID + "'";  
        PreparedStatement pstmt;  
        try {  
            pstmt = (PreparedStatement) conn.prepareStatement(sql);  
            pstmt.executeUpdate();  
            pstmt.close();  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
	}
	
	public void updateWeibo(Weibo newWeibo){
		//更新微博
		System.out.println("-**-更新微博-**-");
		Connection conn = (Connection)DBUtil.getConn();   
	    String sql = "update weibo set content='" + newWeibo.getContent() + "' where idweibo='" + newWeibo.getIdweibo() + "'";  
	    PreparedStatement pstmt;  
	    try {  
	        pstmt = (PreparedStatement) conn.prepareStatement(sql);  
	        pstmt.executeUpdate();  
	        pstmt.close();  
	        conn.close();  
	    } catch (SQLException e) {  
	        e.printStackTrace();  
	    }   
	}
	
	public int getIdweibo() {
		return idweibo;
	}

	public void setIdweibo(int idweibo) {
		this.idweibo = idweibo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getPubtime() {
		return pubtime;
	}

	public void setPubtime(long pubtime) {
		this.pubtime = pubtime;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
}
