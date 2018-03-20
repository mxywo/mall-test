package com.taotao.service.service.Impl;

import com.taotao.mapper.TbItemParamItemMapper;
import com.taotao.pojo.TbItemParamItem;
import com.taotao.pojo.TbItemParamItemExample;
import com.taotao.service.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import java.util.List;
=======
import utils.JsonUtils;

import java.util.List;
import java.util.Map;
>>>>>>> 6ecebbde8b13b2622d127af4b088ea1f059d3297

/**
 * Created by @auther Mxy on 2018/2/1.
 */
@Service
public class ItemParamItemServiceImpl implements ItemParamItemService {
    @SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired
    private TbItemParamItemMapper tbItemParamItemMapper;

<<<<<<< HEAD
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
=======

    @Override
    public String geParamItemByItemId(long itemId) {
        TbItemParamItemExample example = new TbItemParamItemExample();
        TbItemParamItemExample.Criteria criteria = example.createCriteria();
        criteria.andItemIdEqualTo(itemId);
        List<TbItemParamItem> list = tbItemParamItemMapper.selectByExampleWithBLOBs(example);
        if (null == list || list.isEmpty()) {
            return "";
        }
        //取出参数信息
        TbItemParamItem itemParamItem = list.get(0);
        String paramData = itemParamItem.getParamData();
        //把json数据转换成java对象
        List<Map> paramList = JsonUtils.jsonToList(paramData, Map.class);
        //将参数信息转换成html
        StringBuffer sb = new StringBuffer();
        //sb.append("<div>");
        sb.append("<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" border=\"1\" class=\"Ptable\">\n");
        sb.append("    <tbody>\n");
        for (Map map : paramList) {
            sb.append("        <tr>\n");
            sb.append("            <th class=\"tdTitle\" colspan=\"2\">"+map.get("group")+"</th>\n");
            sb.append("        </tr>\n");
            List<Map> params = (List<Map>) map.get("params");
            for (Map map2 : params) {
                sb.append("        <tr>\n");
                sb.append("            <td class=\"tdTitle\">"+map2.get("k")+"</td>\n");
                sb.append("            <td>"+map2.get("v")+"</td>\n");
                sb.append("        </tr>\n");
            }
        }
        sb.append("    </tbody>\n");
        sb.append("</table>");
        //sb.append("</div>");
        return sb.toString();
    }
}
>>>>>>> 6ecebbde8b13b2622d127af4b088ea1f059d3297
