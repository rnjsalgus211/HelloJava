//array1.js
fetch('data/MOCK_DATA.json')
.then( result => result.json())
.then( composeFnc )
.catch( error => console.error(error) );

console.log(result);
function composeFnc(result = [] ) { //result = []라고 넣어줘야 배열이라는 것을 인식.
    //급여가 5000이 넘는 사람들만 filter한 후에 새로운 모임을 만들자.
    result.filter( row => row.salary > 5000)
          .map( row => {
            let team = {
                t_id: row.id,
                t_name: row.first_name + '/' + row.last_name,
            }
            team.t_mail = row.email; 
            team['t_dept'] = 'Account';
            return team;
            //team.t_id = row.id;
            //team.t_name = row.first_name + '/' + row.last_name;
           // return team; // => team은 오브젝트. 속성하나씩 추가해도 되고 바로 넣어도되고.
          })
          .forEach(team => console.log(team));
}



//Array.map() => row -> row' row 데이터를 받아서 새로운 형태의 데이터 (row')를 생성.
function mappingFnc(result = []) {
    let newAry = result.map( row=> {
        let newObj = {}; // = new Object();와 같은 말. (새로운 오브젝트 선언)
        newObj.user_id = row.id;
        newObj.user_name = row.first_name + '-' + row.last_name;
        newObj.info = row.email;

        return newObj;
    });

    newAry.forEach(obj => console.log(obj));
}




// Array.filter() => 매개함수의 반환값이 true인 요소들만 모아서 새로운 배열을 만들어준다.
function filterFnc(result = []){ //값이 들어오지 않으면.
    result.filter((row, idx)=>  row.salary > 5000) //필터링하는것, 조건을 만족하는 새로운 배열을 만들어줌.
        //return idx % 2 == 0; 
       .forEach ( row => console.log(row)); //바로 이어서 쓰면 밑에 처럼 변수를 선언할 필요 X

    //oddAry.forEach(row => console.log(row));

}


//Array.forEach() => 반환값은 없고 최종처리하는 기능을 구현.
function showMain(result) {
    console.log(result);
    result.forEach((row, idx) =>{  //forEach는 리턴타입이 void인 메소드
        console.log(row)
        // if(row.gender == 'Female'){
            if(idx % 2==0){
            console.log(row.id, row.first_name, row.last_name);
        }
    });
}


function sum(a=0, b=0){
    return a+b;
}

console.log(sum(10));

