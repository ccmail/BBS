package com.zzu.bbs.service.impl;
/*
 * User:程成
 * Date:2021/5/9
 * Time:11:14
 * Description:
 */

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.User;
import com.zzu.bbs.service.PostingService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class PostingServiceImpl implements PostingService {

    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<PostingDTO> getPageList() {
        List<Posting> postings = postingMapper.selectAllPosting();
        List<PostingDTO> postingDTOList = new ArrayList<>();

        for (Posting posting : postings) {
            User user = userMapper.findById(posting.getCreator());
            PostingDTO postingDTO = new PostingDTO();
            BeanUtils.copyProperties(posting, postingDTO);
            postingDTO.setUser(user);
            postingDTOList.add(postingDTO);
        }
        return postingDTOList;
    }

    @NotNull
    @Override
    public PageInfo<PostingDTO> getPageInfo(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<PostingDTO> pageList = getPageList();
        PageInfo<PostingDTO> pageInfo = new PageInfo<>(pageList);
        return pageInfo;
    }
}
