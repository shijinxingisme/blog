package com.my.blog.website.service.impl;

import com.my.blog.website.controller.admin.AttachController;
import com.my.blog.website.dao.MetaVoMapper;
import com.my.blog.website.exception.TipException;
import com.my.blog.website.modal.Bo.BackResponseBo;
import com.my.blog.website.modal.Vo.MetaVo;
import com.my.blog.website.modal.Vo.MetaVoExample;
import com.my.blog.website.service.IContentService;
import com.my.blog.website.service.ITestService;
import com.my.blog.website.utils.DateKit;
import com.my.blog.website.utils.TaleUtils;
import com.my.blog.website.utils.ZipUtils;
import com.my.blog.website.utils.backup.Backup;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.File;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @auther shijx
 * @description 类描述
 * @date 2019/5/27
 */
@Service
public class ITestServiceImpl implements ITestService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ITestServiceImpl.class);
    @Resource
    private MetaVoMapper metaDao;

    @Resource
    private IContentService contentService;


    @Override
    public void saveMeta(String type, String name, Integer mid) {
        if (StringUtils.isNotBlank(type) && StringUtils.isNotBlank(name)) {
            MetaVoExample metaVoExample = new MetaVoExample();
            metaVoExample.createCriteria().andTypeEqualTo(type).andNameEqualTo(name);
            List<MetaVo> metaVos = metaDao.selectByExample(metaVoExample);
            MetaVo metas;
            if (metaVos.size() != 0) {
                throw new TipException("已经存在该项");
            } else {
                metas = new MetaVo();
                metas.setName(name);
                if (null != mid) {
                    MetaVo original = metaDao.selectByPrimaryKey(mid);
                    metas.setMid(mid);
                    metaDao.updateByPrimaryKeySelective(metas);
//                    更新原有文章的categories
                    contentService.updateCategory(original.getName(),name);
                } else {
                    metas.setType(type);
                    metaDao.insertSelective(metas);
                    throw new TipException("已经存在该项XXXXXXXX");
                }
            }

        }
    }
}
