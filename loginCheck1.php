
<?php

$host = 'localhost';
$user = 'kwang';
$pw = '1234';
$dbName = 'test';
$con = new mysqli($host, $user, $pw, $dbName);

$id = $_POST['id']; // 아이디
$pw = $_POST['pw']; // 패스워드

$query = "select * from member where member_id='$id' and member_pw='$pw'";

$result = mysqli_query($con, $query);
$row = mysqli_fetch_array($result);

$id1 = $row['member_id'];
$pw1 = $row['member_pw'];
$grade1 = $row['member_grade'];

$myObj = new stdClass();
$myObj->id=$id1;
$myObj->pw=$pw1;
$myObj->grade=$grade1;
if($id==$row['member_id'] && $pw==$row['member_pw']){ // id와 pw가 맞다면 login

    $myJSON=json_encode($myObj);
	echo $myJSON;

}else{ 


}

?>