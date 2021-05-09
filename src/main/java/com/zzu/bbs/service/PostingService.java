package com.zzu.bbs.service;
/*
 * User:程成
 * Date:2021/5/7
 * Time:21:06
 * Description:用于组装Posting和User的中间层
 */

import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostingService {

    List<PostingDTO> getPageList();

    PageInfo<PostingDTO> getPageInfo(int pageNum, int pageSize);

}
