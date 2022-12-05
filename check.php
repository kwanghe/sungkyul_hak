
<?php

$host = 'localhost';
$user = 'kwang';
$pw = '1234';
$dbName = 'test';

$id = $_POST['id']; // 아이디
$grade = $_POST['grade']; // 학번

$pil = 171;  //전공 학점
$nowhak = 0; //전공 필수 현재 학점
$nownhak=0;  //전공 선택 현재 학점
$pil1=15;
$pil2=12;
$pil3=24;
$pil4=6;
$nowhak1 = 0;
$nowhak2 = 0;
$nowhak3 = 0;
$nowhak4 = 0;

$npil1=24;
$npil2=18;
$npil3=15;
$npil4=18;
$nownhak1 = 0;
$nownhak2 = 0;
$nownhak3 = 0;
$nownhak4 = 0;

$result_jun = 0;
$result_juns = 0;

$jun_count1 = 0;
$jun_count2 = 0;
$jun_count3 = 0;
$jun_count4 = 0;
$all_count1 = 0;
$all_count2 = 0;
$all_count3 = 0;
$all_count4 = 0;

$con=mysqli_connect($host, $user, $pw, $dbName);
// 기본 클라이언트 문자 집합 설정하기 
mysqli_set_charset($con,"utf8"); 
// 쿼리문 실행, 결과를 res에 저장 
$res = mysqli_query($con, "select * from data where data_id='$id'"); 
// 결과를 배열로 변환하기 위한 변수 정의
$result = array(); 
// 쿼리문의 결과(res)를 배열형식으로 변환(result) 
while($row = mysqli_fetch_array($res)) 
{ array_push($result, array('data_id'=>$row[0],'data_grade'=>$row[1],'data_grade1'=>$row[2],'data_gamok'=>$row[3],'data_jumsu'=>$row[4],'jungong'=>$row[5])); 
    if($row[5]==1){
        if($row[2]==1){
            $nowhak1+=$row[4];
            $nownhak1+=$row[4];
            $jun_count1+=1;
            $all_count1+=1;
        }
        else if($row[2]==2){
            $nowhak2+=$row[4];
            $nownhak2+=$row[4];
            $jun_count2+=1;
            $all_count2+=1;
        }
        else if($row[2]==3){
            $nowhak3+=$row[4];
            $nownhak3+=$row[4];
            $jun_count3+=1;
            $all_count3+=1;
        }
        else if($row[2]==4){
            $nowhak4+=$row[4];
            $nownhak4+=$row[4];
            $jun_count4+=1;
            $all_count4+=1;
        }
        $nowhak+=3;
    }
    else if($row[5]==0){
        if($row[2]==1){
            $nownhak1+=$row[4];
            $all_count1+=1;
        }
        else if($row[2]==2){
            $nownhak2+=$row[4];
            $all_count2+=1;
        }
        else if($row[2]==3){
            $nownhak3+=$row[4];
            $all_count3+=1;
        }
        else if($row[2]==4){
            $nownhak4+=$row[4];
            $all_count4+=1;
        }
        $nownhak+=3;
    }

} 
if($nowhak1!=0||$jun_count1!=0){
    $result_nowhak1=(float)($nowhak1/$jun_count1);
}
else{
    $result_nowhak1=0;
}
if($nowhak1!=0||$jun_count2!=0){
    $result_nowhak2=(float)($nowhak2/$jun_count2);
}
else{
    $result_nowhak2=0;
}
if($nowhak1!=0||$jun_count3!=0){
    $result_nowhak3=(float)($nowhak3/$jun_count3);
}
else{
    $result_nowhak3=0;
}
if($nowhak1!=0||$jun_count4!=0){
    $result_nowhak4=(float)($nowhak4/$jun_count4);
}
else{
    $result_nowhak4=0;
}



if($nownhak1!=0||$all_count1!=0){
    $result_nownhak1=(float)($nownhak1/$all_count1);
}
else{
    $result_nownhak1=0;
}
if($nowhak1!=0||$all_count2!=0){
    $result_nownhak2=(float)($nownhak2/$all_count2);
}
else{
    $result_nownhak2=0;
}
if($nowhak1!=0||$all_count3!=0){
    $result_nownhak3=(float)($nownhak3/$all_count3);
}
else{
    $result_nownhak3=0;
}
if($nowhak1!=0||$all_count4!=0){
    $result_nownhak4=(float)($nownhak4/$all_count4);
}
else{
    $result_nownhak4=0;
}

$result_jun = ($pil1+$pil2+$pil3+$pil4)-$nowhak;
$result_juns =($npil1+$npil2+$npil3+$npil4)-$nownhak;
if($result_jun<=0){
    $result=0;
}
else{
    $result=1;
}
$nowpil=$nownhak+$nowhak;
$myObj = new stdClass();
$myObj->id=$id;
$myObj->pil=$pil;
$myObj->nowpil=$nowpil;
$myObj->nowhak1=$result_nowhak1;
$myObj->nowhak2=$result_nowhak2;
$myObj->nowhak3=$result_nowhak3;
$myObj->nowhak4=$result_nowhak4;
$myObj->nownhak1=$result_nownhak1;
$myObj->nownhak2=$result_nownhak2;
$myObj->nownhak3=$result_nownhak3;
$myObj->nownhak4=$result_nownhak4;
$myObj->result_jun=$result_jun;
$myObj->result_juns=$result_juns;
$myObj->result1=$result;


echo $myJSON=json_encode($myObj);
// 배열형식의 결과를 json으로 변환 
// echo json_encode(array($result),JSON_UNESCAPED_UNICODE); 


mysqli_close($con); 


?>