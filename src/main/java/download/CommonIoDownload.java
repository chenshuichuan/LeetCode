package download;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CommonIoDownload {
    public static void main(String[] args)  {
        long startTime=System.currentTimeMillis();   //获取开始时间
        String path = "E:\\图片\\收藏\\";
        String url = "http://www.ghibli.jp/gallery/";
        Map<String,String> stringMap = new HashMap<>();
        stringMap.put("哈尔的移动城堡","howl0");
        stringMap.put("猫的报恩","baron0");
        stringMap.put("吉维里的","ghiblies0");
        stringMap.put("山田保和京旁边","yamada0");
        stringMap.put("幽灵公主","mononoke0");
        stringMap.put("侧耳倾听","mimi0");
        stringMap.put("百变狸猫","tanuki0");
        stringMap.put("龙猫","totoro0");
        stringMap.put("魔女宅急便","majo0");
        stringMap.put("红猪侠","porco0");
        stringMap.put("听见涛声","umi0");
        stringMap.put("天空之城","laputa0");
        stringMap.put("风之谷","nausicaa0");
        stringMap.put("岁月童话","omoide0");
        stringMap.put("On Your Mark","onyourmark0");
        stringMap.put("红鬼龟物语","redturtle0");
        for (String doc :
                stringMap.keySet()) {
            String storePath = path+doc+"/";
            //System.out.print("\""+doc+"\": \""+stringMap.get(doc)+"\",");
            System.out.print("\""+stringMap.get(doc)+"\",");
            File file=new File(storePath);
            if(!file.exists()){//如果文件夹不存在
                file.mkdir();//创建文件夹
            }
        }
//        for (String doc :
//                stringMap.keySet()) {
//            String temp = stringMap.get(doc);
//            String storePath = path+doc+"/";
//            for (int i = 1; i <= 50; i++) {
//                StringBuilder builder = new StringBuilder(temp);
//                if(i<10)builder.append("0");
//                builder.append(i).append(".jpg");
//                download(storePath+builder.toString(),url+builder.toString());
//
//            }
//            long endTime=System.currentTimeMillis(); //获取结束时间
//            System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
//        }


    }

    private static void download(String storePath, String url){

        try {
            URL urls = new URL(url);
            File temp = new File(storePath);
            FileUtils.copyURLToFile(urls, temp);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
