# No Think, Yes Write (Sub: 생각없이 끄적이는 곳)

### Release Version : 1.0.0
#### v1.0.0
* 웹사이트 링크 업데이트 안됨. (추후 추가 예정)
----
### Index
 0. Intro
 1. Tech / Environment
 2. How to Use
 3. UI / UX & Functions
 4. License

---
## [Intro]
* 누구나 접속하여, 익명 또는 회원으로 글을 작성하고 소통할 수 있는 간단한 커뮤니티 서비스입니다.

## [Tech/Environment]

### Environment
| #             | Tech / Environment |
|---------------|--------------------|
| Base Language | Java 1.8           |
| Base Projects | Apache Maven 3.8.5 |
| DB            | MySQL / DBCP 2.9.0 |
| Server        | Tomcat 8.5.73      | 

### Brower Support
| Chrome | Firefox |
|--------|---------|
| Latest | Latest  |

### Front-End Library
* Bootstrap 5.0.2
* JSTL 1.2

---
## [How To Use]

####
1. Compile and install yourself
    * `git clone`
    * `mvn clean`
    * `mvn compile`
    * `mvn install`
    * Deploy WAR(target directory) file to Server
####
    
2. Install WAR 
    * Download Link : https://drive.google.com/file/d/1L9dfCzrXc9hJiK7OYfRGUfJ52rqXE3KE/view?usp=sharing
    * Deploy WAR file to Server
####
    
3. URL Link
    * Web Site URL : TBD
---
## [UI/UX & Functions]
* Start Page
![](../../Desktop/시작화면.png)
익명 또는 회원으로 접속이 가능합니다.
####

* Login Page
![](../../Desktop/로그인.png)
간단한 회원가입을 통해 회원으로 등록해 아이디/비밀번호로 접속합니다.
####

* Main Page
![](../../Desktop/메인.png)
피드의 제목을 클릭해 피드를 볼 수 있습니다. Like/조회수가 일정치를 넘으면 '많이 본 글', '인기글'에 등록됩니다.
####

* Search Page
  ![](../../Desktop/검색.png)
검색창을 통해 검색을 합니다. 이전 검색 기록을 클릭하여 검색도 가능합니다.
####

* Write Page
![](../../Desktop/글쓰기.png)
나만의 글을 작성합니다.
####

* Read Page
![](../../Desktop/글보기.png)
글을 보고 본인이 작성한 글의 경우, 수정 삭제를 할 수 있습니다. 익명의 경우, 비밀번호를 통해 수정/삭제 권한을 얻을 수 있습니다.
댓글을 작성할 수 있습니다.

----
## [License]
* This project is licensed under the terms of the MIT license.
