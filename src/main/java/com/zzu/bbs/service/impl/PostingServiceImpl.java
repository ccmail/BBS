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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostingServiceImpl implements PostingService {

    @Autowired
    private PostingMapper postingMapper;

    @Autowired
    private UserMapper userMapper;

    @NotNull
    @Override
    public PageInfo<PostingDTO> getPageInfo(int pageNum, int pageSize) {


        PageHelper.startPage(pageNum, pageSize);
        List<Posting> postings = postingMapper.selectAllPosting();
        PageInfo postingPageInfo = new PageInfo(postings);

        List<PostingDTO> postingDTOList = new ArrayList<>();

        for (Posting posting : postings) {
            User user = userMapper.findById(posting.getCreator());
            PostingDTO postingDTO = new PostingDTO();
            BeanUtils.copyProperties(posting, postingDTO);
            postingDTO.setUser(user);
            postingDTOList.add(postingDTO);
        }

        postingPageInfo.setList(postingDTOList);

        return postingPageInfo;
    }
}
