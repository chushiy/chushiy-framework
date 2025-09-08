// package com.chushiy.standard.ip;
//
// import lombok.extern.slf4j.Slf4j;
// import org.lionsoul.ip2region.xdb.Searcher;
//
// import java.io.File;
// import java.io.InputStream;
// import java.util.concurrent.TimeUnit;
//
// /**
//  * @Author 初时y
//  * @Email chushiy@qq.com
//  * @DateTime 2025/9/8 18:29
//  * @Description 离线IP地址定位库和IP定位数据
//  * @ProjectName chushiy-framework
//  * @PackageName com.chushiy.standard.ip
//  * @ClassName Ip2regionUtils.java
//  * @ProductName IntelliJ IDEA
//  * @Version 1.0.0
//  */
// @Slf4j
// public class Ip2regionUtils {
//
//     private static Searcher searcher;
//
//     private static String IP2REGION_DB_PATH;
//
//     static {
//         try {
//             getIp2regionDbPath();
//             init();
//         } catch (Exception e) {
//             throw new RuntimeException(e);
//         }
//     }
//
//     private static void getIp2regionDbPath() throws Exception {
//         // 获取当前项目所在的绝对路径
//         String proFilePath = System.getProperty("user.dir");
//
//         String ip2regionFilePath = "/ip2region";
//         String ip2regionDbFileName = "ip2region.xdb";
//
//         // 获取模板下的路径，然后存放在temp目录下　
//         String newFilePath = proFilePath + File.separator + "temp" + File.separator + ip2regionFilePath;
//         newFilePath = newFilePath.replace("/", File.separator);
//         // 检查项目运行时的src下的对应路径
//         File newFile = new File(newFilePath + ip2regionDbFileName);
//         if (newFile.isFile() && newFile.exists()) {
//             return;
//         }
//         // 当项目打成jar包会运行下面的代码，并且复制一份到src路径下
//         InputStream certStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(ip2regionFilePath + ip2regionDbFileName);
//         byte[] certData = org.apache.commons.io.IOUtils.toByteArray(certStream);
//         org.apache.commons.io.FileUtils.writeByteArrayToFile(newFile, certData);
//
//         IP2REGION_DB_PATH = newFile.getAbsolutePath();
//     }
//
//     private static void init() throws Exception {
//         // 从 dbPath 加载整个 xdb 到内存。
//         byte[] cBuff;
//         try {
//             cBuff = Searcher.loadContentFromFile(Ip2regionUtils.class.getResource(IP2REGION_DB_PATH).getPath());
//         } catch (Exception e) {
//             log.error("failed to load content from {}", Ip2regionUtils.class.getResource(IP2REGION_DB_PATH).getPath(), e);
//             return;
//         }
//
//         // 使用上述的 cBuff 创建一个完全基于内存的查询对象。
//         try {
//             searcher = Searcher.newWithBuffer(cBuff);
//         } catch (Exception e) {
//             log.error("failed to create content cached searcher: ", e);
//             throw e;
//         }
//     }
//
//     public static String getIp2Region(String ip) {
//         try {
//             long sTime = System.nanoTime();
//             String region = searcher.search(ip);
//             long cost = TimeUnit.NANOSECONDS.toMicros((long) (System.nanoTime() - sTime));
//             log.info("{region: {}, ioCount: {}, took: {} μs}\n", region, searcher.getIOCount(), cost);
//             return region;
//         } catch (Exception e) {
//             return null;
//         }
//     }
//
//     public static void main(String[] args) {
//         System.out.println(getIp2Region("219.136.76.91"));
//     }
// }
