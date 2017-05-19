package cn.hit.sa.weibo;

public class WeiboController {
	
	public void execute()
	{
		WeiboWrapper wsw = new WeiboWrapper();
		
		Count counter = new Count();
		Logger logger  = new Logger();
		
		wsw.addObserver(logger);
		wsw.addObserver(counter);
		
		//添加微博
		Weibo nweibo = new Weibo();
		nweibo.setContent("Content");
		nweibo.setPubtime(System.currentTimeMillis());
		nweibo.setAuthor(1);
		
		wsw.addWeibo(nweibo);
		
		//查看微博(记数构件)
		Weibo weibo = wsw.readWeibo("1");
		System.out.println(weibo.getCount());
		
		//修改微博(日志构件)
		weibo.setContent("new Content");
		wsw.updateWeibo(weibo);
		
		//刪除微博
		wsw.deleteWeibo("7");
	}
	
	public static void main(String[] args){
		WeiboController wc = new WeiboController();
		wc.execute();
	}

}
