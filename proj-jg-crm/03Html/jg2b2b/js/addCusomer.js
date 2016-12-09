var detailedAddress = "<form class='form-horizontal m-top-md'><div class='form-group'><label class='col-sm-2 control-label'>详细地址</label><div class='col-sm-7'><input type='text' class='form-control'></div>	</div></form>";

$(document).ready(function() {
	$("#addAddress").click(function() {
		$("#detailedAddress").append(detailedAddress);
	});
	
	

	/*
	* 服务器地址,成功返回,失败返回参数格式依照jquery.ajax习惯;
	* 其他参数同WebUploader
	*/

	$('#as').diyUpload({
		url:'server/fileupload.php',
		success:function( data ) {
			console.info( data );
		},
		error:function( err ) {
			console.info( err );	
		},
		buttonText : '选择文件',
		chunked:true,
		// 分片大小
		chunkSize:512 * 1024,
		//最大上传的文件数量, 总文件大小,单个文件大小(单位字节);
		fileNumLimit:50,
		fileSizeLimit:500000 * 1024,
		fileSingleSizeLimit:50000 * 1024,
		accept: {}
	});
	
	
	
	
	
	
});

function fileFunction(){
	
	var inputSize = $(".fileStyle-box").size();
	
	alert(inputSize);
	
	var i = inputSize;
	
	for (;i <= inputSize; i++)
	{
	
	
		var fileStr = "<input class='fileStyle-box' type='file' name="
		+'uploadFile'
		+ i 
		+" />";
		
	
	}
	$(".fileStyle").append(fileStr);
}