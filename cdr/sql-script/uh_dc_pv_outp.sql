--服务类型名称（号别名称）
ALTER TABLE uh_dc_pv_outp ADD name_srvtype varchar(200)
--挂号方式代码
ALTER TABLE uh_dc_pv_outp ADD code_reg_way varchar(50)
--挂号方式名称
ALTER TABLE uh_dc_pv_outp ADD name_reg_way varchar(200)
--挂号医生编码
ALTER TABLE uh_dc_pv_outp ADD code_psn_reg varchar(50)
--挂号医生名称
ALTER TABLE uh_dc_pv_outp ADD name_psn_reg varchar(200)