import React from 'react'
import './style.css';
import { BoardListItem } from 'types/interface';

interface Props{
    boardListItem: BoardListItem
}

//      component: Board List Item 컴포넌트
export default function BoardListItem( {boardListItem}: Props) {
        //properties
         const{ boardNumber,
                title,
                content, 
                boardTitleImage,
                favoriteCount,
                commentCount,
                viewCount,
                writeDatetime,
                writerNickname,
                writerProfileImage } = boardListItem;

            //function: 네비게이트 함수
        
    
  //     render: Board List Item 컴포넌트 렌더링
    return (
    <div className='board-list-item'>
        <div className='board-list-main-box'>
            <div className='board-list-item-top'>
                <div className='board-list-item-profile-box'>
                    <div className='board-list-profile-image' style={{backgroundImage: 'url( ${writerProfileImage})'}}></div>
                </div>
                <div className='board-list-item-write-box'>
                    <div className='board-list-item-nickcname'>{writerNickname}</div>
                    <div className='board-list-item-write-datetime'>{writeDatetime}</div>
                </div>
            </div>
            <div className='board-list-item-middle'>
                <div className='board-list-item-title'>{title}</div>
                <div className='board-list-item-content'>{content}</div>
            </div>
            <div className='board-list-itme-bottom'>
                <div className='board-list-item-counts'>
                    {'댓글 ${commentCount}  좋아요 ${favoriteCount}  조회수 ${viewCount}'}
                </div>
            </div>
        </div>
        {boardTitleImage ! == null && (    
        <div className='board-list-item-image-box'>
            <div className='board-list-item-image' style={{backgroundImage: 'url(${boardTitleImage})'}}></div>
        </div>
        )}
    </div>
  )
}
