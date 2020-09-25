package download;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.HashMap;
import java.util.Map;

public class RBCtry {

    public static void main(String[] args)  {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path = "E:/jipuli/";
        String url = "http://www.ghibli.jp/gallery/";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("kokurikozaka","kokurikozaka0");
        stringMap.put("chihiro","chihiro0");
        stringMap.put("ged","ged0");
        stringMap.put("karigurashi","karigurashi0");
        stringMap.put("ponyo","ponyo0");
        RBCtry downloadJPL = new RBCtry();
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
    public void download( String filename,String urlString)  {
        File file = new File(filename);
        if(file.exists())return;
        try {
            System.out.println("begin:"+filename);
            System.out.println("from:"+urlString);
            URL website = new URL(urlString);
            ReadableByteChannel rbc = Channels.newChannel(website.openStream());
            FileOutputStream fos = new FileOutputStream(filename);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            System.out.println("finish:"+filename);
            fos.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
