<?php
if (!defined('_GNUBOARD_')) exit; // 개별 페이지 접근 불가

include_once(G5_THEME_MOBILE_PATH.'/head.php');
add_stylesheet('<link rel="stylesheet" href="'.G5_THEME_JS_URL.'/swiper.min.css">', 0);
add_javascript('<script src="'.G5_THEME_JS_URL.'/swiper.min.js"></script>', 10);

?>

<!--메인이미지-->
<div class="swiper-container">
    <div class="swiper-wrapper">
        <div class="swiper-slide">
            <div class="bn_txt">
                <h2>닥터스킨(Dr.skin) <br>피부암 진단 어플</h2>
                <p>Skin cancer diagnosis app<br>닥터스킨(Dr.Skin)과 함께
                <br>당신의 피부건강을 지켜주세요</p>
            </div>
        </div>
        <div class="swiper-slide">
            <div class="bn_txt">
            <h2>닥터스킨(Dr.skin) <br>피부암 진단 어플</h2>
                <p>Skin cancer diagnosis app<br>닥터스킨(Dr.Skin)과 함께
                <br>당신의 피부건강을 지켜주세요</p>
            </div>
        </div>
        <div class="swiper-slide">
            <div class="bn_txt">
            <h2>닥터스킨(Dr.skin) <br>피부암 진단 어플</h2>
                <p>Skin cancer diagnosis app<br>닥터스킨(Dr.Skin)과 함께
                <br>당신의 피부건강을 지켜주세요</p>
            </div>
        </div>
        <div class="swiper-slide">
            <div class="bn_txt">
            <h2>닥터스킨(Dr.skin) <br>피부암 진단 어플</h2>
                <p>Skin cancer diagnosis app<br>닥터스킨(Dr.Skin)과 함께
                <br>당신의 피부건강을 지켜주세요</p>
            </div>
        </div>
    </div>
    <!-- Add Pagination -->
    <div class="swiper-pagination"></div>
</div>

<script>
var swiper = new Swiper('.swiper-container', {
    pagination: '.swiper-pagination',
    paginationClickable: true
});
</script>

<!--메인이미지-->
<ul id="comp_if">
    <li  class="com_bg1">
        <a href="http://222.118.197.112:5008/"><img src="<?php echo G5_THEME_IMG_URL ?>/mobile/main_img1.jpg" alt="검사하기"></a>
        <h2>검사하기</h2>
        <p>일반 점인 양성모반과<br>
        악성 흑색종을 구별합니다</p>
        
    </li>
    <li  class="com_bg2">
        <a href="#"><img src="<?php echo G5_THEME_IMG_URL ?>/mobile/main_img2.jpg" alt="개발중"></a>
        <h2>개발중</h2>
        <p>개발중<br>
        개발중</p>
    </li>
    <li class="com_bg3">
        <a href="http://222.118.197.112:8080/Drskin/?device=mobile"><img src="<?php echo G5_THEME_IMG_URL ?>/mobile/main_img3.jpg" alt="새로고침"></a>
        <h2>새로고침</h2>
        <p>현재 접속중인 페이지를<br>
        새로고침하여 최신화합니다</p>
    </li>
</ul>






<!-- 메인화면 최신글 시작 -->

<?php
// 이 함수가 바로 최신글을 추출하는 역할을 합니다.
// 사용방법 : latest(스킨, 게시판아이디, 출력라인, 글자수);
// 테마의 스킨을 사용하려면 theme/basic 과 같이 지정
echo latest('theme/basic', 'notice', 4, 40);
?>
<div class="li_gall">
    <?php
    // 이 함수가 바로 최신글을 추출하는 역할을 합니다.
    // 사용방법 : latest(스킨, 게시판아이디, 출력라인, 글자수, 캐시타임, option);
    // 테마의 스킨을 사용하려면 theme/basic 과 같이 지정
    $options = array(
        'thumb_width'    => 400, // 썸네일 width
        'thumb_height'   => 250,  // 썸네일 height
    );
    echo latest('theme/gallery', 'gallery', 4, 55, 1, $options);
    ?>
</div>

<!-- 메인화면 최신글 끝 -->

<?php
include_once(G5_THEME_MOBILE_PATH.'/tail.php');
?>