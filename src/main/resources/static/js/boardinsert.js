    function saveboard(){
    console.log(insert.title.value);
        if(insert.title.value==""){
            alert("제목을 입력해주세요.");
            return false;
        }else if(insert.writer.value==""){
            alert("이름을 입력해주세요.");
            return false;
        }else if(insert.content.value==""){
            alert("내용을 입력해주세요.");
            return false;
        }else{
          insert.submit();
        }
    }