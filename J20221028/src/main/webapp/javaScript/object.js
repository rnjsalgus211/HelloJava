// object.js 파일.

let obj = {
    user_id: "hong",
    user_name: "Hongkildong",
    user_age: 20, 
    hobbies: ['독서', '낮잠', '자전거', '영화감상'],
    show_info: function() { //오브젝트 안에서 필드를 사용할 때는 this.필드명으로 작성.
        return 'id: ' + this.user_id + ', name: ' + this.user_name + //
        ', age: ' + this.user_age;
    }
}

console.log('id: ' + obj.user_id);
console.log('name: ' + obj["user_name"]);
let field = "user_age";
console.log('age: ' + obj[field]);
console.log('첫번째 취미: ' + obj.hobbies[0]);

console.log('홍의 정보[' + obj.show_info()+']');


// 객체 생성.
function Person(name, age){   //생성자 함수를 사용
    this.name = name; //윈도우 객체 X Person객체를 가리킴..?
    this.age = age;

    this.showInfo = function(){
        return '이름은 ' + this.name + ', 나이는 ' + this.age;
    }
}

let p1 = new Person('권미현', 20); //new 연산자 (새로운 인스턴스 만들 때 사용) 만들어진 객체의 주소값을 p1이 가지고 있음
let p2 = new Person('김말이', 30);
let p3 = new Person('박명수', 40);

const persons = [p1, p2, p3];
for(let i = 0; i<persons.length; i++){
    console.log(persons[i].showInfo());

}

//new 키워드 없이 만드는 함수
function person(name) {
    this.name = name; //여기서 this. 는 윈도우 객체 (최상위 객체)
}
person('김민수');
console.log(this);


//this : 함수, 전역영역에서 this를 사용하면 window객체를 가리킴
//       object에서 사용이 되면 this는 객체 자신을 가리킴.