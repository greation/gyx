			var start = {
			    dateCell: '#inpstart',
			    format: 'YYYY-MM-DD',
			    minDate: '1900-01-01', //设定最小日期为当前日期
				festival:true,
			    maxDate: '2099-06-16', //最大日期
			    isTime: true,
			    choosefun: function(datas){
			         end.minDate = datas; //开始日期选好后，重置结束日的最小日期
			    }
			};
			var end = {
			    dateCell: '#inpend',
			    format: 'YYYY-MM-DD',
			    minDate: '1900-01-01', //设定最小日期为当前日期
				festival:true,
			    maxDate: '2099-06-16', //最大日期
			    isTime: true,
			    choosefun: function(datas){
			         start.maxDate = datas; //将结束日的初始值设置为开始日的最大日期
			    }
			};
			jeDate(start);
			jeDate(end);