const wishDelete = document.getElementsByClassName("wishDelete");

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