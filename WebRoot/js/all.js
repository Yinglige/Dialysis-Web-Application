// JavaScript Document


//加入收藏
        function AddFavorite(sURL, sTitle) {
            sURL = encodeURI(sURL); 
        try{   
            window.external.addFavorite(sURL, sTitle);   
        }catch(e) {   
            try{   
                window.sidebar.addPanel(sTitle, sURL, "");   
            }catch (e) {   
                alert("Failed to join the favorites, please use Ctrl + D to add.Or set it manually in the browser.");}}}
    
    function SetHome(url){
        if (document.all) {
            document.body.style.behavior='url(#default#homepage)';
               document.body.setHomePage(url);
        }else{
            alert("Hello, your browser does not support the function of automatically setting the page as the homepage. Please set the page as the homepage manually in the browser!");}}


$(function(){
	jQuery(".focusBox").slide({ mainCell:".pic",effect:"left", autoPlay:true, delayTime:300});
	jQuery(".picScroll").slide({ mainCell:"ul", effect:"leftMarquee", vis:4, autoPlay:true, interTime:50, switchLoad:"_src" });
	})


























