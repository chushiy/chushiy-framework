package com.chushiy.standard.ip;

import lombok.extern.slf4j.Slf4j;
import org.lionsoul.ip2region.xdb.Searcher;

import java.util.concurrent.TimeUnit;

/**
 * @Author 初时y
 * @Email chushiy@qq.com
 * @DateTime 2025/9/8 18:29
 * @Description 离线IP地址定位库和IP定位数据
 * @ProjectName chushiy-framework
 * @PackageName com.chushiy.standard.ip
 * @ClassName Ip2regionUtils.java
 * @ProductName IntelliJ IDEA
 * @Version 1.0.0
 */
@Slf4j
public class Ip2regionUtils {

   private static Searcher searcher;

   static {
       try {
           init();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }
   }

   private static void init() throws Exception {
       // 从 dbPath 加载整个 xdb 到内存。
       byte[] cBuff;
       try {
           cBuff = Searcher.loadContentFromFile(Ip2regionUtils.class.getResource("/ip2region/ip2region.xdb").getPath());
       } catch (Exception e) {
           log.error("failed to load content from {}", Ip2regionUtils.class.getResource("/ip2region/ip2region.xdb").getPath(), e);
           return;
       }

       // 使用上述的 cBuff 创建一个完全基于内存的查询对象。
       try {
           searcher = Searcher.newWithBuffer(cBuff);
       } catch (Exception e) {
           log.error("failed to create content cached searcher: ", e);
           throw e;
       }
   }

   public static String getIp2Region(String ip) {
       try {
           long sTime = System.nanoTime();
           String region = searcher.search(ip);
           long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
           log.info("{region: {}, ioCount: {}, took: {} μs}\n", region, searcher.getIOCount(), cost);
           return region;
       } catch (Exception e) {
           return null;
       }
   }

    public static void main(String[] args) {
        System.out.println(getIp2Region("219.136.76.91"));
    }
}
