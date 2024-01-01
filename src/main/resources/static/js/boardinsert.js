    function saveboard(){
    console.log(insert.title.value);
        if(insert.title.value==""){
            alert("제목을 입력해주세요.");
            insert.title.focus();
            return;
        }else if(insert.writer.value==""){
            alert("이름을 입력해주세요.");
            insert.writer.focus();
            return;
        }else if(insert.content.value==""){
            alert("내용을 입력해주세요.");
            insert.content.focus();
            return;
        }else{
          insert.submit();
        }
    }

    function deleteboard(){
    let boardid = $('#boardid').val();
    console.log(boardid);
    let categoryy = $('#catee').val();
    console.log(categoryy);
//    localhost:8008/board/categoryy/delete/boardid
    let dd="/board/"+categoryy+"/delete/"+boardid;

    console.log(dd);
        if(confirm("게시글을 삭제하시겠습니까?")){
            window.location.href=dd;
        }
    }