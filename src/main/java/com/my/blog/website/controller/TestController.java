package com.my.blog.website.controller;


import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.my.blog.website.modal.Movie;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;


/**
 * @auther shijx
 * @description 类描述
 * @date 2019/5/27
 */
@Controller
@RequestMapping("/Test")
public class TestController extends BaseController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    /**
     *今日榜单
     * @author shijx
     * @date 2019/5/28
     * , produces = "application/json;charset=utf-8"
     */
    @RequestMapping(value = "/getMovieTopTenB")
    public String getTopTen(HttpServletRequest request) {
        try {
            String s = HttpUtil.get("http://www.cbooo.cn//Home//GetScreenData");
            JSONObject jsonObject = JSON.parseObject(s);
            JSONArray data1 = jsonObject.getJSONArray("data1");
            ArrayList<Movie> movies = new ArrayList<>();
            for (Object o : data1) {
                Movie movie = JSON.toJavaObject(((JSONObject) o), Movie.class);
                movies.add(movie);
            }
            request.setAttribute("movie", movies);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.render("dd");
    }
}
