package cn.hit.sa.weibo;

public class WeiboChangeEvent {
	/*
	 * 不同改变类型的常量
	 */
	public static final int ADD = 0;
	public static final int READ = 1;
	public static final int UPDATE = 2;
	public static final int DELETE = 3;
	
	private int type_;
	private String arg_;
	
	public WeiboChangeEvent(int type){
		type_ = type;
	}
	
	public WeiboChangeEvent(int type, String arg){
		arg_ = arg;
	}
	
	public void setType(int type){
		type_ = type;
	}
	
	public int getType(){
		return type_;
	}
	
	public void setArg(String arg){
		arg_ = arg;
	}
	
	public String getArg(){
		return arg_;
	}

}
