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
import com.zzu.bbs.exception.CustomErrorCode;
import com.zzu.bbs.exception.CustomException;
import com.zzu.bbs.mapper.PostingExtMapper;
import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.PostingExample;
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

    @Autowired
    private PostingExtMapper postingExtMapper;

    /**
     * 个人中心页使用, 展示根据id查到的帖子
     *
     * @param id        用户id, int类型
     * @param pageStart 起始页面
     * @param pageSize  页面帖子数量
     * @return pagInfo
     */
    @NotNull
    @Override
    public PageInfo<PostingDTO> getPageInfo(Long id, Integer pageStart, int pageSize) {
        PageHelper.startPage(pageStart, pageSize);
//        List<Posting> postings = postingMapper.selectAllPostingByUser(id);
        PostingExample postingExample = new PostingExample();
        postingExample.createCriteria().andCreatorEqualTo(id);
        List<Posting> postings = postingMapper.selectByExample(postingExample);
        return getPostingDTOPageInfo(postings);
    }


    /**
     * index首页使用, 展示所有帖子的方法
     *
     * @param pageNum  起始页
     * @param pageSize 页面帖子数量
     * @return 返回pageInfo
     */
    @NotNull
    @Override
    public PageInfo<PostingDTO> getPageInfo(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);
//        List<Posting> postings = postingMapper.selectAllPosting();
        PostingExample postingExample = new PostingExample();
        postingExample.createCriteria();
        List<Posting> postings = postingMapper.selectByExample(postingExample);


        return getPostingDTOPageInfo(postings);
    }

    /**
     * 自动提取生成的使用pageHelper的公共部分
     *
     * @param postings 从数据库中查到的帖子集合
     * @return 未经处理的pageInfo
     */
    @NotNull
    private PageInfo<PostingDTO> getPostingDTOPageInfo(List<Posting> postings) {
        PageInfo postingPageInfo = new PageInfo(postings);

        List<PostingDTO> postingDTOList = new ArrayList<>();

        for (Posting posting : postings) {
            User user = userMapper.selectByPrimaryKey(posting.getCreator());
            PostingDTO postingDTO = new PostingDTO();
            BeanUtils.copyProperties(posting, postingDTO);
            postingDTO.setUser(user);
            postingDTOList.add(postingDTO);
        }

        postingPageInfo.setList(postingDTOList);

        return postingPageInfo;
    }

    /**
     * 用于更新或者发布帖子
     *
     * @param posting 页面填入的数据
     */
    @Override
    public void createOrUpdate(Posting posting) {
        if (posting.getId() == null) {
//            通过id判断当前帖子是否为编辑

            posting.setGmtCreate(System.currentTimeMillis());
            posting.setGmtModify(posting.getGmtCreate());
//            postingMapper.create(posting);
            postingMapper.insert(posting);
        } else {
            //扔异常
            Posting dbPosting = postingMapper.selectByPrimaryKey(posting.getId());
            if (dbPosting == null) {
                throw new CustomException(CustomErrorCode.QUESTION_NOT_FOUND);
            }

            if (dbPosting.getCreator().longValue() != posting.getCreator().longValue()) {
                throw new CustomException(CustomErrorCode.INVALID_OPERATION);
            }

//            更新
            posting.setGmtModify(posting.getGmtCreate());

            PostingExample postingExample = new PostingExample();
            postingExample.createCriteria().andIdEqualTo(posting.getId());
//            postingMapper.update(posting);
            int updated = postingMapper.updateByExampleSelective(posting, postingExample);
            if (updated != 1) {
                throw new CustomException(CustomErrorCode.QUESTION_NOT_FOUND);
            }

        }
    }

    /**
     * 通过id获取帖子的具体信息
     *
     * @param id 帖子的唯一id值
     * @return 帖子的具体信息
     */
    @Override
    public PostingDTO getById(Long id) {

//        Posting posting = postingMapper.getPostingById(id);
        PostingExample postingExample = new PostingExample();
        postingExample.createCriteria().andIdEqualTo(id);
//        List<Posting> postings = postingMapper.selectByExample(postingExample);
        List<Posting> postings = postingMapper.selectByExampleWithBLOBs(postingExample);
        if (postings.size() == 0) {
            throw new CustomException(CustomErrorCode.QUESTION_NOT_FOUND);

        }
        Posting posting = postings.get(0);

        PostingDTO postingDTO = new PostingDTO();
        BeanUtils.copyProperties(posting, postingDTO);
        User user = userMapper.selectByPrimaryKey(posting.getCreator());
        postingDTO.setUser(user);
        return postingDTO;
    }

    @Override
    public void addViewCount(Long id) {

        Posting posting = new Posting();
        posting.setId(id);
        posting.setViewCount(1);
        postingExtMapper.addViewCount(posting);
    }
}
