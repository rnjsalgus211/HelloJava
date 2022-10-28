/**
 *  object2.js
 */

document.addEventListener('DOMContentLoaded', function() { //콜백함수 , DOMContentLoaded: 컨텐츠를 다 읽어 들인 다음에 다음이벤트>(function()실행). 
	//document.getElementById('show').innerHTML = '<p>Hello, World</p>';
	
	let data =`[{"id":1,"first_name":"Brennan","last_name":"McMorland","email":"bmcmorland0@hostgator.com","gender":"Polygender","salary":4416},
{"id":2,"first_name":"Gregoire","last_name":"Rose","email":"grose1@bloomberg.com","gender":"Male","salary":7308},
{"id":3,"first_name":"Barde","last_name":"Jindrich","email":"bjindrich2@tmall.com","gender":"Male","salary":2510},
{"id":4,"first_name":"Vergil","last_name":"Earle","email":"vearle3@utexas.edu","gender":"Male","salary":7083},
{"id":5,"first_name":"Devondra","last_name":"Cockram","email":"dcockram4@t-online.de","gender":"Female","salary":9363},
{"id":6,"first_name":"Emelen","last_name":"Callinan","email":"ecallinan5@gmpg.org","gender":"Male","salary":3468},
{"id":7,"first_name":"Patin","last_name":"Fearnside","email":"pfearnside6@skyrock.com","gender":"Male","salary":2198},
{"id":8,"first_name":"Mada","last_name":"Ward","email":"mward7@mtv.com","gender":"Female","salary":2771},
{"id":9,"first_name":"Wendi","last_name":"Bysshe","email":"wbysshe8@eventbrite.com","gender":"Female","salary":7220},
{"id":10,"first_name":"Valdemar","last_name":"Longhorn","email":"vlonghorn9@state.gov","gender":"Male","salary":8231}]`;

//json타입 데이터 => javascript오브젝트로 변환해주는 기능이
let result = JSON.parse(data); 
console.log(result);

// java => for (String str : personList) {} 와 같은 실행문 (for of)
// <ul><li>object</li><li>object</li></ul>
// <div id="show"></div>에다가 ul태그를 붙이기.

const fields = ['id', 'first_name', 'email', 'salary'];


let ulTag = document.createElement('table');

for (row of result){
	ulTag.appendChild(makeTr(row));	
}

document.getElementById('show').appendChild(ulTag);

function makeTr(obj){
	let tdTag = document.createElement('td');
	let str = '';
	
	for(field of fields){
		str +=`[ ${field}: ${obj[field]} ]`;
		
	}
	let txt = document.createTextNode(str);
	tdTag.appendChild(txt);
	
}
return tdTag;


function makeList(obj){
	let liTag = document.createElement('li');
	let str ='';
	for(field of fields){
		str +=`[ ${field}: ${obj[field]} ]`;
		
	}
	
	let txt = document.createTextNode(str);
	liTag.appendChild(txt);
	
	return liTag;
}


}); 














