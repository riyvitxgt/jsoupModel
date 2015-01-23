mybatis:There is no getter for property named 'xx'

原因:
mybatis默认采用ONGL解析参数,所以会自动采用对象树形式的string.xx值,引起报错

解决方案:
1.在mapper.xml文件中
	<if test = " _parameter!=null and_parameter!='' ">
		AND num = #{_parameter}
		
	使用_parameter指明它是一个参数,只能用_parameter,用其它的如_xx都不行
2.在mapper接口中使用@Param(value="xx")去指明参数,并且为要用xx去获取
	getRecordCount(@Param(value="title")String _title);
	
	<if test = "title!=null and title!='' ">
		AND num = #{title}
