package com.zzu.bbs;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzu.bbs.dto.PostingDTO;
import com.zzu.bbs.mapper.PostingMapper;
import com.zzu.bbs.service.PostingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BBSApplicationTests {

    @Autowired
    PostingMapper postingMapper;

    //    @Test
//    public List<PostingDTO> page_list(){
//        PageHelper.startPage(2,3);
//List<PostingDTO> postingDTOList
//    }



}
