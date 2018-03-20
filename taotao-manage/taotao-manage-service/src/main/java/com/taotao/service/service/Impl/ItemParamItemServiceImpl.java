package com.taotao.service.service.Impl;

import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @auther Mxy on 2018/2/1.
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

    @Override
    public String getItemParamById(Long itemId) {
        //根据商品ID查询规格参数
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);

        List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
        if (list == null && list.size() == 0) {
            return "";
        } else {
            //取规格参数信息
            TbItemParamItem itemParamItem = list.get(0);
            String paramData = itemParamItem.getParamData();
            //生成html

        }
        return null;
    }
}
