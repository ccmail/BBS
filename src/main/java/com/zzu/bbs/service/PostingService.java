package com.zzu.bbs.service;
/*
 * User:程成
 * Date:2021/5/7
 * Time:21:06
 * Description:用于组装Posting和User的中间层
 */

import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.model.Posting;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {


    PageInfo<PostingDTO> getPageInfo(Integer id, Integer pageStart, int pageSize);

    PageInfo<PostingDTO> getPageInfo(int pageNum, int pageSize);

    PostingDTO getById(Integer id);

    void createOrUpdate(Posting posting);

    void addViewCount(Integer id);
}
