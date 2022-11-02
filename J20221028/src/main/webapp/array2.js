fetch('./MemberListServlet') //method따로 정의해줘도됨. 없으면 기본값.
    .then(result => result.json())
    .then(listShow)
    .catch(error => console.error(error));

function listShow(data = []){ //배열타입.
   data.forEach(member => {
    console.log(member.respons);
    if(member.respons == 'admin')
        console.log(member);
   })

   //권한 user인 사람들만 userGroup으로 담기.
   let userGroup = [];
   //foreach사용
   data.forEach(member =>{
        if(member.respons =='user')
        userGroup.push(member);
   })
   console.log(userGroup);
   //filter를 사용하면.
   userGroup = data.filter(member => member.respons =='user');
   console.log(userGroup);
}