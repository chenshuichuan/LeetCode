package download;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class ImageDownload {

    public static void main(String[] args)  {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path = "E:\\图片\\吉卜力\\";
        String url = "http://www.ghibli.jp/gallery/";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("虞美人盛开的山坡","kokurikozaka0");
        stringMap.put("千与千寻","chihiro0");
        stringMap.put("地海战记","ged0");
        stringMap.put("借东西的小人","karigurashi0");
        stringMap.put("悬崖上的金鱼姬","ponyo0");
        ImageDownload downloadJPL = new ImageDownload();
        for (String doc :
                stringMap.keySet()) {
            String temp = stringMap.get(doc);
            String storePath = path+doc+"/";
            for (int i = 1; i <= 50; i++) {
                StringBuilder builder = new StringBuilder(temp);
                if(i<10)builder.append("0");
                builder.append(i).append(".jpg");
                downloadJPL.download(storePath+builder.toString(),url+builder.toString());
            }
            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }


    }
    public void download(String urlString, String filename)  {
        try {
            URL url = new URL(urlString); // 构造URL
            URLConnection con = url.openConnection();  // 打开链接
            con.setConnectTimeout(5*1000);  //设置请求超时为5s
            InputStream is = con.getInputStream();  // 输入流
            byte[] bs = new byte[1024];  // 1K的数据缓冲
            int len;  // 读取到的数据长度
            int i = filename.length();
            for(i--;i>=0 && filename.charAt(i) != '\\' && filename.charAt(i) != '/';i--);
            String s_dir = filename.substring(0, i);
            File dir = new File(s_dir);  // 输出的文件流
            if(!dir.exists()){
                dir.mkdirs();
            }
            OutputStream os = new FileOutputStream(filename);
            // 开始读取
            while ((len = is.read(bs)) != -1) {
                os.write(bs, 0, len);
            }
            // 完毕，关闭所有链接
            os.close();
            is.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
