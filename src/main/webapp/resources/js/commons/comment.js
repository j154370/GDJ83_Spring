const commentContents = document.getElementById("commentContents");
const commentButton = document.getElementById("commentButton");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");


//함수 호출
getList(1);

// 리스트를 가져오는 코드
function getList(page){
    fetch("./commentList?product_num="+commentButton.getAttribute("data-id")+"&page="+page, {
        method:"GET"
    })
    .then(r=>r.text())
    .then(r=>commentList.innerHTML=r)
}

// 같은 화면 내에서 댓글의 페이징 처리 코드
commentList.addEventListener("click", (e)=>{
     if(e.target.classList.contains("pn")){
        let p = e.target.getAttribute("data-page-num");
        getList(p);
     }
})

// 댓글 삭제 코드 (자기것만 삭제 버튼 보이게 하는건 jsp에서 처리했음)
commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("del")){
        let id = e.target.getAttribute("data-del-id");
        fetch("./commentDelete",{
            method :"POST",
            headers :{
                "Content-type" : "application/x-www-form-urlencoded"
                },
            body:"board_num="+id
        })
        .then(r=>r.text())
        .then(r=>{
            r=r.trim();
            if(r>0){
                alert("삭제 성공!");
                getList(1);
            }else{
                alert("삭제 실패!!");
            }
        })
        
    }
})





// 댓글 추가 코드
commentButton.addEventListener("click", ()=>{
    commentClose.click();
    let contents = commentContents.value;


    fetch("./commentAdd", {
        method:"POST",
        headers :{
        "Content-type" : "application/x-www-form-urlencoded"
        },
        body:"board_contents="+contents+"&product_num="+commentButton.getAttribute("data-id")
    })
    .then(r=>r.text())
    .then(r=>{
        r=r.trim();
        if(r>0){
            alert("댓글 추가 성공");
            getList(1);
        }else{
            alert("댓글 추가 실패");
        }
    })

    commentContents.value="";
})