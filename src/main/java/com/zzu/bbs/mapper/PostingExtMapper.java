package com.zzu.bbs.mapper;

import com.zzu.bbs.model.Posting;

public interface PostingExtMapper {

    int addViewCount(Posting record);
}