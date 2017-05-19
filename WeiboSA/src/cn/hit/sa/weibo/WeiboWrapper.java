package cn.hit.sa.weibo;

import java.util.Observable;
/**
 * 实现微博对象用于存储并操作微博内容
 * 包括查看、修改、增加、删除等功能，
 * 1. 微博内容一旦改变，会通知“日志构件”记录操作日志。
 * 2. 微博被阅读一次，通知“记数构件”记录阅读次数。
 * 
 * @author Mandy
 * @version 0.0.1
 *
 */
public class WeiboWrapper extends Observable{
	
	private Weibo weibos_ = new Weibo();
	
	public void addWeibo(Weibo weibo){
		//添加微博
		weibos_.addWeibo(weibo);
		eventExcute(WeiboChangeEvent.ADD);
	}
	
	public Weibo readWeibo(String weiboID){
		//查看微博
		weibos_ = weibos_.readWeibo(weiboID);
		eventExcute(WeiboChangeEvent.READ);
		return weibos_;
	}
		
	public void deleteWeibo(String weiboID){
		//删除微博
		weibos_.deleteWeibo(weiboID);
		eventExcute(WeiboChangeEvent.DELETE);
	}
	
	public void updateWeibo(Weibo newWeibo){
		//修改微博
		weibos_ = newWeibo;
		weibos_.updateWeibo(newWeibo);
		eventExcute(WeiboChangeEvent.UPDATE);
	}
	
	public Weibo getWeibos_() {
		return weibos_;
	}
	
	public void setWeibos_(Weibo weibos_) {
		this.weibos_ = weibos_;
	}

	private void eventExcute(int type){
		//创建一个新的改变事件
		WeiboChangeEvent event = new WeiboChangeEvent(type);
		//设置此WeiboStorageWrapper的change flag
		setChanged();
		//发送事件
		notifyObservers(event);
	}
}
