baseUrl='http://localhost:8080/jg-h5Service/';

function initStr(object){
	if(!object){
		return "";
	}else{
		return object+"";
	}
}


function initNumToStr(object){
	if(!object){
		return "0";
	}else{
		return object+"";
	}
}

function getUrlParam(name) {
	var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	var r = window.location.search.substr(1).match(reg);
	if (r != null) return unescape(r[2]); return null;
	} 