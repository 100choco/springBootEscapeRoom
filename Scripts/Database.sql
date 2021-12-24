-- 방 탈출
DROP SCHEMA IF EXISTS springBootEscapeRoom;

-- 방 탈출
CREATE SCHEMA springBootEscapeRoom;

-- 회원
CREATE TABLE springBootEscapeRoom.member (
	memberNo       BIGINT       NOT NULL COMMENT '회원번호', -- 회원번호
	memberId       VARCHAR(20)  NOT NULL COMMENT '회원아이디', -- 회원아이디
	memberPassword VARCHAR(100) NOT NULL COMMENT '회원비밀번호', -- 회원비밀번호
	memberPhone    VARCHAR(20)  NOT NULL COMMENT '회원전화번호', -- 회원전화번호
	memberName     VARCHAR(10)  NOT NULL COMMENT '회원이름' -- 회원이름
)
COMMENT '회원';

-- 회원
ALTER TABLE springBootEscapeRoom.member
	ADD CONSTRAINT PK_member -- 회원 기본키
		PRIMARY KEY (
			memberNo -- 회원번호
		);

ALTER TABLE springBootEscapeRoom.member
	MODIFY COLUMN memberNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '회원번호';

ALTER TABLE springBootEscapeRoom.member
	AUTO_INCREMENT = 1;

-- 관리자
CREATE TABLE springBootEscapeRoom.admin (
	adminNo   BIGINT       NOT NULL COMMENT '관리자번호', -- 관리자번호
	adminId   VARCHAR(20)  NOT NULL COMMENT '관리자아이디', -- 관리자아이디
	adminPW   VARCHAR(100) NOT NULL COMMENT '관리자비밀번호', -- 관리자비밀번호
	adminName VARCHAR(10)  NOT NULL COMMENT '관리자이름' -- 관리자이름
)
COMMENT '관리자';

-- 관리자
ALTER TABLE springBootEscapeRoom.admin
	ADD CONSTRAINT PK_admin -- 관리자 기본키
		PRIMARY KEY (
			adminNo -- 관리자번호
		);

ALTER TABLE springBootEscapeRoom.admin
	MODIFY COLUMN adminNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '관리자번호';

ALTER TABLE springBootEscapeRoom.admin
	AUTO_INCREMENT = 1;

-- 방
CREATE TABLE springBootEscapeRoom.room (
	roomNo          BIGINT      NOT NULL COMMENT '방번호', -- 방번호
	themeNo         BIGINT      NOT NULL COMMENT '테마번호', -- 테마번호
	difficultyNo    BIGINT      NOT NULL COMMENT '난이도번호', -- 난이도번호
	playTimeNo      BIGINT      NOT NULL COMMENT '진행시간번호', -- 진행시간번호
	operatingTimeNo BIGINT      NULL     COMMENT '운영시간번호', -- 운영시간번호
	roomName        varchar(20) NULL     COMMENT '방이름', -- 방이름
	roomCapacity    INT         NULL     COMMENT '방인원', -- 방인원
	roomImg         VARCHAR(50) NULL     COMMENT '방이미지', -- 방이미지
	roomPrice       INT         NULL     COMMENT '금액', -- 금액
	roomExplanation TEXT        NULL     COMMENT '방설명' -- 방설명
)
COMMENT '방';

-- 방
ALTER TABLE springBootEscapeRoom.room
	ADD CONSTRAINT PK_room -- 방 기본키
		PRIMARY KEY (
			roomNo -- 방번호
		);

ALTER TABLE springBootEscapeRoom.room
	MODIFY COLUMN roomNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '방번호';

ALTER TABLE springBootEscapeRoom.room
	AUTO_INCREMENT = 1;

-- 테마
CREATE TABLE springBootEscapeRoom.theme (
	themeNo   BIGINT      NOT NULL COMMENT '테마번호', -- 테마번호
	themeName varchar(20) NOT NULL COMMENT '테마이름' -- 테마이름
)
COMMENT '테마';

-- 테마
ALTER TABLE springBootEscapeRoom.theme
	ADD CONSTRAINT PK_theme -- 테마 기본키
		PRIMARY KEY (
			themeNo -- 테마번호
		);

ALTER TABLE springBootEscapeRoom.theme
	MODIFY COLUMN themeNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '테마번호';

ALTER TABLE springBootEscapeRoom.theme
	AUTO_INCREMENT = 1;

-- 난이도
CREATE TABLE springBootEscapeRoom.difficulty (
	difficultyNo BIGINT NOT NULL COMMENT '난이도번호', -- 난이도번호
	difficulty   INT    NOT NULL COMMENT '난이도' -- 난이도
)
COMMENT '난이도';

-- 난이도
ALTER TABLE springBootEscapeRoom.difficulty
	ADD CONSTRAINT PK_difficulty -- 난이도 기본키
		PRIMARY KEY (
			difficultyNo -- 난이도번호
		);

ALTER TABLE springBootEscapeRoom.difficulty
	MODIFY COLUMN difficultyNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '난이도번호';

ALTER TABLE springBootEscapeRoom.difficulty
	AUTO_INCREMENT = 1;

-- 1:1문의
CREATE TABLE springBootEscapeRoom.qna (
	qnaNo         BIGINT       NOT NULL COMMENT '문의번호', -- 문의번호
	qnaTitle      varchar(50)  NOT NULL COMMENT '문의제목', -- 문의제목
	qnaName       VARCHAR(10)  NOT NULL COMMENT '문의작성자', -- 문의작성자
	qnaContents   TEXT         NOT NULL COMMENT '문의내용', -- 문의내용
	qnaPassword   VARCHAR(100) NULL     COMMENT '문의비밀번호', -- 문의비밀번호
	qanDate       DATETIME     NOT NULL COMMENT '문의작성일', -- 문의작성일
	adminNo       BIGINT       NULL     COMMENT '관리자번호', -- 관리자번호
	qnaStatus     VARCHAR(20)  NULL     DEFAULT "미답변" COMMENT '답변상태', -- 답변상태
	qnaAnswer     TEXT         NULL     COMMENT '답변내용', -- 답변내용
	qnaAnswerDate DATETIME     NULL     COMMENT '답변일자' -- 답변일자
)
COMMENT '1:1문의';

-- 1:1문의
ALTER TABLE springBootEscapeRoom.qna
	ADD CONSTRAINT PK_qna -- 1:1문의 기본키
		PRIMARY KEY (
			qnaNo -- 문의번호
		);

ALTER TABLE springBootEscapeRoom.qna
	MODIFY COLUMN qnaNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '문의번호';

ALTER TABLE springBootEscapeRoom.qna
	AUTO_INCREMENT = 1;

-- 진행시간
CREATE TABLE springBootEscapeRoom.playTime (
	playTimeNo BIGINT   NOT NULL COMMENT '진행시간번호', -- 진행시간번호
	platTime   DATETIME NOT NULL COMMENT '새 컬럼' -- 새 컬럼
)
COMMENT '진행시간';

-- 진행시간
ALTER TABLE springBootEscapeRoom.playTime
	ADD CONSTRAINT PK_playTime -- 진행시간 기본키
		PRIMARY KEY (
			playTimeNo -- 진행시간번호
		);

ALTER TABLE springBootEscapeRoom.playTime
	MODIFY COLUMN playTimeNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '진행시간번호';

ALTER TABLE springBootEscapeRoom.playTime
	AUTO_INCREMENT = 1;

-- 예약
CREATE TABLE springBootEscapeRoom.reservation (
	reservationNo       BIGINT       NOT NULL COMMENT '예약번호', -- 예약번호
	reservationId       VARCHAR(100) NOT NULL COMMENT '예약아이디', -- 예약아이디
	reservationTime     DATETIME     NOT NULL COMMENT '예약시간', -- 예약시간
	roomNo              BIGINT       NOT NULL COMMENT '방번호', -- 방번호
	reservationName     VARCHAR(10)  NOT NULL COMMENT '예약자', -- 예약자
	reservationPhone    VARCHAR(20)  NOT NULL COMMENT '예약자전화번호', -- 예약자전화번호
	reservationCapacity INT          NOT NULL COMMENT '예약인원', -- 예약인원
	roomPrice           INT          NOT NULL COMMENT '금액' -- 금액
)
COMMENT '예약';

-- 예약
ALTER TABLE springBootEscapeRoom.reservation
	ADD CONSTRAINT PK_reservation -- 예약 기본키
		PRIMARY KEY (
			reservationNo -- 예약번호
		);

ALTER TABLE springBootEscapeRoom.reservation
	MODIFY COLUMN reservationNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '예약번호';

ALTER TABLE springBootEscapeRoom.reservation
	AUTO_INCREMENT = 1;

-- 운영시간
CREATE TABLE springBootEscapeRoom.operatingTime (
	operatingTimeNo BIGINT   NOT NULL COMMENT '운영시간번호', -- 운영시간번호
	operatingTime   DATETIME NOT NULL COMMENT '운영시간' -- 운영시간
)
COMMENT '운영시간';

-- 운영시간
ALTER TABLE springBootEscapeRoom.operatingTime
	ADD CONSTRAINT PK_operatingTime -- 운영시간 기본키
		PRIMARY KEY (
			operatingTimeNo -- 운영시간번호
		);

ALTER TABLE springBootEscapeRoom.operatingTime
	MODIFY COLUMN operatingTimeNo BIGINT NOT NULL AUTO_INCREMENT COMMENT '운영시간번호';

ALTER TABLE springBootEscapeRoom.operatingTime
	AUTO_INCREMENT = 1;

-- 방
ALTER TABLE springBootEscapeRoom.room
	ADD CONSTRAINT FK_theme_TO_room -- 테마 -> 방
		FOREIGN KEY (
			themeNo -- 테마번호
		)
		REFERENCES springBootEscapeRoom.theme ( -- 테마
			themeNo -- 테마번호
		);

-- 방
ALTER TABLE springBootEscapeRoom.room
	ADD CONSTRAINT FK_difficulty_TO_room -- 난이도 -> 방
		FOREIGN KEY (
			difficultyNo -- 난이도번호
		)
		REFERENCES springBootEscapeRoom.difficulty ( -- 난이도
			difficultyNo -- 난이도번호
		);

-- 방
ALTER TABLE springBootEscapeRoom.room
	ADD CONSTRAINT FK_playTime_TO_room -- 진행시간 -> 방
		FOREIGN KEY (
			playTimeNo -- 진행시간번호
		)
		REFERENCES springBootEscapeRoom.playTime ( -- 진행시간
			playTimeNo -- 진행시간번호
		);

-- 방
ALTER TABLE springBootEscapeRoom.room
	ADD CONSTRAINT FK_operatingTime_TO_room -- 운영시간 -> 방
		FOREIGN KEY (
			operatingTimeNo -- 운영시간번호
		)
		REFERENCES springBootEscapeRoom.operatingTime ( -- 운영시간
			operatingTimeNo -- 운영시간번호
		);

-- 1:1문의
ALTER TABLE springBootEscapeRoom.qna
	ADD CONSTRAINT FK_admin_TO_qna -- 관리자 -> 1:1문의
		FOREIGN KEY (
			adminNo -- 관리자번호
		)
		REFERENCES springBootEscapeRoom.admin ( -- 관리자
			adminNo -- 관리자번호
		);

-- 예약
ALTER TABLE springBootEscapeRoom.reservation
	ADD CONSTRAINT FK_room_TO_reservation -- 방 -> 예약
		FOREIGN KEY (
			roomNo -- 방번호
		)
		REFERENCES springBootEscapeRoom.room ( -- 방
			roomNo -- 방번호
		);