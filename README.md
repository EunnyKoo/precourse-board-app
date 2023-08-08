# precourse-board-app
# 개커플 (개발자들을 위한 커뮤니티 플랫폼)

**개커플**은 항해 99 프리코스 1기 토이 프로젝트로 개발된 커뮤니티 플랫폼입니다.   
이 프로젝트는 CRUD(Create, Read, Update, Delete) 작업을 연습하고 구현하기 위한 목적으로 시작되었습니다.

## 주요 기능

- 사용자 등록, 로그인, 로그아웃 기능
- 게시물 생성, 조회, 수정, 삭제 기능

## 스펙

- Frontend: Vue.js
- Backend: Spring
- 데이터베이스: H2 Database
      
- Java: 17.0.7
- Gradle: 8.2.1
- Spring: 3.1.2
- Lombok 사용
- Spring Web 사용
- H2 Database 사용


## 설치 및 실행 방법

1. 저장소를 클론합니다.
   ```sh
   git clone https://github.com/hayul93/precourse-board-app.git

   OR

   git clone git@github.com:hayul93/precourse-board-app.git
   ```
   
2. 프로젝트 디렉토리로 이동합니다.
   ```sh
   cd precourse-board-app

3. Frontend와 Backend 각각의 Dependency를 설치합니다.
   Frontend   
   ```sh
   cd vue-board
   npm install
   ```   
   Backend   
   ```sh
   cd precourse-board-app
   ./gradlew build
   ```

4. 개발 서버를 실행합니다.
   Frontend
   ```sh
   cd vue-board
   npm run serve
   ```
   Backend
   ```sh
   cd precourse-board-app
   java -jar build/libs/your-project-name.jar
   ```
5. 웹 브라우저에서 `http://localhost:3000`에 접속하여 개커플을 이용할 수 있습니다.


---
개발자: 항해99 프리코스 1기 6조
