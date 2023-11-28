    function join() {
    var form = document.joinForm;

    if (!form.userID.value) {
    alert("아이디를 입력해주세요.");
    form.userID.focus();
    return;
}
    if (form.userID.value.length < 4 || form.userID.value.length > 16) {
    alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
    form.userID.focus();
    return;
}
    if (!form.userPW.value) {
    alert("비밀번호를 입력해주세요.");
    form.userPW.focus();
    return;
}

    // 비밀번호 유효성 검사 로직 추가
    var passwordRegex = /^(?=.*[a-zA-Z])(?=.*[0-9]).{8,25}$/;
    if (!passwordRegex.test(form.userPW.value)) {
    alert("비밀번호는 8자리 이상이어야 하며, 영문/숫자 모두 포함해야 합니다.");
    form.userPW.focus();
    return;
}

    if (form.userPW.value !== form.userPW2.value) {
    alert("비밀번호를 확인해주세요.");
    form.userPW2.focus();
    return;
}

    if (!form.name.value) {
    alert("이름을 입력해주세요.");
    form.name.focus();
    return;
}


    form.submit();
}

    function CheckDup() {
    var form = document.joinForm;

    if (!form.userID.value) {
    alert("아이디를 입력해주세요.");
    form.userID.focus();
    return;
}

    $.ajax({
    url:"/member/checkId.do",		// servlet
    type: "post",
    datatype:"text",
    data: {"userId" : form.userID.value},
    success:function(data){

    if(data === 'success'){
    $('input[name=checkID]').val("ok");
    alert("사용 가능한 아이디입니다.")
    $('#message').text('사용할 수 있는 ID입니다.')
    $('#message').css('color','green')

}
    else {
    alert("사용 불가능한 아이디입니다.")
    $('#message').text('이미 사용 중인 아이디입니다.')
    $('#message').css('color','red')

}
},
    error:function(){
    alert("error");
}
})
}
