/**
 * ajaxjquery.js
 */
console.log('ajaxJquery');

$(document).ready(function(){ //$(document).ready부분 없어도 똑같음. $(function(){})
	//도서목록을 가져와서 json타입으로 화면에 출력.
	$.ajax({
		url: '',
		method: 'get',
		success: function(result) { //에러없으면 보여주는 부분.
			console.log(result);
		},
		error: function(error){ //에러 발생하면 보여주는 부분.
			console.log(error);
		}
	});
}); 