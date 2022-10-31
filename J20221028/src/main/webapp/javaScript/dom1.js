//dom1
//DOM을 활용해서 페이지 만들기

document.addEventListener('DOMContentLoaded', function(){ //domc 모두 다운로드 받은 후 아래 함수를 실행하겠습니다.
	let show = document.getElementById('show');
	let form = document.createElement('form'); //태그 생성
//id.
	let txt = document.createTextNode('ID:'); //ID라는 텍스트 노드 생성
	let input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('id', 'id');
	let br = document.createElement('br'); 
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
//name
	txt = document.createTextNode('Name: ');
	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('id', 'name');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);
//phone
	txt = document.createTextNode('Phone: ');
	input = document.createElement('input');
	input.setAttribute('type', 'text');
	input.setAttribute('id', 'phone');
	br = document.createElement('br');
	form.appendChild(txt);
	form.appendChild(input);
	form.appendChild(br);
	show.appendChild(form);	
//전송
	input = document.createElement('input');
	input.setAttribute('type', 'submit');
	input.setAttribute('value', '전송');
	form.appendChild(input);
	show.appendChild(form);
	
	document.querySelector('input[type="submit"]').style.background ='yellow';
	
	
})