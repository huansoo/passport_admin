package com.wugu.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

public class MemCached {
	protected static final MemCachedClient mcc = new MemCachedClient();
	
	static {
	    Prop prop = null;
        try {
            prop = PropKit.use("cache.properties");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
	    //获取缓存服务器列表
		String serversV = prop.get("MEMCACHE_SERVERS");
		//获取缓存服务器权重
		String weightsV = prop.get("MEMCACHE_WEIGHTS");

		String[] servers = serversV.split(",");

		String[] weightsi = weightsV.split(",");
		Integer[] weights = new Integer[weightsi.length];

		for (int i = 0; i < weightsi.length; i++) {
			weights[i] = Integer.parseInt(weightsi[i]);
		}

		// 创建一个实例对象SockIOPool
		/*
		 * 获得连接池的单态方法。这个方法有一个重载方法getInstance( String poolName )，每个poolName只构造一个SockIOPool实例。
		 * 缺省构造的poolName是default。如果在客户端配置多个memcached服务，一定要显式声明poolName。
		 */
		SockIOPool pool = SockIOPool.getInstance();
		// 设置Memcached Server
		pool.setServers(servers);
		pool.setWeights(weights);
		// 连接池设置
		// 5 初始化连接, 5 最小连接数, 250 最大连接数
		// 一个连接最大的持有时间
		pool.setInitConn(5);
		pool.setMinConn(5);
		pool.setMaxConn(250);
		//设置可用连接池的最长等待时间
		pool.setMaxIdle(1000 * 3);
		// 设置主线程睡眠时间.维护线程主要通过log输出socket的运行状况，监测连接数目及空闲等待时间等参数以控制连接创建和关闭。
		pool.setMaintSleep(2000);
		
		// Tcp的规则就是在发送一个包之前，本地机器会等待远程主机
		// 对上一次发送的包的确认信息到来；这个方法就可以关闭套接字的缓存
		// 以至这个包准备好了就发.设置是否使用Nagle算法，因为我们的通讯数据量通常都比较大（相对TCP控制数据）而且要求响应及时，
		// 因此该值需要设置为false（默认是true）
		pool.setNagle(false);
		// 连接建立后对超时的控制
		pool.setSocketTO(3000);
		// 连接建立时对超时的控制
		pool.setSocketConnectTO(0);
		// 初始化一些值并与MemcachedServer段建立连接
		pool.initialize();
		// 为客户端设置压缩选项
		// 超过64k的数据进行压缩
		mcc.setCompressEnable(true);
		mcc.setCompressThreshold(64 * 1024);
	}

	public static MemCachedClient getmcc() {
		return mcc;
	}

	public static void main(String arvg[]) {
	    MemCachedClient client = MemCached.getmcc();
//		for(int  i=0;i<50;i++){
//			MemCachedClient sm = MemCached.getmcc();
//			System.out.println("n="+i+sm.getCounter("lijun"));
//		}
//	    MemCached.getmcc().flushAll();
//		System.out.println(MemCached.getmcc().add("test3", "lijun"));
//		System.out.println(MemCached.getmcc().get("tk_areaweight_isupdate"));
//	    client.delete("yangch");
//	    boolean flag1 = client.add("yangch", "lanyangyang310", new Date(1000));
//	    boolean flag1 = client.add("yangch", "lanyangyang310");
//	    client.add("xuexue1", "45555");
//	    client.set("yangch", 2323);
//	    System.out.println("添加到缓存是否成功"+flag1);
//		System.out.println(client.get("yangch"));
//		List<String> list = getAllKeys();
//		System.out.println(client.get("age"));
	    client.delete("lijun");
		System.out.println(client.getCounter("xuexue"));
		System.out.println(client.getCounter("yangch"));
//		System.out.println(list.toString());
	}
	
	/**

     * 获取某台memcached的所有key
     * @param memcachedNo
     * @return
     */
	public static List<String> getAllKeys() {
        List<String> list = new ArrayList<String>();
        @SuppressWarnings("unchecked")
        Map<String, Map<String, String>> items = mcc.statsItems();
        for (Iterator<String> itemIt = items.keySet().iterator(); itemIt.hasNext();) {
            String itemKey = itemIt.next();
            Map<String, String> maps = items.get(itemKey);
            for (Iterator<String> mapsIt = maps.keySet().iterator(); mapsIt.hasNext();) {
                String mapsKey = mapsIt.next();
                String mapsValue = maps.get(mapsKey);
                if (mapsKey.endsWith("number")) {//memcached key 类型  item_str:integer:number_str
                    String[] arr = mapsKey.split(":");
                    int slabNumber = Integer.valueOf(arr[1].trim());
                    int limit = Integer.valueOf(mapsValue.trim());
                    @SuppressWarnings("unchecked")
                    Map<String, Map<String, String>> dumpMaps = mcc.statsCacheDump(slabNumber, limit);
                    for (Iterator<String> dumpIt = dumpMaps.keySet().iterator(); dumpIt.hasNext();) {
                        String dumpKey = dumpIt.next();
                        Map<String, String> allMap = dumpMaps.get(dumpKey);
                        for (Iterator<String> allIt = allMap.keySet().iterator(); allIt.hasNext();) {
                            String allKey = allIt.next();
                            list.add(allKey.trim());
                        }
                    }
                }
            }
        }
        return list;
    }
}
