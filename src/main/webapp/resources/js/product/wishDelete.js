const wishDelete = document.getElementsByClassName("wishDelete");
const all = document.getElementById("all");
const ch = document.getElementsByClassName("ch");
const deleteAll = document.getElementById("deleteAll");
let count = 0;

// header check box 클릭시 body check box에 클릭이 되는 코드
all.addEventListener("click", ()=>{
    
    for(let c of ch){
        c.checked=all.checked;
        count = 0;
    }
})

// body check box클릭시 header check box가 클릭되는 코드
// (count를 안쓰고 flag와 for문을 돌려서 하는 코드는 선생님 git 참고) <- 이게 더 좋아보임
for(let c of ch){
    c.addEventListener("click", ()=>{
        
        if(c.checked==true){
            count++;
            if(count==ch.length){
                all.checked=true;
            }
        }else{
            count--;
            if(count!=ch.length){
                all.checked=false;
            }
        }
        

    })
   
}

// 삭제 버튼 누르면 wishlist가 제거되는 코드
for(let w of wishDelete){
    w.addEventListener("click", ()=>{
        let id = w.getAttribute("data-wish-id");
        //server로 삭제 요청
        fetch("./deleteWishList?product_num="+id, {
            method:"GET"
        })
        .then((r)=>{return r.text()})
        .then((r)=>{
            r=r.trim();
            if(r>0){
                w.parentNode.parentNode.remove();
            }else{
                alert("삭제 실패");
            }
        }).catch(()=>{alert("오류 발생!!")});

    })
}

//전체 삭제 버튼 누르면 체크된 wishlist가 제거되는 코드
deleteAll.addEventListener("click", ()=>{
    const e = [];
    let url = "./deleteWishList?";
    for(let c of ch){
        if(c.checked==true){
           let id = c.getAttribute("data-wish-id");
            url = url + "product_num=" + id +"&";
            e.push(c);
        }
    }
    url = url.substring(0, url.length-1);
    fetch(url, {
        method:"GET"
    })
    .then(r=>r.text())
    .then((r)=>{
        r = r.trim();
            if(r>0){
                for(let ele of e){
                   ele.parentNode.parentNode.remove();
                }
            }else{
                alert("삭제 실패!!");
            } 
        }       
    ).catch(()=>{alert("오류 발생!!")});
})
