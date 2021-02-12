package download;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class DownloadJPL {
    public static void main(String[] args)  {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path = "E:\\图片\\收藏\\";
        String url = "http://www.ghibli.jp/gallery/";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("虞美人盛开的山坡","kokurikozaka0");
        stringMap.put("千与千寻","chihiro0");
        stringMap.put("地海战记","ged0");
        stringMap.put("借东西的小人","karigurashi0");
        stringMap.put("悬崖上的金鱼姬","ponyo0");
        DownloadJPL downloadJPL = new DownloadJPL();
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
    public void download(String storePath,String url){
        System.out.println("begin:"+storePath);
        System.out.println("from:"+url);
        try {
            URL url1 = new URL(url);
            URLConnection uc = url1.openConnection();
            InputStream inputStream = uc.getInputStream();

            FileOutputStream out = new FileOutputStream(storePath);
            int j = 0;
            while ((j = inputStream.read()) != -1) {
                out.write(j);
            }
            inputStream.close();
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
