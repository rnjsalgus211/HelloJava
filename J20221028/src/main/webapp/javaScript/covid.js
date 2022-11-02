// covid.js

window.onload = function () { //모두 로딩되면
    //request url.
    let url =
        'https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=JSON&serviceKey=ZxvJgLlAle0lD0G7vxDtPmaOhN4C8gQpC4Bc%2FLsMlmFaCLnN%2FpuUTrE43MCE%2B57El9AD8u6UcqcKOIGH736HeA%3D%3D';

    fetch(url)
        .then(result => result.json()) //json -> object
        .then(showList)
        .catch(error => console.log(error));

    document.querySelector('#findBtn').addEventListener('click', findCenterList);


}
let titles = {
    id: '센터아이디',
    centerName: '센터명',
    phoneNumber: '연락처',
    lat: '위도',
    lng: '경도',
    facilityName: '기관명'
};

///////////////////////////////////////////////////////함수영역 ///////////////
let data; //전역변수로 선언.
function showList(result) {
    //타이틀 생성 함수 호출
    makeHead();

    //body 영역 생성.
    console.log(result);
    data = result.data;

    //option 태그 생성.
    makeOption(data); 

    let selectedCity = data.filter(center => center.sido == '서울특별시'); //sido값이 서울특별시 인 애들만 호출.

    makeList(selectedCity);
}



function makeOption(ary = []){
        //select 태그 생성.
        let sidoAry = []; //['서울특별시', '대전광역시'] 중복값 제외하고.
        data.forEach(center =>{
        //data에 있는 센터정보와 sidoAry에 있는 센터정보를 비교.
        //sidoAry에 값이 있으면 no, sidoAry 값이 없으면 추가.
        if(sidoAry.indexOf(center.sido) == -1){ //같은 값을 찾을 수 없으면 -1을 리턴. /시도 이름이 같지 않으면 sidoAry에 값을 추가.
            sidoAry.push(center.sido)
        }
    }); 

    let cityList = document.getElementById('city2');
    sidoAry.forEach(sido =>{
        let option = document.createElement('option');
        option.value = sido;
        option.textContent=sido;

        cityList.append(option);
    }
    );
}

function findCenterList() {
    let searchKey = document.getElementById('city2').value;
    let searchAry = data.filter(center => center.sido == searchKey);
    makeList(searchAry);
}



function makeList(ary = []) {
    //화면에 tr이 존재하면 tr을 삭제.
    document.querySelectorAll('#list>tr').forEach(tr => tr.remove()); //리스트 밑에 tr 다 가져와서 각각 요소(tr의 값을)를 삭제한다. (화면 깨끗하게)
    let list = document.getElementById('list');
    ary.forEach(center => { //데이터 건수 만큼 반복 돌기
        list.append(makeTr(center));
    });



    //
    document.querySelectorAll('#list>tr').forEach((tr, idx) => {
        let td = document.createElement('td');
        td.textContent = idx +1;
        tr.prepend(td); // append(): 마지막 위치에 추가. prepend():처음위치에 추가.
    })
}
function makeTr(row = {}) { //row라는 변수 선언. (center값 하나 들어오는 변수 row.)
    let tr = document.createElement('tr');
    tr.addEventListener('click', openInfoWindow);
    //td 생성
    for (let field in titles) { //객체 반복?
        let td = document.createElement('td');
        tr.setAttribute('lng', row.lng );
        tr.setAttribute('lat', row.lat);
        tr.setAttribute('facilityName', row.facilityName);
        let txt = document.createTextNode(row[field]); // row값과 field값의 조합.
        td.appendChild(txt); //텍스트는 td에 붙이고
        tr.appendChild(td); //만든 td를 tr에다가 붙이기
    }
    return tr;
}

function openInfoWindow(e){
    console.log(e.target.parentElement); //이벤트를 받는 대상 e.target. //tr lng. lat
    let lng = e.target.parentElement.getAttribute('lng');
    let lat = e.target.parentElement.getAttribute('lat');
    let facilityName = e.target.parentElement.getAttribute('facilityName');

    window.location.href = 'infoWindow.html?x='+lng+'&y='+lat+'&center='+facilityName; //url 페이지로 이동하겠습니다. 
}

function makeHead() {
    //타이틀.
    let tr = document.createElement('tr'); //타이틀 위에 붙일 tr.
    let th = document.createElement('th');
    th.textContent ='순번';
    tr.appendChild(th);

    for (let title in titles) {
        let th = document.createElement('th'); //타이틀 길이만큼 th생성.
        let txt = document.createTextNode(titles[title]); //titles라는 오브젝트가 가지고 있는 title을 루핑 돌면서 가지고 오겠습니다.
        th.appendChild(txt);
        tr.appendChild(th);
    }
    document.getElementById('title').append(tr); //title (id값)?

}
