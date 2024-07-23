const addWish = document.getElementById("addWish");
const wishResult = document.getElementById("wishResult");


//Arrow Funtion
// () -> {}
addWish.addEventListener("click", ()=>{
    let id = addWish.getAttribute("data-product-id")
    fetch("./addWish?product_num="+id, {
         method:"GET"
     })
     .then((res)=>{return res.text()})
     .then((res)=>{
        if(res > 0){
            let check = confirm("go to the wishList?")
            if(check){
                location.href="./wishList";
            }
        }else{
            alert("넌 실패했다.")
        }
     })
     .catch(()=>{
        alert("오류 발생!!");
     })
})
