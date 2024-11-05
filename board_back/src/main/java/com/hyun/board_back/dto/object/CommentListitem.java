package com.hyun.board_back.dto.object;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentListitem {

    private String nickname;
    private String  profileImage;
    private String writeDatetime;
    private String content;
    
}