package com.app.client_app.controller;

import com.framework.web.ResponseBodyMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by @panyao on 2017/8/31.
 *
 * 没有额外限制
 */
@Controller
@RequestMapping("/api/client/app")
public class Resource {

    @RequestMapping("/resource")
    @ResponseBody
    public ResponseBodyMessage<String> list(@RequestHeader("cli-version") String version) {
        // 根据版本， 找到对应版本应该更新的资源列表

        return null;
    }

}
