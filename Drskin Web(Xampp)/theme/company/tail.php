<?php
if (!defined('_GNUBOARD_')) exit; // 개별 페이지 접근 불가

if (G5_IS_MOBILE) {
    include_once(G5_THEME_MOBILE_PATH.'/tail.php');
    return;
}
?>
        <a href="#hd" id="top_btn">상단으로</a>
    </div>
</div>

<!-- } 콘텐츠 끝 -->

<hr>

<!-- 하단 시작 { -->
<div id="ft">
    <div id="ft_wr">

        <div id="ft_copy">
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=privacy">개인정보취급방침</a>
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=provision">서비스이용약관</a>
            <a href="#">이메일추출방지정책</a>
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=company">회사소개</a>
            <a href="#">오시는길</a>   
            <a href="#">사이트맵</a>   
        </div>
        <div id="ft_company">
            <p class="ft_info">TEL. 010-3611-3511 FAX. 044-860-2392 세종특별자치시 조치원읍 세종로 2639 <br>
            대표 : 오윤식 인스타그램 : @yes6six 개인정보관리책임자 : 오윤식</p>
            <p class="ft_copy">Copyright &copy; <b>Dr.skin.</b> All rights reserved.</p>
        </div>
    </div>
</div>

<script>
$(function() {
    $("#top_btn").on("click", function() {
        $("html, body").animate({scrollTop:0}, '500');
        return false;
    });
});
</script>

<?php
if ($config['cf_analytics']) {
    echo $config['cf_analytics'];
}
?>
<div id="ft_dv">
<?php
if(G5_DEVICE_BUTTON_DISPLAY && !G5_IS_MOBILE) { ?>
<a href="<?php echo get_device_change_url(); ?>" id="device_change">모바일 버전으로 보기</a>
<?php
}

if ($config['cf_analytics']) {
    echo $config['cf_analytics'];
}
?>
</div>
<!-- } 하단 끝 -->

<?php
include_once(G5_THEME_PATH."/tail.sub.php");
?>