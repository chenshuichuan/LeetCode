package download;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
                downloadJPL.saveUrl(storePath+builder.toString(),url+builder.toString());
            }
            long endTime=System.currentTimeMillis(); //获取结束时间
            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
        }


    }
    public void download2(String urlString, String filename)  {
         File file = new File(filename);
        if(file.exists())return;
        try {
            URL website = new URL(urlString);
            InputStream in = website.openStream();
            //Files.copy(in, StandardCopyOption.REPLACE_EXISTING);
            FileOutputStream fout = new FileOutputStream(file);
            //Files.copy(in,file);

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void saveUrl(final String filename, final String urlString) {
        try {
            File file = new File(filename);
            if(file.exists())return;
            BufferedInputStream in = null;
            FileOutputStream fout = null;
            System.out.println("begin:"+filename);
            System.out.println("from:"+urlString);
            try {
                in = new BufferedInputStream(new URL(urlString).openStream());
                fout = new FileOutputStream(filename);

                final byte data[] = new byte[1024];
                int count;
                while ((count = in.read(data, 0, 1024)) != -1) {
                    fout.write(data, 0, count);
                }
            } finally {
                if (in != null) {
                    in.close();
                }
                if (fout != null) {
                    fout.close();
                }
            }
            System.out.println("finish:"+filename);
        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }
}
