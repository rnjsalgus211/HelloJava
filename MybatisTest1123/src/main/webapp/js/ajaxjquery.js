/**
 *  ajaxjquery.js
 */
console.log('ajaxjquery')

$(function() {
	// 도서목록 json 타입 -> 화면에 출력.
	$.ajax({
		url: 'ajaxBookList.do',
		method: 'get', 
		dataType: 'json',
		success: function(result) {
			console.log(result); //[{}, {}, {}] 배열 형태로 데이터가 여러건 들어있음.
			$.each(result, function(prop, item){
				$('#list').append(makeTr(item));
			})
		},
		error: function(error) {
			console.log(error);
		}
	});
	
	//등록이벤트
	$('#addBtn').on('click', addBookFnc);
}); 

function addBookFnc(){
	let code = $('input[name="bCode"]').val(); //name이 bCode인 애의 밸류값
	let title = $('input[name="bTitle"]').val();
	let author = $('input[name="bAuthor"]').val();
	let press = $('input[name="bPress"]').val();
	let price = $('input[name="bPrice"]').val();
	
	
	console.log($('form[name="myfrm"]').serialize()); //myfrm하위 요소를 키 , 밸류 형식으로 값을 만들어줌..? 밑에 $.ajax에서 data{bCode~~~~} 부분 보면됨.
	
	$.ajax({
		url: 'ajaxBookAdd.do',
		method: 'post',
		contentType: 'application/x-www-form-urlencoded; charset=UTF-8',
		//data: {bCode: code, bTitle: title, bAuthor: author, bPress: press, bPrice: price}, //data가 서버에서 받는 값. bCode, bTitle...이 parameter값이기때문에 controller를 통해 전달.
		data: $('form[name="myfrm"]').serialize(),
		dataType: 'json',
		success: function(result) {
			console.log(result); 
			$('#list').append(makeTr(result));
			init(); //값 넣기 성공하면 초기화.
			},
			
		error: function(error) {console.log(error)}
	});
}

function init(){
	$('input[name="bCode"]').val("");
	$('input[name="bTitle"]').val("");
	$('input[name="bAuthor"]').val("");
	$('input[name="bPress"]').val("");
	$('input[name="bPrice"]').val("");
}

function makeTr(book = {bookCode:"", bookTitle:"", bookAuthor:"", bookPress:"", bookPrice:""}){ //데이터 한건을 받아와서 Tr을 생성. 매개값으로 객체.
	return $('<tr />').append(
		   $('<td />').text(book.bookCode),
		   $('<td />').text(book.bookTitle),
		   $('<td />').text(book.bookAuthor),
		   $('<td />').text(book.bookPress),
		   $('<td />').text(book.bookPrice),
		   $('<td />').append($('<button />').text('수정').on('click', book, modifyFrm)),
		   $('<td />').append($('<button />').text('삭제').on('click', book, delFrm))

		
	).on('mouseover', book, showInfo)
	
		.on('click', book, detailInfo)
		


}

function detailInfo(e){
	$('#id01').css('display', 'block')
		console.log(e.data.bookCode);
		$('.container>input[name="bCode"]').val(e.data.bookCode);
		$('.container>input[name="bTitle"]').val(e.data.bookTitle);
		$('.container>input[name="bAuthor"]').val(e.data.bookAuthor);
		$('.container>input[name="bPress"]').val(e.data.bookPress);
		$('.container>input[name="bPrice"]').val(e.data.bookPrice);
		let btn = $(this);

		$('.container input[name="bCode"]').val($(this).children().eq(0).text());
		$('.container input[name="bTitle"]').val($(this).children().eq(1).text());
		$('.container input[name="bAuthor"]').val($(this).children().eq(2).text());
		$('.container input[name="bPress"]').val($(this).children().eq(3).text());
		$('.container input[name="bPrice"]').val($(this).children().eq(4).text());

		$('.container #changeBtn').click(function(){
			let code = $('.container input[name="bCode"]').val();
			let title = $('.container input[name="bTitle"]').val();
			let author = $('.container input[name="bAuthor"]').val();
			let press = $('.container input[name="bPress"]').val();
			let price = $('.container input[name="bPrice"]').val();
			
			let book = {
				bookCode: code,
				bookTitle: title,
				bookAuthor: author,
				bookPress: press,
				bookPrice: price
			};
		
			// 수정 컨트롤 호출.
			$.ajax({
				url: 'ajaxBookModify.do',
				method: 'post',
				contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
				data: book,
				success: function (result) {
					console.log(result)
					if (result == 'Success') {
						alert('수정완료');
						let newTr = makeTr(book);
						btn.replaceWith(newTr);
						document.getElementById('id01').style.display='none';
					} else if (result == 'Fail') {
						alert('처리건수가 없습니다.')
					}
				},
				error: function (error) {
					console.log(error)
				}
			});
		
		
		});
		$('#id01').css('display','block');
		
}

function showInfo(e){
	
	let code = e.data.bookCode; 
	let title = e.data.bookTitle; 
	let author = e.data.bookAuthor; 
	let press = e.data.bookPress;
	let price = e.data.bookPrice;
	
	//book 객체 만들기.
	let book = {bookCode:code, bookTitle:title, bookAuthor: author, bookPress:press, bookPrice:price};
	let btn = $(this);

	$.ajax({
		url: 'ajaxBookSelect.do',
		method: 'post',
		contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
		data: book,
		dataType: 'json',
		success: function(result) {
				 $('#content').children().eq(0).children().last().text(result.bookCode);
				 $('#content').children().eq(1).children().last().text(result.bookTitle);
				 $('#content').children().eq(2).children().last().text(result.bookAuthor);
	 			 $('#content').children().eq(3).children().last().text(result.bookPress);
	 			 $('#content').children().eq(4).children().last().text(result.bookPrice);
		},
		error: function(error) {console.log(error)}
	});

}



function delFrm(e){
	let code = e.data.bookCode; 
	let title = e.data.bookTitle; 
	let author = e.data.bookAuthor; 
	let press = e.data.bookPress;
	let price = e.data.bookPrice;
	
	// book 객체 만들기.
	let book = {bookCode:code, bookTitle:title, bookAuthor: author, bookPress:press, bookPrice:price};
	let btn = $(this);

	$.ajax({
		url: 'ajaxBookDelete.do',
		method: 'post',
		contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
		data: book,
		success: function(result) {
			console.log(result)
			if(result == 'Success') {
				btn.parentsUntil('#list').remove();
			} else if (result == 'Fail') {
				alert('처리건수가 없습니다.')
			}
		},
		error: function(error) {console.log(error)}
	});
}

function modifyFrm(e) { 
	console.log(e.data);
	localStorage.setItem('code', e.data.bookCode);
	localStorage.setItem('title', e.data.bookTitle);
	localStorage.setItem('author', e.data.bookAuthor);
	localStorage.setItem('press', e.data.bookPress);
	localStorage.setItem('price', e.data.bookPrice);
	
	let newTr = $('<tr />').append(
		$('<td />').text(e.data.bookCode),
		$('<td />').append($('<input />').val(e.data.bookTitle).on('change', function(){localStorage.setItem('title',$(this).val())})),
		$('<td />').append($('<input />').val(e.data.bookAuthor).on('change', function(){localStorage.setItem('author',$(this).val())})),
		$('<td />').append($('<input />').val(e.data.bookPress).on('change', function(){localStorage.setItem('press',$(this).val())})),
		$('<td />').append($('<input />').val(e.data.bookPrice).on('change', function(){localStorage.setItem('price',$(this).val())})),
		$('<td />').append($('<button />').text('변경').on('click', modifyData)) //이벤트 실행시 실행되는 콜백함수.
	);
	
	$(this).parentsUntil('#list').replaceWith(newTr); //$(this)가 버튼
	
	
	
}

function modifyData(e){

	let code = localStorage.getItem('code');
	let title = localStorage.getItem('title');
	let author = localStorage.getItem('author');
	let press = localStorage.getItem('press');
	let price = localStorage.getItem('price');
	
	let book = {bookCode:code, bookTitle:title, bookAuthor:author, bookPress:press, bookPrice:price}
	let btn = $(this); // 이벤트 안에서 $(this)는 이벤트를 받는 대상이었기 때문에 버튼요소가 맞는데,
				       //ajax안에서 $(this)는 값이 X
	//수정컨트롤.
	$.ajax({
		url: 'ajaxBookModify.do',
		method: 'post',
		contentType: 'application/x-www-form-urlencoded; chartset=UTF-8',
		data: book,
		success: function(result) {
			console.log(result)
			if(result == 'Success'){
			let newTr = makeTr(book);
			btn.parentsUntil('#list').replaceWith(newTr);
	
			}else if (result == 'Fail'){
				alert('처리건수가 없습니다.')
			}
		},
		error: function(error) {console.log(error)}
	});
	

	localStorage.removeItem('code');
	localStorage.removeItem('title');
	localStorage.removeItem('author');
	localStorage.removeItem('press');
	localStorage.removeItem('price');
}



