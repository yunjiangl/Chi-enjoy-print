package com.zx.share.platform.wechat.api.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.util.calendar.BaseCalendar;

/**
 * Created by fenggang on 18/3/5.
 *
 * @author fenggang
 * @date 18/3/5
 */
@Api(value = "/dictionary", produces = "application/json", description = "用户接口")
@Controller
@RequestMapping("/dictionary")
public class DictionaryController extends BaseController {
}
