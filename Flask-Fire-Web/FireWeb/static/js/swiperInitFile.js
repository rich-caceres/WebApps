
//var picHtml = '<div class="swiper-slide img"><picture><source srcset="{{url_for("static", filename="img/SlideShow/TL2.png")}}" /><img src="{{url_for("static", filename="img/SlideShow/TL2.webp")}}" alt="Tower2" class="img-fluid d-block w-100 imgpreset" /></picture ></div ><div class="swiper-slide img"><picture><source srcset="img/SlideShow/fflu.png" type="image/png" /><img src="img/SlideShow/fflu.webp" alt="Memorial Sunday Lineup" class="img-fluid d-block w-100 imgpreset" /></picture ></div ><div class="swiper-slide img"><picture><source srcset="img/SlideShow/ActionShot1.png" type="image/png" /><img src="img/SlideShow/ActionShot1.webp" class="img-fluid d-block w-100 imgpreset" /></picture></div><div class="swiper-slide img"><picture><source srcset="img/SlideShow/tmpm.png" type="image/png" /><img src="img/SlideShow/tmpm.webp" alt="Marfongelli/Koen Rich History" class="img-fluid d-block w-100 imgpreset" /></picture ></div ><div class="swiper-slide img"><picture><source srcset="img/SlideShow/HonorGuardcrop.png" type="image/png" /><img src="img/SlideShow/HonorGuardcrop.webp" class="img-fluid d-block w-100 imgpreset" /></picture></div><div class="swiper-slide img"><picture><source srcset="img/SlideShow/ffms.png" type="image/png" /><img src="img/SlideShow/ffms.webp" alt="Memorial Sunday" class="img-fluid d-block w-100 imgpreset" /></picture ></div >';
//document.getElementById('slideImageShow').innerHTML = picHtml;
var swiper3 = new Swiper('#carouselSwiper', {
    lazyload: {
        loadPrevNext: true,
        loadPrevNextAmount: 1,
        loadOnTransitionStart: true,
        elementClass: 'swiper-lazy',
        loadingClass: 'swiper-lazy-loading',
        loadedClass: 'swiper-lazy-loaded',
        preloaderClass: 'swiper-lazy-preloader'
    }, loop: true, speed: 2000, autoplay: { delay: 2500 }, plugins: [SwiperPluginAutoPlay, SwiperPluginLazyload] });
var swiper2 = new Swiper("#swiper2", { autoplay: { delay: 3500 }, pagination: { el: "#specOpsPage", clickable: true, bulletClass: "specOp__item", bulletActiveClass: "is-active" }, plugins: [SwiperPluginPagination, SwiperPluginAutoPlay] });
var swiper1 = new Swiper("#apparatusSwiper", { autoplay: { delay: 3500 }, pagination: { el: ".swiper-plugin-pagination", clickable: true, bulletClass: "swiper-plugin-pagination__item", bulletActiveClass: "is-active" }, plugins: [SwiperPluginPagination, SwiperPluginAutoPlay] });
window.addEventListener('resize', function () { swiper3.update(), swiper3.updateSize() }); new ResizeSensor(jQuery('#SPECOP'), () => { swiper2.update(), swiper2.updateSize() }); new ResizeSensor(jQuery('#collapseTwo'), () => { swiper1.update(), swiper1.updateSize() });