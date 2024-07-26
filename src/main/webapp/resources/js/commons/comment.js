const commentContents = document.getElementById("commentContents");
const commentButton = document.getElementById("commentButton");
const commentClose = document.getElementById("commentClose");
const commentList = document.getElementById("commentList");
const openModal = document.getElementById("openModal");


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

let flag = true;  //true라면 댓글을 등록하는 거고, false라면 댓글을 수정하는것으로 인식
let board_num = 0;
// 댓글 수정 버튼 코드
commentList.addEventListener("click", (e)=>{
    if(e.target.classList.contains("ups")){
        flag = false;
        board_num = e.target.getAttribute("data-del-id");
        let c = e.target.getAttribute("data-update-con");
        c = document.getElementById(c).innerHTML;
        commentContents.value = c;
        commentButton.innerHTML = "수정";
    }
})

// 댓글 등록 버튼을 눌렀을 때 수정 버튼이 아니라 등록 버튼이 나오게 하는 코드
openModal.addEventListener("click", ()=>{
    flag = true;
    commentButton.innerHTML = "등록";
    commentContents.value = "";
})





// 댓글 추가와 수정을 같이 하는 코드
commentButton.addEventListener("click", ()=>{
    
    let contents = commentContents.value;

    if(contents==null || contents==""){
        alert("댓글을 입력하세요");
        return;
    }

    let url = "commentAdd";
    let param = "board_contents=" + contents + "&product_num=" + commentButton.getAttribute("data-id");
    
    if(!flag){
        url = "commentUpdate";
        param = "board_contents=" + contents + "&board_num=" + board_num;
    }

    console.log(url); 
    console.log(param); 

    commentClose.click();

    // fetch(url, {
    //     method:"POST",
    //     headers :{
    //     "Content-type" : "application/x-www-form-urlencoded"
    //     },
    //     body:param
    // })
    // .then(r=>r.text())
    // .then(r=>{
    //     r=r.trim();
    //     if(r>0){
    //         alert("댓글 추가 성공");
    //         getList(1);
    //     }else{
    //         alert("댓글 추가 실패");
    //     }
    // })

    commentContents.value="";
})