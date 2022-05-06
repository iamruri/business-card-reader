<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
   		<title>パスワード変更画面</title>
   		<link rel="stylesheet" type="text/css" href="css/main.css">
	</head>
	<body>
   		<div id="wrap">
    		<main>
     			<section>
     				<center><img src="imagehtml/logo.png" alt="ロゴ" width="300" height="68"></center>
      				<h3>パスワード変更</h3>
      				<form method="post">
      				   <p id="midashi">ID</p>
					   <p><input type="text" name="id" size="30" ></p>
				       <p id="midashi">メールアドレス</p>
					   <p><input type="text" name="email" size="30" ></p>
					   <p id="midashi">新しいパスワード</p>
					   <p><input type="text" name="newpw" size="30"></p>
					   <p id="midashi">パスワード確認</p>
					   <p><input type="text" name="newpw2" size="30" ></p>
					   <p>
	      			   	<input type="submit" value="登録" formaction="changepassout.jsp" class="button">
	  				   </p><br><br>
	  				</form>
     			</section>
    		</main>
   		</div>
  	</body>
</html>