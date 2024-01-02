    function saveboard(){
    var d = document.insert;
    console.log(d.title.value);
        if(d.title.value==""){
            alert("제목을 입력해주세요.");
            d.title.focus();
            return;
        }else if(d.writer.value==""){
            alert("이름을 입력해주세요.");
            d.writer.focus();
            return;
        }else if(d.content.value==""){
            alert("내용을 입력해주세요.");
            d.content.focus();
            return;
        }else{
          d.submit();
        }
    }

    function deleteboard(){
    let boardid = $('#boardid').val();
    console.log(boardid);
    let categoryy = $('#catee').val();
    console.log(categoryy);
    let dd="/board/"+categoryy+"/delete/"+boardid;

    console.log(dd);
        if(confirm("게시글을 삭제하시겠습니까?")){
            window.location.href=dd;
        }
    }

    function updateboard(){
        let f = document.update;
        let title=document.getElementById("title").value;
        let content=document.getElementById("content").value;

        if(title==""){
            alert("제목을 입력해주세요");
            title.focus();
            return;
        }else if(content==""){
            alert("내용을 입력해주세요");
            content.focus();
            return;
        }else{
            f.submit();
        }
    }