package com.example.qitest;


import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.awt.*;

@RestController("/collage")
public class Request {

    @GetMapping("user={user}&size={size}&type={type}")
    public ResponseEntity<byte[]> collage(@PathVariable String user, String size, String type){
        String url = "https://www.tapmusic.net/collage.php?user="+user+"-&type="+type+"&size="+size+"&caption=true";
        RestTemplate restTemplate = new RestTemplate();
        byte[] imgchart = restTemplate.getForObject(url, byte[].class);


        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imgchart);
    }

}
