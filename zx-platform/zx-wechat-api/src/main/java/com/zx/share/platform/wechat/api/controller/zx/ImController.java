package com.zx.share.platform.wechat.api.controller.zx;

import com.zx.share.platform.common.service.MemcachedService;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import com.zx.share.platform.vo.user.ImRequestBean;
import com.zx.share.platform.vo.user.ImResponseBean;
import com.zx.share.platform.wechat.api.controller.BaseController;
import com.zx.share.platform.wechat.service.ImService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenggang on 18/5/7.
 *
 * @author fenggang
 * @date 18/5/7
 */
@Api(value = "/im", produces = "application/json", description = "对话列表接口")
@Controller
@RequestMapping("/im")
public class ImController extends BaseController {

    @Autowired
    private ImService imService;
    @Autowired
    private MemcachedService memcachedService;

    @ApiOperation(value = "对话列表", notes = "对话列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<PageResponseBean<ImResponseBean>> list(
            @ApiParam(value = "用户类型") @RequestParam(name = "userType", required = false) Integer userType,
            @ApiParam(value = "用户Code") @RequestParam(name = "userCode", required = false) String userCode,
            @ApiParam(value = "page") @RequestParam(name = "page", required = false) Integer page,
            @ApiParam(value = "pageSize") @RequestParam(name = "pageSize", required = false) Integer pageSize,
            HttpServletRequest request) throws Exception {
        servletPath = request.getServletPath();
        ImRequestBean bean = new ImRequestBean();
        bean.setUserCode(userCode);
        bean.setUserType(userType);
        bean.setPage(page);
        bean.setPageSize(pageSize);
        DefaultResopnseBean<PageResponseBean<ImResponseBean>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(imService.page(bean));
        return resopnseBean;
    }

    @ApiOperation(value = "添加对话信息", notes = "添加对话信息")
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<Boolean> list(
            @ApiParam(value = "1-客户，2-律师") @RequestParam(name = "type", required = false) String type,
            @ApiParam(value = "对话内容") @RequestParam(name = "msg", required = false) String msg,
            @ApiParam(value = "用户Code") @RequestParam(name = "userCode", required = false) String userCode,
            @ApiParam(value = "律师Code") @RequestParam(name = "code", required = false) String code,
            HttpServletRequest request) throws Exception {
        servletPath = request.getServletPath();
        this._list(type,msg,userCode,code);
        return new DefaultResopnseBean<>();
    }

    private synchronized void _list(String type,String msg,String userCode,String code){
        String text = memcachedService.get(userCode+"-"+code+"-"+type)+"";
        memcachedService.set(userCode+"-"+code+"-"+type,60*60,text+"____"+msg);
        imService.add(code,userCode,msg);
    }

    @ApiOperation(value = "查询对话", notes = "查询对话")
    @RequestMapping(value = "/select", method = RequestMethod.GET)
    @ResponseBody
    public DefaultResopnseBean<List<String>> msg(
            @ApiParam(value = "1-客户，2-律师") @RequestParam(name = "type", required = false) String type,
            @ApiParam(value = "用户Code") @RequestParam(name = "userCode", required = false) String userCode,
            @ApiParam(value = "律师Code") @RequestParam(name = "code", required = false) String code,
            HttpServletRequest request) throws Exception {
        servletPath = request.getServletPath();

        DefaultResopnseBean<List<String>> resopnseBean = new DefaultResopnseBean<>();
        resopnseBean.setData(this._msg(type,userCode,code));
        return resopnseBean;
    }

    private synchronized List<String> _msg(String type,String userCode,String code){
        List<String> list = new ArrayList<>();
        String text = memcachedService.get(userCode+"-"+code+"-"+type)+"";
        if(StringUtil.isNotBlank(text)){
            String txt[] = text.split("____");
            for (String str:txt) {
                if(StringUtil.isNotBlank(txt)){
                    list.add(str);
                }
            }
        }
        memcachedService.delete(userCode+"-"+code+"-"+type);
        return list;
    }

}
