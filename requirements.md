# 게시판 만들기 위해 제공해야 하는 API

- 게시글 목록 (Read)
- 글 상세 보기 (Read)
- 글 작성 (Create)
- 글 삭제 (Delete)
- 글 수정 (Update)

REST API 작성시 RESTful 하게 작성해야 한다

## 판매 게시글 목록 (0)
- GET /board
- Request Body(front -> Back): x
- Response Body(Back -> front): [ {게시글 번호, 게시글 제목, 글쓴이} ]

## 판매 글 상세 보기 (0)
- GET/board/1
- GET/board/2

- Request Body(front -> Back): x
- Response Body(Back -> front): 게시글에 대한 상세정보 (제목, 내용 등등)

## 판매 글 작성 (0)
- POST /board
- Request Body(front -> Back): 제목, 내용, 글쓴이
- Response Body(Back -> front): 생성완료 메세지 (201)

## 판매 글 삭제 (Delete) (0)
- DELETE /board/1
- Request Body(front -> Back): 게시글 번호
- Response Body(Back -> front): 삭제 완료 메세지

## 판매 글 수정 (Update) (0)
- PUT /board/1
- Request Body(front -> Back): 번호, 제목, 내용, 글쓴이
- Response Body(Back -> front): 번호, 제목, 내용, 글쓴이