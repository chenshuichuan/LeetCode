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
        String path = "E:/DBChain/";
        String url = "http://www.ghibli.jp/gallery/";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("karigurashi","howl0");
//        stringMap.put("猫的报恩","baron0");
//        stringMap.put("吉维里的","ghiblies0");
//        stringMap.put("山田保和京旁边","yamada0");
//        stringMap.put("幽灵公主","mononoke0");
//        stringMap.put("侧耳倾听","mimi0");
//        stringMap.put("百变狸猫","tanuki0");
//        stringMap.put("龙猫","totoro0");
//        stringMap.put("魔女宅急便","majo0");
//        stringMap.put("红猪侠","porco0");
//        stringMap.put("听见涛声","umi0");
//        stringMap.put("天空之城","laputa0");
//        stringMap.put("风之谷","nausicaa0");
//        stringMap.put("岁月童话","omoide0");
//        stringMap.put("On Your Mark","onyourmark0");
//        stringMap.put("红鬼龟物语","redturtle0");
        ImageDownload downloadJPL = new ImageDownload();
//        for (String doc :
//                stringMap.keySet()) {
//            String temp = stringMap.get(doc);
//            String storePath = path+doc+"/";
//            File file=new File(storePath);
//            if(!file.exists()){//如果文件夹不存在
//                file.mkdir();//创建文件夹
//            }
//        }
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
