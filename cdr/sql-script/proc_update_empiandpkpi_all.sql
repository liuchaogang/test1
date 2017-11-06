ALTER PROCEDURE [dbo].[proc_update_empiandpkpi_all]
@empi varchar(50),
@pkPati varchar(50),
@oldPkPati VARCHAR(50)
AS
BEGIN
 SET NOCOUNT ON;
    DECLARE @tablename VARCHAR(100)

    DECLARE tablename CURSOR FOR
    SELECT DISTINCT a.name FROM sysobjects a,sysindexes b,syscolumns c
	WHERE a.id = b.id
	     AND a.type='U'
	     AND a.id = c.id
	     AND b.rows>0
	     AND c.name IN('empi','pk_pati')
	     AND a.name NOT IN('uh_dc_pi','uh_dc_pi_address','uh_dc_pi_linkman','uh_dc_pi_card','uh_dc_pi_cross_index')

    OPEN tablename
    FETCH NEXT FROM tablename INTO @tablename

    WHILE @@FETCH_STATUS = 0
    BEGIN
				EXEC('update set empi='''+@empi+''',pk_pati='''+@pkPati+''' where pk_pati='''+@oldPkPati+'''')
				FETCH NEXT FROM tablename INTO @tablename
    END

    CLOSE tablename
    DEALLOCATE tablename
END
GO

