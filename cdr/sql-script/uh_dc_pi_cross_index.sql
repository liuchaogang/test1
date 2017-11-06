USE [MIP_DC_DEMO]
GO

/****** Object:  Table [dbo].[uh_dc_pi_cross_index]    Script Date: 2017/6/29 16:05:47 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[uh_dc_pi_cross_index](
	[pk_index] [int] IDENTITY(1,1) NOT NULL,
	[empi] [varchar](30) NULL,
	[pati_code] [varchar](30) NULL,
	[local_type_code] [varchar](30) NULL,
	[health_card_no] [varchar](50) NULL,
	[oupatient_no] [varchar](50) NULL,
	[inpatient_no] [varchar](50) NULL,
	[insurance_no] [varchar](50) NULL,
	[create_time] [datetime] NULL,
	[flag_del] [char](1) NULL,
	[edit_time] [datetime] NULL,
	[code_group] [varchar](50) NULL,
	[code_org] [varchar](50) NULL,
 CONSTRAINT [pk_uh_dc_pi_cx] PRIMARY KEY NONCLUSTERED
(
	[pk_index] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'交叉索引主键' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'pk_index'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'患者主索引ID' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'empi'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'患者本地ID' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'pati_code'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'患者类型' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'local_type_code'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'健康卡号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'health_card_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'门诊号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'oupatient_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'住院号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'inpatient_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'医保卡号' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'insurance_no'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'创建时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'create_time'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'删除标识' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'flag_del'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'编辑时间' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'edit_time'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'集团编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'code_group'
GO

EXEC sys.sp_addextendedproperty @name=N'MS_Description', @value=N'机构编码' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'uh_dc_pi_cross_index', @level2type=N'COLUMN',@level2name=N'code_org'
GO


