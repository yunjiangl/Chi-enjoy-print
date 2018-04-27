package com.zx.share.platform.wechat.service.impl;

import com.zx.share.platform.bean.sys.SysDictionary;
import com.zx.share.platform.constants.DictionaryTypeEnum;
import com.zx.share.platform.util.StringUtil;
import com.zx.share.platform.vo.wechat.response.DictionaryResultBean;
import com.zx.share.platform.wechat.mapper.DictionaryMapper;
import com.zx.share.platform.wechat.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fenggang on 18/3/9.
 *
 * @author fenggang
 * @date 18/3/9
 */
@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryMapper dictionaryMapper;

    @Override
    public List<DictionaryResultBean> findType(String type, Long parentId) {
        return dictionaryMapper.findTypePIdList(type,parentId);
    }

    @Override
    public List<DictionaryResultBean> lista() {
        List<DictionaryResultBean> list = dictionaryMapper.findTypeList(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_A.code);

        return this.getDictionaryResultBean(list,0l);
    }

    @Override
    public List<DictionaryResultBean> listb() {
        List<DictionaryResultBean> list = dictionaryMapper.findTypeList(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_FILE_B.code);
        return this.getDictionaryResultBean(list,0l);
    }

    @Override
    public List<DictionaryResultBean> domain() {
        return dictionaryMapper.findTypeList(DictionaryTypeEnum.ZX_DICTIONARY_TYPE_ATTORNEY_DOMAIN.code);
    }

    private List<DictionaryResultBean> getDictionaryResultBean(List<DictionaryResultBean> list,Long pId){
        List<DictionaryResultBean> result = new ArrayList<>();
        if(list!=null && !list.isEmpty()){
            for (DictionaryResultBean bean : list) {
                if(StringUtil.isBlank(bean.getpId())){continue;}
                if(bean.getpId().equals(pId) || pId.equals(bean.getpId())){
                    bean.setList(getDictionaryResultBean(list, bean.getId()));
                    result.add(bean);
                }
            }
        }
        return result;
    }

	@Override
	public DictionaryResultBean get(String code) {
		// TODO Auto-generated method stub
		return dictionaryMapper.get(code);
	}
}
