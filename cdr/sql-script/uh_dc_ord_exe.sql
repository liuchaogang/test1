--执行数量
ALTER TABLE uh_dc_ord_exe ADD num_ex numeric(14, 2)
--执行数量单位
ALTER TABLE uh_dc_ord_exe ADD unit_ex varchar(30)