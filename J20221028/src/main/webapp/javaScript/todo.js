//todo.js  => ToDoList.html

document.addEventListener("DOMContentLoaded", function(){
    let ulTag = document.createElement('ul');
    let liTag = document.createElement('li');
    
    let itemList = [];
    let addBtn = document.querySelector('#add');
    
    addBtn.addEventListener('click', addList);
    
    function addList(){
        let item = document.querySelector('#item').value;
        if(item !=''){
            itemList.push(item);
            document.querySelector('#item').value='';
            document.querySelector('#item').focus();
            console.log(itemList);
            showList(itemList);
        }
    }
        let s = new Set(itemList);
        let newarr = Array.from(s)
        console.log(newarr);

        function showList(){
            document.querySelectorAll("#itemList>ul>li").forEach(li =>{
                li.remove();
            })

            for(let list of itemList){
            let liTag = document.createElement('li');
            let btnTag = document.createElement('button');
            btnTag.setAttribute('id', 'close')
            let txt = document.createTextNode('X');
            btnTag.append(txt);
            liTag.append(list);
            liTag.append(btnTag);
            ulTag.append(liTag);
        }
            document.querySelector('#itemList').append(ulTag);

            document.getElementById('close').addEventListener('click', removeFunc)

            function removeFunc(){
                for(let li of itemList){
                    li.remove();
                }
            }


        //     let remove = document.getElementsById('close');
        //     for(let i=0; i<remove.length; i++){
        //         remove[i].addEventListener('click', removeList)
        //     }
        // }
        // function removeList(){
        //     let id = this.getAttribute('id')
        //     itemList.splice(id, 1)
        //     showList();
        }


})



