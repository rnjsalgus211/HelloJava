//dom2.js


//여기서의 document는 index.html의 document영역을 가리킴.
document.addEventListener('DOMContentLoaded', domLoadedFunc); //도큐먼트 객체에 이벤트를 등록할 때 사용하는 메소드.
						//DOMContentLoaded이벤트 발생하면 domLoadedFunc함수 실행하세요.
function domLoadedFunc(){ 
	let data = `[{"id":1,"first_name":"Brennan","last_name":"McMorland","email":"bmcmorland0@hostgator.com","gender":"Female","salary":4416},
				{"id":2,"first_name":"Gregoire","last_name":"Rose","email":"grose1@bloomberg.com","gender":"Male","salary":7308},
				{"id":3,"first_name":"Barde","last_name":"Jindrich","email":"bjindrich2@tmall.com","gender":"Male","salary":2510},
				{"id":4,"first_name":"Vergil","last_name":"Earle","email":"vearle3@utexas.edu","gender":"Male","salary":7083}]`;
	let obj = {}; //자바스크립트에서 객체를 만들 때 중괄호를 사용.				
	let result = JSON.parse(data); // json형태 데이터 => 자바스크립트에서 사용하는 object타입으로 바꿔주겠습니다.(파싱)
	console.log(result); //result는 배열형태로 산출
	
	console.log(result[0].first_name);
	console.log(result[1].email);
	
	for(let i=0; i<result.length; i++){
		console.log(`firstName: ${result[i].first_name}, lastName: ${result[i]['last_name']}`);	
	}
	
	for(let obj of result){ //배열에 있는 크기 만큼 반복하겠습니다. for of (확장for문)
		console.log(`id: ${obj.id}, email: ${obj['email']}`);
	}
	console.clear(); //위에 출력했던 콘솔 정보들을 지우겠습니다.
	
	//배열일 경우에는Array.forEach() 값, 인덱스, 배열
	result.forEach(function(value, index){  //매개값으로 함수를 받아옴
		//if (value.salary > 5000 ) //value가 가지고 있는 salary 속성
		if(index < 2) //index가 2보다 적은 값만 출력해보겠습니다.
				console.log(value, index);
	});

	
	//확장for
	//table
	let table = document.createElement('table');
	let show = document.getElementById('show');
	show.appendChild(table);
	


	
	//thead
	let thead = document.createElement('thead');
	let tr = document.createElement('tr');
	let titles = ['아이디', '이름', '이메일', '성별', '급여', '삭제'];
	for (let title of titles){
		let idTag = document.createElement('th');
		let idTxt = document.createTextNode(title); //<th>아이디</th>
		idTag.appendChild(idTxt);
		tr.appendChild(idTag);
	}
	
	//전체선택 버튼.
	//<th><input type="checkbox"></th>
	let th = document.createElement('th');
	let checkbox = document.createElement('input');
	checkbox.setAttribute('type', 'checkbox');
	checkbox.addEventListener('change', function(){
			let cks = document.querySelectorAll('#show input[type="checkbox"]'); // 꺽새(>)는 자식요소 표시, #show input과 같이 공백이 있으면 하위요소 중 1개 선택해줌. (자식요소 다 안적어도 됨)
			cks.forEach(function(check){ //첫번째 매개변수 = 값.
			check.checked = checkbox.checked;
		});
	})
	th.appendChild(checkbox);
	tr.appendChild(th);
	
	thead.appendChild(tr);
	table.appendChild(thead);
	


	//tbody
	let tbody = document.createElement('tbody');
	table.appendChild(tbody);	
	let fields = ['id', 'first_name', 'email', 'gender', 'salary'];	
	
	for(let obj of result){
		let tr = makeTr(obj); //makeTr함수 호출 시 tr을 하나 생성.
		tbody.appendChild(tr);
		
	} // end of for(let obj of result)
	
	
	
///////////////////////////////////// event ////////////////////////////////////
	//추가버튼에 이벤트 등록.
	document.querySelector('button[type="button"]').addEventListener('click', function(){
		console.log('추가버튼')
		let id = document.getElementById('id').value;
		let fn = document.getElementById('fname').value;
		let email = document.getElementById('email').value;
		let salary = document.getElementById('salary').value;
		let gender = document.getElementById('gender').value;
		let newRow = {
			id: id,
			first_name: fn,
			email: email,
			salary: salary,
			gender: gender
		}
		document.querySelector('#show>table>tbody').appendChild(makeTr(newRow)); //id값이 show인 태그 밑에 테이블 밑 티바디 선택하겠다.
		
	});
	
	//수정버튼에 이벤트 등록. id로 가져올수도 있음 
	document.querySelectorAll('button[type=button]')[1].addEventListener('click', updateFunc);
		
	function updateFunc() {
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		console.log(trs);
		for(let i=0; i<trs.length; i++){
			if(trs[i].children[0].textContent==document.getElementById('id').value){
			trs[i].children[1].textContent = document.getElementById('fname').value; //tr하나 가져온것. (id값은 children[0])
			trs[i].children[2].textContent = document.getElementById('email').value;
			trs[i].children[3].textContent = document.getElementById('gender').value;
			trs[i].children[4].textContent = document.getElementById('salary').value;
			}
			
		}
	}
		
		
	//선택삭제 이벤트 등록.
	document.querySelectorAll('button[type=button]')[2].addEventListener('click', removeFunc);
	
	function removeFunc(){
		let trs = document.querySelectorAll('#show>table>tbody>tr');
		for(let i=0; i<trs.length; i++){
		if(trs[i].children[6].firstElementChild.checked == true ){
			console.log("선택삭제버튼")
			trs[i].remove();
		}
		}
	}
	
	
	
	
	//////////////////////////////////// function ////////////////////////////////////
	function makeTr(row){
		//데이터 건수만큼 반복.
		let tr = document.createElement('tr');
		// tr.addEventListener('mouseover', showDetailFunc);
		
		
		// tr.addEventListener('mouseout', function() {
		// 	this.style.backgroundColor = null;
		
		// });

		
		for (let field of fields){
			//항목만큼 반복.
			let td = document.createElement('td');
			let txt = document.createTextNode(row[field]); //obj안에 field를 가지고 와서 각각의 텍스트 노드 생성.
			td.appendChild(txt);
			tr.appendChild(td);
		}
		
		
		//삭제버튼달기. <td><button>삭제</button></td>
		let td = document.createElement('td');
		let btn = document.createElement('button');
		btn.addEventListener('click', function(){
			console.log(this);
			this.parentElement.parentElement.remove();
		});
		let txt = document.createTextNode('삭제');
		td.appendChild(btn);
		btn.appendChild(txt);
		tr.appendChild(td);
		
		//체크박스 생성.
		td = document.createElement('td');
		td.style.textAlign = 'center';
		let checkbox = document.createElement('input');
		checkbox.setAttribute("type", "checkbox");
		// checkbox.addEventListener('change', function(){
		// 	//console.log(this.checked); //체크하면 true, 풀면 false.
	
		// 	});
			
		
		td.appendChild(checkbox);
		tr.appendChild(td);
		
		
		return tr;
		
		
		
	}// end of makeTr()
	
	
	function showDetailFunc() {
			//console.log(this); //tr을 가리킴.
			this.style.backgroundColor = 'pink'; 
			//console.log(this.children[2].textContent); //이름을 가지고 있는 td태그를 보여줌. (두번째 자식)
			document.getElementById('id').value = this.children[0].textContent;
			document.getElementById('fname').value = this.children[1].textContent;
			document.getElementById('email').value = this.children[2].textContent;
			document.getElementById('gender').value = this.children[3].textContent;
			document.getElementById('salary').value = this.children[4].textContent;
		}
	
	
	
}// end of domLoadedFunc()