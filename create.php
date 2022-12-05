<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<?php

	$host = 'localhost';
	$user = 'kwang';
	$pw = '1234';
	$dbName = 'test';
	$mysqli = new mysqli($host, $user, $pw, $dbName);

	$member_id = $_POST['id'];
	$member_pw = $_POST['pw'];
    $member_grade = $_POST['grade'];

	$sql = "insert into member (
			member_id,
			member_pw,
            member_grade
	)";
	
	$sql = $sql. "values (
			'$member_id',
			'$member_pw',
            '$member_grade'
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