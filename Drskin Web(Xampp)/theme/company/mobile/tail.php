<?php
if (!defined('_GNUBOARD_')) exit; // 개별 페이지 접근 불가
?>
    </div>
</div>

<div id="ft">
    <div id="ft_copy">
        <div id="ft_company">
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=company">회사소개</a>
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=privacy">개인정보취급방침</a>
            <a href="<?php echo G5_BBS_URL; ?>/content.php?co_id=provision">서비스이용약관</a>
        </div>

        <p class="ft_info">TEL. 010-3611-3511 | FAX. 044-860-2392 <br>세종특별자치시 조치원읍 세종로 2639 <br>
        대표 : 오윤식 | 인스타그램 : @yes6six <br>개인정보관리책임자 : 오윤식</p>
        <p class="copyright">Copyright &copy; <b>Dr.skin</b> All rights reserved.</p>

        <a href="#" class="top_btn">상단으로</a>
    </div>
    <?php
    if(G5_DEVICE_BUTTON_DISPLAY && G5_IS_MOBILE) { ?>
    <a href="<?php echo get_device_change_url(); ?>" id="device_change">PC 버전으로 보기</a>
    <?php
    }
    if ($config['cf_analytics']) {
        echo $config['cf_analytics'];
    }
    ?>
</div>

<script>
$(function() {
    // 폰트 리사이즈 쿠키있으면 실행
    font_resize("container", get_cookie("ck_font_resize_rmv_class"), get_cookie("ck_font_resize_add_class"));
});
</script>

<?php
include_once(G5_THEME_PATH."/tail.sub.php");
?>