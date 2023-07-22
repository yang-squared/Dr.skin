<?php
//define('_INDEX_', true);
if (!defined('_GNUBOARD_')) exit; // 개별 페이지 접근 불가

if (G5_IS_MOBILE) {
    include_once(G5_THEME_MOBILE_PATH.'/index.php');
    return;
}

include_once(G5_THEME_PATH.'/index_head.php');
?>

<ul id="comp_bn">
    <li>
        <button type="button" class="accordion-toggle bubn_btn">피부암 진단 어플<span>닥터스킨</span></button>
        <div class="accordion-content default bubn_img">
            <img src="<?php echo G5_THEME_IMG_URL ?>/bu01.jpg" alt="닥터스킨">
            <div class="bubn_img_ov">
                <h3> 닥터스킨</h3>
                <p>피부암 진단 어플<br>Skin cancer diagnosis app</p>
                <a href="#">상세보기</a>
            </div>
        </div>
    </li>
    <li>
        <button type="button" class="accordion-toggle bubn_btn">가정에서 피부암 진단<span>닥터스킨</span></button>
        <div class="accordion-content  bubn_img">
            <img src="<?php echo G5_THEME_IMG_URL ?>/bu01.jpg" alt="닥터스킨">
            <div class="bubn_img_ov">
                <h3> 닥터스킨</h3>
                <p>가정집에서 진행하는 피부암 진단<br>Skin cancer diagnosis at home</p>
                <a href="#">상세보기</a>
            </div>
        </div>
    </li>
    <li>
        <button type="button" class="accordion-toggle bubn_btn">Dr.Skin<span>닥터스킨</span></button>
        <div class="accordion-content  bubn_img">
            <img src="<?php echo G5_THEME_IMG_URL ?>/bu01.jpg" alt="회사설명">
            <div class="bubn_img_ov">
                <h3> Dr.Skin</h3>
                <p>당신의 의사가 되어드립니다<br>be your Doctor</p>
                <a href="#">상세보기</a>
            </div>
        </div>
    </li>
</ul>
<script type="text/javascript">
  $(document).ready(function($) {
    $("#comp_bn").find(".accordion-toggle").click(function(){
        $(this).next().slideToggle('fast');
        $(".accordion-content").not($(this).next()).slideUp('fast');
    });
  });
</script>
<ul id="comp_if">
    <li  class="com_bg1">
        <h2>일일랭킹</h2>
        <p>닥터스킨 <br>
        오늘의 피부왕 확인</p>
        <a href="#">일일랭킹 바로가기</a>
    </li>
    <li  class="com_bg2">
        <h2>나눔의장</h2>
        <p>어려움을 겪는 <br>
        여러분의 이웃을 도와주세요</p>
        <a href="#">회사소개 바로가기</a>
    </li>
    <li class="com_bg3">
        <h2>개발자</h2>
        <p>닥터스킨 <br>
        개발자 확인하러 가기</p>
        <a href="#">개발자 바로가기</a>
    </li>
</ul>
<div id="comp_lt">
    <div class="li_notice">
        <?php
        // 이 함수가 바로 최신글을 추출하는 역할을 합니다.
        // 사용방법 : latest(스킨, 게시판아이디, 출력라인, 글자수);
        // 테마의 스킨을 사용하려면 theme/basic 과 같이 지정
        echo latest('theme/basic', 'notice', 4, 18);
        ?>
    </div>
    <div class="li_gall">
        <?php
        // 이 함수가 바로 최신글을 추출하는 역할을 합니다.
        // 사용방법 : latest(스킨, 게시판아이디, 출력라인, 글자수, 캐시타임, option);
        // 테마의 스킨을 사용하려면 theme/basic 과 같이 지정
        $options = array(
            'thumb_width'    => 143, // 썸네일 width
            'thumb_height'   => 89,  // 썸네일 height
            'content_length' => 40   // 간단내용 길이
        );
        echo latest('theme/gallery', 'gallery', 3, 25, 1, $options);
        ?>
    </div>
</div>
<?php
include_once(G5_THEME_PATH.'/tail.php');
?>