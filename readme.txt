mybatis:There is no getter for property named 'xx'

ԭ��:
mybatisĬ�ϲ���ONGL��������,���Ի��Զ����ö�������ʽ��string.xxֵ,���𱨴�

�������:
1.��mapper.xml�ļ���
	<if test = " _parameter!=null and_parameter!='' ">
		AND num = #{_parameter}
		
	ʹ��_parameterָ������һ������,ֻ����_parameter,����������_xx������
2.��mapper�ӿ���ʹ��@Param(value="xx")ȥָ������,����ΪҪ��xxȥ��ȡ
	getRecordCount(@Param(value="title")String _title);
	
	<if test = "title!=null and title!='' ">
		AND num = #{title}
