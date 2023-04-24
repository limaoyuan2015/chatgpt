package com.szmengran.chatgpt.domain.utils;

import lombok.SneakyThrows;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author MaoYuan.Li
 * @Date 2023/3/24 12:06
 * @Version 1.0
 */
public class FileTransferUtils {

    @SneakyThrows
    public static MultipartFile transferToMultipartFile(String urlStr) {
        //把地址转换成URL对象
        URL url = new URL(urlStr);
        //创建http链接
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();
        //设置超时间为3秒
        conn.setConnectTimeout(3*1000);
        //防止屏蔽程序抓取而返回403错误
        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/61.0.3163.100 Safari/537.36)");
        //得到输入流
        InputStream inputStream = conn.getInputStream();
        //截取链接中的文件名
        String fileName= urlStr.substring(urlStr.lastIndexOf("/")+1);
        MultipartFile multipartFile = new MockMultipartFile(fileName,fileName, ContentType.APPLICATION_OCTET_STREAM.toString(), inputStream);
    
        return multipartFile;
    }
}
