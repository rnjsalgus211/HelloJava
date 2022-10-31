/**
 * dom3.js 
 */

document.addEventListener('DOMContentLoaded', function(){
	
	document.querySelector('button').addEventListener('click', function(){
		//아이디 조회해서 화면에서 삭제.
		let trs = document.querySelectorAll('table tr');
		let id = document.getElementById('id').value
		console.log(this);
		for(let i=0; i<trs.length; i++){
			if(trs[i].children[0].textContent == id){
				console.log(trs[i].children[0].textContent);
				trs[i].remove();
			}
		}
	});
	
	let tableObject = { //오브젝트. 객체를 가만히 놔두는걸로는 아무 기능을 할수 X
	id: 'hong', //속성 값을 읽으려면 this.id
	titles: ["아이디", "이름", "이메일", "삭제"],
	data: [{id: 'user1', name: '홍길동', email: 'hong@email'},
		   {id: 'user2', name: '성춘향', email: 'sung@email'},
	       {id: 'user3', name: '박항서', email: 'park@email'}],
	addData: function(row) {
		this.data.push(row)
	},
	makeTable: function() {
		let table = document.createElement('table');
		let thead = this.makeHead();
		let tbody = this.makeBody();
		table.append(thead, tbody); // append는 매개값 여러개 받을수있음. (appendChild는 매개값 1개.)
		return table;
	},
	
	makeHead: function(){
		let thead = document.createElement('thead');
		let tr =document.createElement('tr');
		this.titles.forEach(function(title){
			let td = document.createElement('th');
			let txt = document.createTextNode(title); 
			td.append(txt);
			tr.append(td);
		})
		thead.append(tr);
		return thead;
		
	},
	makeBody: function() {
		let tbody = document.createElement('tbody');
		this.data.forEach(val => { //this가 가지고 있는 data 배열의 갯수 만큼 반복하겠습니다.
			let tr = document.createElement('tr');
			tbody.append(tr);
			for (let field in val) {
				let td = document.createElement('td');
				let txt = document.createTextNode(val[field]);
				td.append(txt);
				tr.append(td);
				
			}
			
			//삭제버튼 클릭하면 한건 삭제.	
			let td = document.createElement('td');
			let btn = document.createElement('button');
			let txt = document.createTextNode('삭제');
			btn.addEventListener('click', function(){
				this.parentElement.parentElement.remove();
			})
			td.append(btn);
			btn.append(txt);
			tr.append(td);

			});
		return tbody;
	},
	init: function(){ //메소드?
		//let id = 'kim';
		//console.log('init call.' + id); //그냥 id라고 하면 변수를 찾게됨. (func안에 선언된게 변수.)
		document.getElementsByTagName('body')[0].append(this.makeTable());
		 
		}
	}
	//데이터 추가..
	tableObject.addData({id: 'user4', name: '전완근', email: 'Jeon@email'});
	tableObject.init(); //호출

}) //end of DOMContentLoaded.

