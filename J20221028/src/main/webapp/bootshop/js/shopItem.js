// shopItem.js파일

fetch('../ShopItemListServlet')
.then( result=>result.json())
.then( itemListShow)
.catch( err => console.error(err));

function itemListShow(result) {
    console.log(result);
    result.forEach(item =>{  //result 건수 만큼 호출.
        makeItemDiv(item); 

    });

}

function makeItemDiv(item = {}){ //상품 정보가 가지고 있는 것은 오브젝트 타입. item이가지고있는 것들 중에서 itemName이라는 속성을 사용해야 '예가체프'를 가지고 올수있음.
    //let div1 = document.createElement('div');
    //div1.classList = 'col' //클래스 속성을 컬렉션 타입으로 만들어주겠습니다.
    //div1.classList = 'mb-5'

    //let div2 = document.createElement('div');
    //div2.classList = ''; //이렇게 만들면 복잡해짐.....

    let template = document.querySelector('#template>div');
    let good = template.cloneNode(true); // good은 위의 template이랑 똑같은 정보를 가지고 있음. cloneNode
    good.querySelector('h5').textContent = item.itemName;
    good.querySelector('img.card-img-top').src = '../images/' + item.image; //
    good.querySelector('span.text-muted').textContent = item.originPrice ;
    good.querySelector('span.text-muted').nextSibling.textContent = ' '+item.salePrice;// nextSibling >> 정해진 태그의 동생 요소를 찾겠습니다.(다음 노드)// perviousSibling >> 형님 요소

    good.querySelector('a.btn').addEventListener('click', clickFunc);

    function clickFunc(){
        console.log('담기');
        let zero = document.querySelector('span.badge').textContent;
        console.log(zero);
        document.querySelector('span.badge').textContent = parseInt(zero) + 1;
    }
    
    //별점 
    //정수값 받는 변수, 실수값 받는 변수 두개 선언
    let review = item.likeIt; // ex) 4.5
    let a = Math.floor(review); //버림 => 4 fill
    let b = review - a; // 0 or 0.5
        for(let i=0; i<a; i++){
            let div = document.createElement('div');
            div.className = 'bi-star-fill'; //fill 지우면 빈별.
            // div.setAttribute('class', 'bi-star-fill');
            good.querySelector('div.d-flex').append(div);
        }
        if(b){
            let div = document.createElement('div');
            div.className = 'bi-star-half';
            // div.setAttribute('class', 'bi-star-fill');
            good.querySelector('div.d-flex').append(div);
        }

    good.querySelector('div.d-flex').append();

    // 상품목록에 붙어야 될 컨텐츠가 보여질 위치.
    let parent = document.querySelector('section.py-5>div>div');
    parent.append(good);

    console.log(good);

}