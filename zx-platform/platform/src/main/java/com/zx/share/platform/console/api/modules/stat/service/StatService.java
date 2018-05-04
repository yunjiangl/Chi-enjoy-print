package com.zx.share.platform.console.api.modules.stat.service;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/5/3.
 *
 * @author fenggang
 * @date 18/5/3
 */
public interface StatService {

    List<Map<String,Object>> account(Map<String,Object> query);

    List<Map<String,Object>> typeGroup(Map<String, Object> query);

    List<Map<String,Object>> earnings(Map<String, Object> query);
}
