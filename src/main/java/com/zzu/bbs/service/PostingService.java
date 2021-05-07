package com.zzu.bbs.service;
/*
 * User:程成
 * Date:2021/5/7
 * Time:21:06
 * Description:用于组装Posting和User的中间层
 */

import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.mapper.UserMapper;
import com.zzu.bbs.model.Posting;
import com.zzu.bbs.model.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostingService {

    @Autowired
    private PostingMapper postingMapper;
    @Autowired
    private UserMapper userMapper;

    public List<PostingDTO> list() {
        List<Posting> postings = postingMapper.list();
        List<PostingDTO> postingDTOList = new ArrayList<>();
//        每层for循环将整合好的posting信息和对应的user信息装到List中
        for (Posting posting : postings) {
            User user = userMapper.findById(posting.getCreator());
            PostingDTO postingDTO = new PostingDTO();
            //快速将一个对象的属性拷贝到另一个对象身上的工具类
            BeanUtils.copyProperties(posting, postingDTO);
            postingDTO.setUser(user);
            postingDTOList.add(postingDTO);
        }
        return postingDTOList;
    }
}
