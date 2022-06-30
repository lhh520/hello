package testproject;

import java.util.HashMap;
import java.util.Map;

public class Codec {
    // Encodes a URL to a shortened URL.
    Map<Integer,String>map=new HashMap<>();
    int id=0;
    public String encode(String longUrl) {
        id++;
        map.put(id,longUrl);
        return "http://tinyurl.com/"+id;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int p=shortUrl.lastIndexOf('/')+1;//获取key的值
        int key=Integer.parseInt(shortUrl.substring(p));
        return map.get(key);
    }
}
