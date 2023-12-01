<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<jsp:include page="/common/views/nav.jsp" />

<html>
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>ChunJae-Study</title>
    <link rel="icon" type="image/x-icon" href="${pageContext.request.contextPath}/common/image/로고.png" />
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/common/css/style.css?ver=1" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/membership/css/join.css?ver=1" rel="stylesheet">
    <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
</head>
<body>
<div class="wrapper fadeInDown">
    <div id="formContent">
        <form name="frm1" id="frm1" action="${pageContext.request.contextPath}/studentjoin.do" method="post" onsubmit="return joinCheck(this)">
        <label class="fadeIn third"><h2 class="active">학생 회원가입</h2></label>
            <input type="text" id="login" class="fadeIn second" name="studentId" placeholder="아이디" autofocus required >
            <input type="button" class="fadeIn second" value="아이디 중복 확인"  onclick="idCheck()" >
            <input type="hidden" name="idck" id="idck" value="no">
            <input type="password" id="studentPassword" class="fadeIn third" name="studentPassword" placeholder="비밀번호" autocomplete="off" required>
            <input type="password" id="studentPassword2" class="fadeIn third" name="studentPassword2" placeholder="비밀번호 확인" autocomplete="off" required>
            <input type="text" id="name" class="fadeIn third" name="studentName" placeholder="이름" autocomplete="off" required>
            <input type="submit" class="submit-button" value="회원가입">
            <input type="reset" class="fadeIn fourth" value="취소">
        </form>
    </div>
</div>

<script>
    $(document).ready(function(){
        $("#login").keyup(function(){
            $("#idck").val("no");
            if($(this).val()!=""){
                $("#msg").html("<strong>아이디 입력중입니다.</strong>");
                $("#login").focus();
            } else {
                $("#msg").html("아직 아이디 중복 체크를 하지 않으셨습니다.");
            }
        });
    });
    function idCheck(){

        var studentId = document.getElementById('login').value;

        if(studentId =="") {
            alert("아이디를 입력하지 않았습니다.");
            return;
        }
        var params = { studentId : studentId }

        $.ajax({
            url:"${pageContext.request.contextPath}/IdCheck.do",
            type:"post",
            dataType:"json",
            data:params,
            success:function(data){
                var idPass = data.result
                if(idPass == false){
                    idck = "no";
                    $("#idck").val("no");
                    $("#studentId").focus();
                    alert("기존에 사용되고 있는 아이디입니다. 다시 입력하시기 바랍니다.")
                } else if(idPass == true){
                    $("#idck").val("yes");
                    alert("사용 가능한 아이디입니다.")
                    idck = "yes";
                } else {
                    alert("아이디가 확인되지 않았습니다. 다시 시도하시기 바랍니다.")
                }
            }
        });
    }
</script>
<script>
    function joinCheck(f){
        if(f.studentPassword.value!=f.studentPassword2.value){
            alert("비밀번호와 비밀번호 확인이 서로 다릅니다.");
            f.studentPassword.focus();
            return false;
        }
         if(f.idck.value!="yes"){
            alert("아이디 중복 체크를 하지 않으셨습니다.");
            return false;}
    }
</script>
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

<jsp:include page="/common/views/footer.jsp" />
</body>
</html>
