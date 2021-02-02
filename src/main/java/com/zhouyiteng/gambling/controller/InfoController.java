package com.zhouyiteng.gambling.controller;

import com.zhouyiteng.gambling.service.InfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 账户相关操作的控制器
 *
 * @author bake@eastmoney.com
 *
 * Created by liubake on 2020/11/20.
 */
@Slf4j
@RestController
@RequestMapping("/system/info")
public class InfoController extends BaseController {

    @Autowired
    private InfoService infoService;

    @GetMapping("environment")
    public String environment(){
        return infoService.getEnvironment();
    }

    /**
     * 获取图片验证码
     * @param ticket
     * @param response
     * @throws IOException
     */
    @GetMapping("image-code")
    public void imageCode(@RequestParam String ticket,
                          HttpServletResponse response) throws IOException {
        try(ServletOutputStream responseOutputStream = response.getOutputStream()){
            response.setContentType("image/jpeg");
            response.setDateHeader("Expires", 0);
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-cache");
            ImageIO.write(infoService.getImageCode(ticket, 4), "JPEG", responseOutputStream);
            responseOutputStream.flush();
        }
    }

}
