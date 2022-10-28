<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script src="object.js"></script>
</head>
<body>
    <!-- id값은 유니크값.-->
    <form action="index.html" onsubmit="submitFunc()">
        id: <input type="text" id="uid" value="user1"><br> 
        pw: <input type="password" id="upw" value="1234"><br>
        <input type="submit" value="로그인">
    </form>

    <div id="show"></div>

    <script>

        function saveFunc() { //함수 -> 호출하지 않는 한 실행되지 않음.
        // document.write('<p>Hello. World</p>');
        // DOM 요소생성.
        document.createElement('p');
        let pTag = document.createElement('p'); //<p></p>
        let txt = document.createTextNode('Hello, World');
        pTag.appendChild(txt); //<p>Hello, World<p> p태그가 textnode감싸고 있음.
        console.log(pTag);

        let show = document.getElementById('show');
        show.appendChild(pTag);
        console.log(show);
        }


        function submitFunc() {
            event.preventDefault(); //form이 가지고있는 기본 기능을 차단하겠습니다. -> '로그인' 눌러도 index.html 페이지 이동 안하고 그대로 머물러있음.
            console.log('submitFunc() call.');
            
            // 엘리먼트를 선택하는데 id속성을 통해서 요소(엘리먼트)를 선택.
            let id = document.getElementById('uid').value;
            let pw = document.getElementById('upw').value;

            let pTag = document.createElement('p'); //요소를 만들때는 document.createElement
            let txt = document.createTextNode('id는 '+ id + ', 비번은' + pw); //실제 값이 들어감.
            pTag.appendChild(txt); //p태그와 txt를 서로 부모 자식관계로 만들어주고

            pTag.onclick = function() {
                console.log(this.remove()); //this는 가장 상위에 존재하는 객체.
                
                
            }

            document.getElementById('show').appendChild(pTag); //show라는 아이디 값을 가지고 있는 요소의 하위 요소로 pTag를 붙여주겠다.

        }
    </script>
</body>
</html>