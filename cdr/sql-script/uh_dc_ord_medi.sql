--重量
ALTER TABLE uh_dc_ord_medi ADD weight numeric(14, 2)
--重量单位
ALTER TABLE uh_dc_ord_medi ADD unit_weight varchar(100)
--草药煎熬法编码
ALTER TABLE uh_dc_ord_medi ADD code_make varchar(30)
--草药煎熬法名称
ALTER TABLE uh_dc_ord_medi ADD name_make varchar(100)
