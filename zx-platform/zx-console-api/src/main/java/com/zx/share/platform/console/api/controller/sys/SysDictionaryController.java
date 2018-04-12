package com.zx.share.platform.console.api.controller.sys;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.bean.sys.SysUser;
import com.zx.share.platform.console.service.sys.SysDictionaryService;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.util.annotation.ACSPermissions;
import com.zx.share.platform.util.response.DefaultResopnseBean;
import com.zx.share.platform.util.response.PageResponseBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fenggang on 18/4/4.
 *
 * @author fenggang
 * @date 18/4/4
 */
@RestController
@Api("字典操作类")
public class SysDictionaryController {

    @Autowired
    private SysDictionaryService sysDictionaryService;

    @RequestMapping(value = "/sys/dictionary/selectPage", method = RequestMethod.GET)
    @ApiOperation(value = "字典分页", notes = "字典分页")
    public DefaultResopnseBean<PageResponseBean<SysDictionary>> selectPage(
            @ApiParam("字典类型") @RequestParam(name = "type", required = false) String type,
            @ApiParam("字典父级") @RequestParam(name = "parentId", required = false) Long parentId,
            @ApiParam("查询内容") @RequestParam(name = "query", required = false) String query,
            @ApiParam("第几页") @RequestParam(name = "page", required = false) Integer page,
            @ApiParam("每页多少条") @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        DefaultResopnseBean<PageResponseBean<SysDictionary>> pageResponse = new DefaultResopnseBean<>();
        pageResponse.setData(sysDictionaryService.selecPage(type,parentId,query,page,pageSize));
        return pageResponse;
    }

    @RequestMapping(value = "/sys/dictionary/selectAll", method = RequestMethod.GET)
    @ApiOperation(value = "字典list", notes = "字典list")
    public DefaultResopnseBean<List<SysDictionary>> selectAll(
            @ApiParam("字典类型") @RequestParam(name = "type", required = false) String type,
            @ApiParam("字典父级") @RequestParam(name = "parentId", required = false) Long parentId,
            @ApiParam("查询内容") @RequestParam(name = "query", required = false) String query) {
        DefaultResopnseBean<List<SysDictionary>> pageResponse = new DefaultResopnseBean<>();
        pageResponse.setData(sysDictionaryService.selectParamAll(type,parentId,query));
        return pageResponse;
    }

    @RequestMapping(value = "/sys/dictionary/selectGet", method = RequestMethod.GET)
    @ApiOperation(value = "字典get", notes = "字典get")
    public DefaultResopnseBean<SysDictionary> selectGet(
            @ApiParam("id") @RequestParam(name = "id", required = false) Long id) {
        DefaultResopnseBean<SysDictionary> pageResponse = new DefaultResopnseBean<>();
        pageResponse.setData(sysDictionaryService.findId(id));
        return pageResponse;
    }

    @RequestMapping(value = "/sys/dictionary/save", method = RequestMethod.POST)
    @ApiOperation(value = "字典save", notes = "字典save")
    public DefaultResopnseBean<Integer> save(
            @ApiParam("字典类型") @RequestParam(name = "type", required = false) String type,
            @ApiParam("字典父级") @RequestParam(name = "parentId", required = false) Long parentId,
            @ApiParam("字典父级") @RequestParam(name = "pIds", required = false) String pIds,
            @ApiParam("名称") @RequestParam(name = "name", required = false) String name,
            @ApiParam("等级") @RequestParam(name = "value", required = false) String value,
            @ApiParam("id") @RequestParam(name = "id", required = false) Long id) {
        DefaultResopnseBean<Integer> pageResponse = new DefaultResopnseBean<>();
        SysDictionary sysDictionary = new SysDictionary();
        sysDictionary.setId(id);
        sysDictionary.setCreateTime(new Date());
        sysDictionary.setType(type);
        sysDictionary.setValue(value);
        sysDictionary.setName(name);

        if(StringUtil.isNotBlank(pIds)){
            String[] pId = pIds.split(",");
            if(pId.length>0){
                parentId = Long.valueOf(pId[pId.length-2]);
            }
        }
        sysDictionary.setParentId(parentId);

        pageResponse.setData(sysDictionaryService.save(sysDictionary));
        return pageResponse;
    }
}
