<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<?php

	$host = 'localhost';
	$user = 'kwang';
	$pw = '1234';
	$dbName = 'test';
	$mysqli = new mysqli($host, $user, $pw, $dbName);

	$data_id = $_POST['id'];
	$data_grade = $_POST['grade'];
    $data_grade1 = $_POST['grade1'];
    $data_gamok = $_POST['gamok'];
    $data_jumsu = $_POST['jumsu'];

    if($data_gamok=="hci"||$data_gamok=="c프로그래밍1"||$data_gamok=="파이선프로그래밍"||$data_gamok=="멀티미디어소프트웨어개론"||$data_gamok=="c++프로그래밍"||$data_gamok=="멀티미디어통신"||$data_gamok=="자료구조및알고리즘"||$data_gamok=="데이터베이스1"||$data_gamok=="영상처리"||$data_gamok=="멀티미디어프로그래밍"||$data_gamok=="자바웹프로그래밍"||$data_gamok=="게임수학"||$data_gamok=="취업과진로"||$data_gamok=="데이터베이스2"||$data_gamok=="3d모델링"||$data_gamok=="모바일컴퓨팅1"||$data_gamok=="데이터베이스1"||$data_gamok=="게임프로그래밍1"||$data_gamok=="컴퓨터그래픽스1"||$data_gamok=="운영체제"||$data_gamok=="인공지능"||$data_gamok=="현장실습"||$data_gamok=="미디어소프트웨어취창업특강"||$data_gamok=="졸업작품"){
        $jungong=1;
    }
    else{
        $jungong=0;
    }
	$sql = "insert into data (
        data_id,
        data_grade,
        data_grade1,
        data_gamok,
        data_jumsu,
        jungong
	)";
	
	$sql = $sql. "values (
			'$data_id',
			'$data_grade',
            '$data_grade1',
            '$data_gamok',
            '$data_jumsu',
            '$jungong'
	)";

	if($mysqli->query($sql)){ 
	  echo '<script>alert("success inserting")</script>'; 
	}else{ 
	  echo '<script>alert("fail to insert sql")</script>';
	}

	mysqli_close($mysqli);
  
?>

<script>
	// location.href = "data_input.html";
</script>
</html>