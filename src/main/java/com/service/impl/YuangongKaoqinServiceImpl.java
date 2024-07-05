package com.service.impl;

import com.utils.StringUtil;
import com.service.DictionaryService;
import com.utils.ClazzDiff;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.Field;
import java.util.*;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;
import com.dao.YuangongKaoqinDao;
import com.entity.YuangongKaoqinEntity;
import com.service.YuangongKaoqinService;
import com.entity.view.YuangongKaoqinView;

/**
 * 员工考勤 服务实现类
 */
@Service("yuangongKaoqinService")
@Transactional
public class YuangongKaoqinServiceImpl extends ServiceImpl<YuangongKaoqinDao, YuangongKaoqinEntity> implements YuangongKaoqinService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        Page<YuangongKaoqinView> page =new Query<YuangongKaoqinView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }


}
