--主诊断标识 PDM里没有
ALTER TABLE uh_dc_pv_diag ADD flag_main char(1)
--确认诊断标识 0：确认 1：不确定 PDM里没有
ALTER TABLE uh_dc_pv_diag ADD flag_uncertainty char(1)
--患者编码
ALTER TABLE uh_dc_pv_diag ADD code_pati varchar(30)
--就诊类型编码
ALTER TABLE uh_dc_pv_diag ADD code_pvtype varchar(30)
--就诊类型名称
ALTER TABLE uh_dc_pv_diag ADD name_pvtype varchar(100)
--就诊编码
ALTER TABLE uh_dc_pv_diag ADD pvcode varchar(50)