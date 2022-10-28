// object1.js

function Student(stdNo, stdName, mathScore) {
    this.stdNo = stdNo;
    this.stdName = stdName;
    this.mathScore = mathScore;

}

let std1 = new Student('1111', '황길동', 90);
let std2 = new Student('2222', '김소라', 57);
let std3 = new Student('3333', '화이자', 81);

const students = [std1, std2, std3];

//연습 <ul><li>학생1</li><li>학생2</li><li>학생3</li></ul>
let ulTag = document.createElement('ul'); //ul이라는 태그를 만들겠습니다.
for(let i=0; i<students.length; i++){

    let liTag = document.createElement('li');
    let txt = document.createTextNode(`학번: ${students[i].stdNo}, 이름:${students[i].stdName}, 수학점수:${students[i].mathScore}`);
    
    ulTag.appendChild(liTag); //<ul><li></li></ul>
    liTag.appendChild(txt);
}


document.getElementById('show').appendChild(ulTag);



